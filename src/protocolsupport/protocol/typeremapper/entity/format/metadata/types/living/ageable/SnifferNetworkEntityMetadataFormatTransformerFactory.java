package protocolsupport.protocol.typeremapper.entity.format.metadata.types.living.ageable;

import protocolsupport.protocol.typeremapper.entity.format.metadata.object.value.NetworkEntityMetadataObjectIndexValueNoOpTransformer;
import protocolsupport.protocol.typeremapper.entity.format.metadata.types.base.AgeableNetworkEntityMetadataFormatTransformerFactory;
import protocolsupport.protocol.types.networkentity.metadata.NetworkEntityMetadataObjectIndexRegistry;
import protocolsupport.protocol.utils.ProtocolVersionsHelper;

public class SnifferNetworkEntityMetadataFormatTransformerFactory<R extends NetworkEntityMetadataObjectIndexRegistry.SnifferIndexRegistry> extends AgeableNetworkEntityMetadataFormatTransformerFactory<R> {

	public static final SnifferNetworkEntityMetadataFormatTransformerFactory<NetworkEntityMetadataObjectIndexRegistry.SnifferIndexRegistry> INSTANCE = new SnifferNetworkEntityMetadataFormatTransformerFactory<>(NetworkEntityMetadataObjectIndexRegistry.SnifferIndexRegistry.INSTANCE);

	protected SnifferNetworkEntityMetadataFormatTransformerFactory(R registry) {
		super(registry);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(registry.STATE, 17), ProtocolVersionsHelper.UP_1_20);
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(registry.DROP_SEED_TIME, 18), ProtocolVersionsHelper.UP_1_20);
	}

}
