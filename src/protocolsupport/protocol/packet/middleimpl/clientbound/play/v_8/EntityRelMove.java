package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_8;

import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleEntityRelMove;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.VarNumberSerializer;
import protocolsupport.protocol.typeremapper.legacy.LegacyRelMoveConverter;
import protocolsupport.protocol.typeremapper.legacy.LegacyRelMoveConverter.RelMove;
import protocolsupport.protocol.utils.types.networkentity.NetworkEntity;
import protocolsupport.protocol.utils.types.networkentity.NetworkEntityRelRemainderCache;
import protocolsupport.utils.recyclable.RecyclableArrayList;
import protocolsupport.utils.recyclable.RecyclableCollection;

public class EntityRelMove extends MiddleEntityRelMove {
	protected void addRemainder() {
		NetworkEntity watchedEntity = cache.getWatchedEntityCache().getWatchedEntity(entityId);
		if (watchedEntity != null) {
			NetworkEntityRelRemainderCache remainderCache = watchedEntity.getRelRemainderCache();
			relX += remainderCache.getX();
			relY += remainderCache.getY();
			relZ += remainderCache.getZ();
			remainderCache.setX(relX % 128);
			remainderCache.setY(relY % 128);
			remainderCache.setZ(relZ % 128);
		}
	}

	@Override
	public RecyclableCollection<ClientBoundPacketData> toData() {
		addRemainder();
		int relMoveX = relX / 128;
		int relMoveY = relY / 128;
		int relMoveZ = relZ / 128;
		RecyclableArrayList<ClientBoundPacketData> packets = RecyclableArrayList.create();
		for (RelMove relMove : LegacyRelMoveConverter.getRelMoves(new RelMove(relMoveX, relMoveY, relMoveZ), 127)) {
			ClientBoundPacketData serializer = ClientBoundPacketData.create(ClientBoundPacket.PLAY_ENTITY_REL_MOVE_ID);
			VarNumberSerializer.writeVarInt(serializer, entityId);
			serializer.writeByte(relMove.getX());
			serializer.writeByte(relMove.getY());
			serializer.writeByte(relMove.getZ());
			serializer.writeBoolean(onGround);
			packets.add(serializer);
		}
		return packets;
	}

}
