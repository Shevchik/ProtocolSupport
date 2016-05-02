package protocolsupport.protocol.transformer.middlepacketimpl.clientbound.play.v_1_8;

import java.io.IOException;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.ClientBoundPacket;
import protocolsupport.protocol.transformer.middlepacket.clientbound.play.MiddleChunk;
import protocolsupport.protocol.transformer.middlepacketimpl.PacketData;
import protocolsupport.protocol.transformer.utils.chunk.ChunkTransformer;
import protocolsupport.protocol.transformer.utils.chunk.ChunkUtils;
import protocolsupport.protocol.transformer.utils.chunk.EmptyChunk;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class Chunk extends MiddleChunk<RecyclableCollection<PacketData>>  {

	private final ChunkTransformer transformer = new ChunkTransformer();

	@Override
	public RecyclableCollection<PacketData> toData(ProtocolVersion version) throws IOException {
		PacketData serializer = PacketData.create(ClientBoundPacket.PLAY_CHUNK_SINGLE_ID, version);
		serializer.writeInt(chunkX);
		serializer.writeInt(chunkZ);
		serializer.writeBoolean(full);
		boolean hasSkyLight = ChunkUtils.hasSkyLight(player.getWorld());
		if (bitmask == 0 && full) {
			serializer.writeShort(1);
			serializer.writeArray(EmptyChunk.get18ChunkData(hasSkyLight));
		} else {
			serializer.writeShort(bitmask);
			transformer.loadData(data, bitmask, hasSkyLight, full);
			serializer.writeArray(transformer.to18Data());
		}
		return RecyclableSingletonList.create(serializer);
	}

}
