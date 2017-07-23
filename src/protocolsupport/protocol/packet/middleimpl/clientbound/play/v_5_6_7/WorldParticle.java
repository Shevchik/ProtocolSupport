package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_5_6_7;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleWorldParticle;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.protocol.typeremapper.id.IdRemapper;
import protocolsupport.protocol.typeremapper.itemstack.ItemStackRemapper;
import protocolsupport.protocol.utils.minecraftdata.MinecraftData;
import protocolsupport.protocol.utils.types.Particle;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class WorldParticle extends MiddleWorldParticle {

	@Override
	public RecyclableCollection<ClientBoundPacketData> toData(ProtocolVersion version) {
		ClientBoundPacketData serializer = ClientBoundPacketData.create(ClientBoundPacket.PLAY_WORLD_PARTICLES_ID, version);
		Particle particle = Particle.getById(type);
		String name = particle.getName();
		switch (particle) {
			case ITEM_CRACK: {
				int itemstate = ItemStackRemapper.ITEM_ID_REMAPPING_REGISTRY.getTable(version).getRemap(MinecraftData.getItemStateFromIdAndData(adddata.get(0), adddata.get(1)));
				name += "_" + MinecraftData.getItemIdFromState(itemstate) + "_" + MinecraftData.getItemDataFromState(itemstate);
				break;
			}
			case BLOCK_CRACK:
			case BLOCK_DUST: {
				int blockstate = adddata.get(0);
				blockstate = IdRemapper.BLOCK.getTable(version).getRemap(MinecraftData.getBlockStateFromIdAndData(blockstate & 4095, blockstate >> 12));
				name += "_" + MinecraftData.getBlockIdFromState(blockstate) + "_" + MinecraftData.getBlockDataFromState(blockstate);
				break;
			}
			default: {
				break;
			}
		}
		StringSerializer.writeString(serializer, version, name);
		serializer.writeFloat(x);
		serializer.writeFloat(y);
		serializer.writeFloat(z);
		serializer.writeFloat(offX);
		serializer.writeFloat(offY);
		serializer.writeFloat(offZ);
		serializer.writeFloat(speed);
		serializer.writeInt(count);
		return RecyclableSingletonList.create(serializer);
	}

}
