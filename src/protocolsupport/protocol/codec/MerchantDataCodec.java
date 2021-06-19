package protocolsupport.protocol.codec;

import io.netty.buffer.ByteBuf;
import protocolsupport.api.ProtocolType;
import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.types.MerchantData;
import protocolsupport.protocol.types.MerchantData.TradeOffer;
import protocolsupport.protocol.types.NetworkItemStack;

public class MerchantDataCodec {

	private MerchantDataCodec() {
	}

	public static MerchantData readMerchantData(ByteBuf from) {
		byte windowId = (byte) VarNumberCodec.readVarInt(from);
		TradeOffer[] offers = new TradeOffer[from.readUnsignedByte()];
		for (int i = 0; i < offers.length; i++) {
			NetworkItemStack itemstack1 = ItemStackCodec.readItemStack(from);
			NetworkItemStack result = ItemStackCodec.readItemStack(from);
			NetworkItemStack itemstack2 = NetworkItemStack.NULL;
			if (from.readBoolean()) {
				itemstack2 = ItemStackCodec.readItemStack(from);
			}
			boolean disabled = from.readBoolean();
			int uses = from.readInt();
			int maxuses = from.readInt();
			int xp = from.readInt();
			int specialPrice = from.readInt();
			float priceMultiplier = from.readFloat();
			int demand = from.readInt();
			offers[i] = new TradeOffer(
				itemstack1, itemstack2, result,
				disabled ? maxuses : uses, maxuses,
				xp, specialPrice, priceMultiplier, demand
			);
		}
		int villagerLevel = VarNumberCodec.readVarInt(from);
		int villagerXp = VarNumberCodec.readVarInt(from);
		boolean villagerRegular = from.readBoolean();
		boolean restockingVillager = from.readBoolean();
		return new MerchantData(windowId, offers, villagerLevel, villagerXp, villagerRegular, restockingVillager);
	}

	public static void writeMerchantData(ByteBuf to, ProtocolVersion version, String locale, MerchantData merchdata) {
		boolean advandedTrading = isUsingAdvancedTrading(version);
		boolean usesCount = isUsingUsesCount(version);
		if (advandedTrading) {
			VarNumberCodec.writeVarInt(to, merchdata.getWindowId());
		} else {
			to.writeInt(merchdata.getWindowId());
		}
		to.writeByte(merchdata.getOffers().length);
		for (TradeOffer offer : merchdata.getOffers()) {
			ItemStackCodec.writeItemStack(to, version, locale, offer.getItemStack1());
			ItemStackCodec.writeItemStack(to, version, locale, offer.getResult());
			to.writeBoolean(offer.hasItemStack2());
			if (offer.hasItemStack2()) {
				ItemStackCodec.writeItemStack(to, version, locale, offer.getItemStack2());
			}
			to.writeBoolean(offer.isDisabled());
			if (usesCount) {
				to.writeInt(offer.getUses());
				to.writeInt(offer.getMaxUses());
			}
			if (advandedTrading) {
				to.writeInt(offer.getXP());
				to.writeInt(offer.getSpecialPrice());
				to.writeFloat(offer.getPriceMultiplier());
			}
			if (isUsingDemand(version)) {
				to.writeInt(offer.getDemand());
			}
		}
		if (advandedTrading) {
			VarNumberCodec.writeVarInt(to, merchdata.getVillagerLevel());
			VarNumberCodec.writeVarInt(to, merchdata.getVillagerXP());
			to.writeBoolean(merchdata.isVillagerRegular());
			if (isUsingRestockingVillagerField(version)) {
				to.writeBoolean(merchdata.isRestockingVillager());
			}
		}
	}

	protected static boolean isUsingAdvancedTrading(ProtocolVersion version) {
		return (version.getProtocolType() == ProtocolType.PC) && version.isAfterOrEq(ProtocolVersion.MINECRAFT_1_14);
	}

	protected static boolean isUsingUsesCount(ProtocolVersion version) {
		return (version.getProtocolType() == ProtocolType.PC) && version.isAfterOrEq(ProtocolVersion.MINECRAFT_1_8);
	}

	protected static boolean isUsingRestockingVillagerField(ProtocolVersion version) {
		return (version.getProtocolType() == ProtocolType.PC) && version.isAfterOrEq(ProtocolVersion.MINECRAFT_1_14_3);
	}

	protected static boolean isUsingDemand(ProtocolVersion version) {
		return (version.getProtocolType() == ProtocolType.PC) && version.isAfterOrEq(ProtocolVersion.MINECRAFT_1_14_4);
	}
}