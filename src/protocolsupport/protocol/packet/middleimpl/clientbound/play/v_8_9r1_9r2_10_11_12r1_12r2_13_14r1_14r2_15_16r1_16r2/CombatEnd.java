package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleCombatEnd;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public class CombatEnd extends MiddleCombatEnd {

	public CombatEnd(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void write() {
		ClientBoundPacketData combatendPacket = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_COMBAT_END);
		VarNumberSerializer.writeVarInt(combatendPacket, 1); //action (1 - end)
		VarNumberSerializer.writeVarInt(combatendPacket, duration);
		combatendPacket.writeInt(opponentId);
		codec.writeClientbound(combatendPacket);
	}

}