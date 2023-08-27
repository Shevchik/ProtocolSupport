package protocolsupport.protocol.typeremapper.entity.format.metadata.types.object;

import protocolsupport.protocol.typeremapper.entity.format.metadata.object.value.NetworkEntityMetadataObjectIndexValueNoOpTransformer;
import protocolsupport.protocol.types.networkentity.metadata.NetworkEntityMetadataObjectIndexRegistry;
import protocolsupport.protocol.utils.ProtocolVersionsHelper;

public class DisplayBlockNetworkEntityMetadataTransformerFactory<R extends NetworkEntityMetadataObjectIndexRegistry.DisplayBlockIndexRegistry> extends DisplayNetworkEntityMetadataFormatTransformerFactory<R> {

	public static final DisplayBlockNetworkEntityMetadataTransformerFactory<NetworkEntityMetadataObjectIndexRegistry.DisplayBlockIndexRegistry> INSTANCE = new DisplayBlockNetworkEntityMetadataTransformerFactory<>(NetworkEntityMetadataObjectIndexRegistry.DisplayBlockIndexRegistry.INSTANCE);

	protected DisplayBlockNetworkEntityMetadataTransformerFactory(R registry) {
		super(registry);

		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(registry.BLOCK, 22), ProtocolVersionsHelper.UP_1_20);
	}

}
