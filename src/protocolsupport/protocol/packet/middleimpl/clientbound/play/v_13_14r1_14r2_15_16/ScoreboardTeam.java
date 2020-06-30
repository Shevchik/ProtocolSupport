package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13_14r1_14r2_15_16;

import protocolsupport.api.chat.ChatAPI;
import protocolsupport.protocol.ConnectionImpl;
import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleScoreboardTeam;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.ArraySerializer;
import protocolsupport.protocol.serializer.MiscSerializer;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.protocol.storage.netcache.ClientCache;
import protocolsupport.protocol.typeremapper.legacy.chat.LegacyChatJson;

public class ScoreboardTeam extends MiddleScoreboardTeam {

	public ScoreboardTeam(ConnectionImpl connection) {
		super(connection);
	}

	protected final ClientCache clientCache = cache.getClientCache();

	@Override
	protected void writeToClient() {
		String locale = clientCache.getLocale();

		ClientBoundPacketData scoreboardteam = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_SCOREBOARD_TEAM);
		StringSerializer.writeVarIntUTF8String(scoreboardteam, name);
		MiscSerializer.writeByteEnum(scoreboardteam, mode);
		if ((mode == Mode.CREATE) || (mode == Mode.UPDATE)) {
			StringSerializer.writeVarIntUTF8String(scoreboardteam, ChatAPI.toJSON(LegacyChatJson.convert(version, locale, displayName)));
			scoreboardteam.writeByte(friendlyFire);
			StringSerializer.writeVarIntUTF8String(scoreboardteam, nameTagVisibility);
			StringSerializer.writeVarIntUTF8String(scoreboardteam, collisionRule);
			MiscSerializer.writeVarIntEnum(scoreboardteam, format);
			StringSerializer.writeVarIntUTF8String(scoreboardteam, ChatAPI.toJSON(LegacyChatJson.convert(version, locale, prefix)));
			StringSerializer.writeVarIntUTF8String(scoreboardteam, ChatAPI.toJSON(LegacyChatJson.convert(version, locale, suffix)));
		}
		if ((mode == Mode.CREATE) || (mode == Mode.PLAYERS_ADD) || (mode == Mode.PLAYERS_REMOVE)) {
			ArraySerializer.writeVarIntVarIntUTF8StringArray(scoreboardteam, players);
		}
		codec.write(scoreboardteam);
	}

}
