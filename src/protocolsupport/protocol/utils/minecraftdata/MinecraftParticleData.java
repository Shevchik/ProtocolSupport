package protocolsupport.protocol.utils.minecraftdata;

import java.util.Map.Entry;

import javax.annotation.CheckForSigned;
import javax.annotation.Nonnull;

import org.bukkit.NamespacedKey;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import protocolsupportbuildprocessor.Preload;

@Preload
public class MinecraftParticleData {

	private MinecraftParticleData() {
	}

	private static final Object2IntMap<String> nameToId = new Object2IntOpenHashMap<>();

	private static void register(String name, int id) {
		nameToId.put(name, id);
		nameToId.put(NamespacedKey.minecraft(name).toString(), id);
	}

	static {
		JsonObject rootObject = MinecraftDataResourceUtils.getResourceAsJsonObject("particle.json");
		for (Entry<String, JsonElement> particlenameidEntry : rootObject.entrySet()) {
			register(particlenameidEntry.getKey(), particlenameidEntry.getValue().getAsInt());
		}
	}

	public static @CheckForSigned int getIdByName(@Nonnull String id) {
		return nameToId.getOrDefault(id, -1);
	}

}
