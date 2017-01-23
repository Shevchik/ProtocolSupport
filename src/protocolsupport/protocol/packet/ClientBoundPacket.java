package protocolsupport.protocol.packet;

import protocolsupport.zplatform.ServerPlatform;

public class ClientBoundPacket {

	public static final int LOGIN_DISCONNECT_ID = ServerPlatform.get().getPacketFactory().getOutLoginDisconnectPacketId();
	public static final int LOGIN_ENCRYPTION_BEGIN_ID = ServerPlatform.get().getPacketFactory().getOutLoginEncryptionBeginPacketId();
	public static final int LOGIN_SUCCESS_ID = ServerPlatform.get().getPacketFactory().getOutLoginSuccessPacketId();
	public static final int LOGIN_SET_COMPRESSION_ID = ServerPlatform.get().getPacketFactory().getOutLoginSetCompressionPacketId();
	public static final int STATUS_SERVER_INFO_ID = ServerPlatform.get().getPacketFactory().getOutStatusServerInfoPacketId();
	public static final int STATUS_PONG_ID = ServerPlatform.get().getPacketFactory().getOutStatusPongPacketId();
	public static final int PLAY_KEEP_ALIVE_ID = ServerPlatform.get().getPacketFactory().getOutPlayKeepAlivePacketId();
	public static final int PLAY_LOGIN_ID = ServerPlatform.get().getPacketFactory().getOutPlayLoginPacketId();
	public static final int PLAY_CHAT_ID = ServerPlatform.get().getPacketFactory().getOutPlayChatPacketId();
	public static final int PLAY_UPDATE_TIME_ID = ServerPlatform.get().getPacketFactory().getOutPlayUpdateTimePacketId();
	public static final int PLAY_ENTITY_EQUIPMENT_ID = ServerPlatform.get().getPacketFactory().getOutPlayEntityEquipmentPacketId();
	public static final int PLAY_SPAWN_POSITION_ID = ServerPlatform.get().getPacketFactory().getOutPlaySpawnPositionPacketId();
	public static final int PLAY_UPDATE_HEALTH_ID = ServerPlatform.get().getPacketFactory().getOutPlayUpdateHealthPacketId();
	public static final int PLAY_RESPAWN_ID = ServerPlatform.get().getPacketFactory().getOutPlayRespawnPacketId();
	public static final int PLAY_POSITION_ID = ServerPlatform.get().getPacketFactory().getOutPlayPositionPacketId();
	public static final int PLAY_HELD_SLOT_ID = ServerPlatform.get().getPacketFactory().getOutPlayHeldSlotPacketId();
	public static final int PLAY_BED_ID = ServerPlatform.get().getPacketFactory().getOutPlayBedPacketId();
	public static final int PLAY_ANIMATION_ID = ServerPlatform.get().getPacketFactory().getOutPlayAnimationPacketId();
	public static final int PLAY_SPAWN_NAMED_ID = ServerPlatform.get().getPacketFactory().getOutPlaySpawnNamedPacketId();
	public static final int PLAY_COLLECT_EFFECT_ID = ServerPlatform.get().getPacketFactory().getOutPlayCollectEffectPacketId();
	public static final int PLAY_SPAWN_OBJECT_ID = ServerPlatform.get().getPacketFactory().getOutPlaySpawnObjectPacketId();
	public static final int PLAY_SPAWN_LIVING_ID = ServerPlatform.get().getPacketFactory().getOutPlaySpawnLivingPacketId();
	public static final int PLAY_SPAWN_PAINTING_ID = ServerPlatform.get().getPacketFactory().getOutPlaySpawnPaintingPacketId();
	public static final int PLAY_SPAWN_EXP_ORB_ID = ServerPlatform.get().getPacketFactory().getOutPlaySpawnExpOrbPacketId();
	public static final int PLAY_ENTITY_VELOCITY_ID = ServerPlatform.get().getPacketFactory().getOutPlayEntityVelocityPacketId();
	public static final int PLAY_ENTITY_DESTROY_ID = ServerPlatform.get().getPacketFactory().getOutPlayEntityDestroyPacketId();
	public static final int PLAY_ENTITY_ID = ServerPlatform.get().getPacketFactory().getOutPlayEntityPacketId();
	public static final int PLAY_ENTITY_REL_MOVE_ID = ServerPlatform.get().getPacketFactory().getOutPlayEntityRelMovePacketId();
	public static final int PLAY_ENTITY_LOOK_ID = ServerPlatform.get().getPacketFactory().getOutPlayEntityLookPacketId();
	public static final int PLAY_ENTITY_REL_MOVE_LOOK_ID = ServerPlatform.get().getPacketFactory().getOutPlayEntityRelMoveLookPacketId();
	public static final int PLAY_ENTITY_TELEPORT_ID = ServerPlatform.get().getPacketFactory().getOutPlayEntityTeleportPacketId();
	public static final int PLAY_ENTITY_HEAD_ROTATION_ID = ServerPlatform.get().getPacketFactory().getOutPlayEntityHeadRotationPacketId();
	public static final int PLAY_ENTITY_STATUS_ID = ServerPlatform.get().getPacketFactory().getOutPlayEntityStatusPacketId();
	public static final int PLAY_ENTITY_LEASH_ID = ServerPlatform.get().getPacketFactory().getOutPlayEntityLeashPacketId();
	public static final int PLAY_ENTITY_METADATA_ID = ServerPlatform.get().getPacketFactory().getOutPlayEntityMetadataPacketId();
	public static final int PLAY_ENTITY_EFFECT_ADD_ID = ServerPlatform.get().getPacketFactory().getOutPlayEntityEffectAddPacketId();
	public static final int PLAY_ENTITY_EFFECT_REMOVE_ID = ServerPlatform.get().getPacketFactory().getOutPlayEntityEffectRemovePacketId();
	public static final int PLAY_EXPERIENCE_ID = ServerPlatform.get().getPacketFactory().getOutPlayExperiencePacketId();
	public static final int PLAY_ENTITY_ATTRIBUTES_ID = ServerPlatform.get().getPacketFactory().getOutPlayEntityAttributesPacketId();
	public static final int PLAY_CHUNK_SINGLE_ID = ServerPlatform.get().getPacketFactory().getOutPlayChunkSinglePacketId();
	public static final int PLAY_BLOCK_CHANGE_MULTI_ID = ServerPlatform.get().getPacketFactory().getOutPlayBlockChangeMultiPacketId();
	public static final int PLAY_BLOCK_CHANGE_SINGLE_ID = ServerPlatform.get().getPacketFactory().getOutPlayBlockChangeSinglePacketId();
	public static final int PLAY_BLOCK_ACTION_ID = ServerPlatform.get().getPacketFactory().getOutPlayBlockActionPacketId();
	public static final int PLAY_BLOCK_BREAK_ANIMATION_ID = ServerPlatform.get().getPacketFactory().getOutPlayBlockBreakAnimationPacketId();
	public static final int PLAY_EXPLOSION_ID = ServerPlatform.get().getPacketFactory().getOutPlayExplosionPacketId();
	public static final int PLAY_WORLD_EVENT_ID = ServerPlatform.get().getPacketFactory().getOutPlayWorldEventPacketId();
	public static final int PLAY_WORLD_SOUND_ID = ServerPlatform.get().getPacketFactory().getOutPlayWorldSoundPacketId();
	public static final int PLAY_WORLD_PARTICLES_ID = ServerPlatform.get().getPacketFactory().getOutPlayWorldParticlesPacketId();
	public static final int PLAY_GAME_STATE_CHANGE_ID = ServerPlatform.get().getPacketFactory().getOutPlayGameStateChangePacketId();
	public static final int PLAY_SPAWN_WEATHER_ID = ServerPlatform.get().getPacketFactory().getOutPlaySpawnWeatherPacketId();
	public static final int PLAY_WINDOW_OPEN_ID = ServerPlatform.get().getPacketFactory().getOutPlayWindowOpenPacketId();
	public static final int PLAY_WINDOW_CLOSE_ID = ServerPlatform.get().getPacketFactory().getOutPlayWindowClosePacketId();
	public static final int PLAY_WINDOW_SET_SLOT_ID = ServerPlatform.get().getPacketFactory().getOutPlayWindowSetSlotPacketId();
	public static final int PLAY_WINDOW_SET_ITEMS_ID = ServerPlatform.get().getPacketFactory().getOutPlayWindowSetItemsPacketId();
	public static final int PLAY_WINDOW_DATA_ID = ServerPlatform.get().getPacketFactory().getOutPlayWindowDataPacketId();
	public static final int PLAY_WINDOW_TRANSACTION_ID = ServerPlatform.get().getPacketFactory().getOutPlayWindowTransactionPacketId();
	public static final int PLAY_MAP_ID = ServerPlatform.get().getPacketFactory().getOutPlayMapPacketId();
	public static final int PLAY_UPDATE_TILE_ID = ServerPlatform.get().getPacketFactory().getOutPlayUpdateTilePacketId();
	public static final int PLAY_SIGN_EDITOR_ID = ServerPlatform.get().getPacketFactory().getOutPlaySignEditorPacketId();
	public static final int PLAY_STATISTICS_ID = ServerPlatform.get().getPacketFactory().getOutPlayStatisticsPacketId();
	public static final int PLAY_PLAYER_INFO_ID = ServerPlatform.get().getPacketFactory().getOutPlayPlayerInfoPacketId();
	public static final int PLAY_ABILITIES_ID = ServerPlatform.get().getPacketFactory().getOutPlayAbilitiesPacketId();
	public static final int PLAY_TAB_COMPLETE_ID = ServerPlatform.get().getPacketFactory().getOutPlayTabCompletePacketId();
	public static final int PLAY_SCOREBOARD_OBJECTIVE_ID = ServerPlatform.get().getPacketFactory().getOutPlayScoreboardObjectivePacketId();
	public static final int PLAY_SCOREBOARD_SCORE_ID = ServerPlatform.get().getPacketFactory().getOutPlayScoreboardScorePacketId();
	public static final int PLAY_SCOREBOARD_DISPLAY_SLOT_ID = ServerPlatform.get().getPacketFactory().getOutPlayScoreboardDisplaySlotPacketId();
	public static final int PLAY_SCOREBOARD_TEAM_ID = ServerPlatform.get().getPacketFactory().getOutPlayScoreboardTeamPacketId();
	public static final int PLAY_CUSTOM_PAYLOAD_ID = ServerPlatform.get().getPacketFactory().getOutPlayCustomPayloadPacketId();
	public static final int PLAY_KICK_DISCONNECT_ID = ServerPlatform.get().getPacketFactory().getOutPlayKickDisconnectPacketId();
	public static final int PLAY_RESOURCE_PACK_ID = ServerPlatform.get().getPacketFactory().getOutPlayResourcePackPacketId();
	public static final int PLAY_CAMERA_ID = ServerPlatform.get().getPacketFactory().getOutPlayCameraPacketId();
	public static final int PLAY_WORLD_BORDER_ID = ServerPlatform.get().getPacketFactory().getOutPlayWorldBorderPacketId();
	public static final int PLAY_TITLE_ID = ServerPlatform.get().getPacketFactory().getOutPlayTitlePacketId();
	public static final int PLAY_PLAYER_LIST_HEADER_FOOTER_ID = ServerPlatform.get().getPacketFactory().getOutPlayPlayerListHeaderFooterPacketId();
	public static final int PLAY_SET_PASSENGERS_ID = ServerPlatform.get().getPacketFactory().getOutPlaySetPassengersPacketId();
	public static final int PLAY_CHUNK_UNLOAD_ID = ServerPlatform.get().getPacketFactory().getOutPlayChunkUnloadPacketId();
	public static final int PLAY_WORLD_CUSTOM_SOUND_ID = ServerPlatform.get().getPacketFactory().getOutPlayWorldCustomSoundPacketId();
	public static final int PLAY_SERVER_DIFFICULTY_ID = ServerPlatform.get().getPacketFactory().getOutPlayServerDifficultyPacketId();
	public static final int PLAY_COMBAT_EVENT_ID = ServerPlatform.get().getPacketFactory().getOutPlayCombatEventPacketId();
	public static final int PLAY_BOSS_BAR_ID = ServerPlatform.get().getPacketFactory().getOutPlayBossBarPacketId();
	public static final int PLAY_SET_COOLDOWN_ID = ServerPlatform.get().getPacketFactory().getOutPlaySetCooldownPacketId();
	public static final int PLAY_VEHICLE_MOVE_ID = ServerPlatform.get().getPacketFactory().getOutPlayVehicleMovePacketId();

	public static final int LEGACY_PLAY_UPDATE_SIGN_ID = 100;

	public static void init() {
	}

}
