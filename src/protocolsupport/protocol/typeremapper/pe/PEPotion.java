package protocolsupport.protocol.typeremapper.pe;

import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.map.hash.TObjectIntHashMap;
import protocolsupport.protocol.utils.minecraftdata.MinecraftData;

public class PEPotion {
	private static final TObjectIntHashMap<String> nameToPeId = new TObjectIntHashMap<String>();
	private static final TIntObjectHashMap<String> peIdToName = new TIntObjectHashMap<String>();
	
	static {
		register("mundane", 1);
		register("thick", 3);
		register("awkward", 4);
		
		register("regeneration", 28);
		register("swiftness", 14);
		register("fire_resistance", 12);
		register("poison", 25);
		register("healing", 21);
		register("night_vision", 5);
		register("weakness", 34);
		register("strength", 31);
		register("slowness", 17);
		register("leaping", 9);
		register("harming", 23);
		register("water_breathing", 19);
		register("invisibility", 7);

		register("strong_regeneration", 30);
		register("strong_leaping", 11);
		register("strong_swiftness", 16);
		register("strong_healing", 22);
		register("strong_harming", 24);
		register("strong_poison", 27);
		register("strong_strength", 33);

		register("long_mundane", 2);
		
		register("long_night_vision", 6);
		register("long_invisibility", 8);
		register("long_leaping", 10);
		register("long_fire_resistance", 13);
		register("long_swiftness", 15);
		register("long_slowness", 18);
		register("long_water_breathing", 20);
		register("long_poison", 26);
		register("long_regeneration", 29);
		register("long_strength", 32);
		register("long_weakness", 35);
	}
	
	private static void register(String name, int id) {
		nameToPeId.put(name, id);
		nameToPeId.put(MinecraftData.addNamespacePrefix(name), id);
		peIdToName.put(id, MinecraftData.addNamespacePrefix(name));
	}
	
	public static boolean hasPERemap(String nbttag) {
		return nameToPeId.containsKey(nbttag);
	}
	
	public static int toPEId(String nbttag) {
		return nameToPeId.get(nbttag);
	}
	
	public static String fromPEId(int id) {
		return peIdToName.get(id);
	}
	
}
