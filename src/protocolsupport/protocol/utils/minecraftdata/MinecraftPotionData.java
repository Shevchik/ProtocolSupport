package protocolsupport.protocol.utils.minecraftdata;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import protocolsupport.utils.JsonUtils;
import protocolsupport.utils.ResourceUtils;
import protocolsupportbuildprocessor.Preload;

@Preload
public class MinecraftPotionData {

	private MinecraftPotionData() {
	}

	public static final int ID_NONE = 0;
	public static final int ID_MIN = 1;
	public static final int ID_MAX = 127;

	private static final String[] idToName = new String[ID_MAX + 1];

	private static void register(@Nonnegative int id, @Nonnull String name) {
		idToName[id] = name;
	}

	static {
		JsonObject rootObject = ResourceUtils.getAsJsonObject(MinecraftDataResourceUtils.getResourcePath("potions.json"));
		for (String potionidString : rootObject.keySet()) {
			register(Integer.parseInt(potionidString), JsonUtils.getString(rootObject, potionidString));
		}
	}

	public static @Nullable String getNameById(@Nonnegative int id) {
		if ((id >= 0) && (id < idToName.length)) {
			return idToName[id];
		} else {
			return null;
		}
	}

}
