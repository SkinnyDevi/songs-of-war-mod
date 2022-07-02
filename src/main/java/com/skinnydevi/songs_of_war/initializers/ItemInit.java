package com.skinnydevi.songs_of_war.initializers;

import com.skinnydevi.songs_of_war.SongsOfWarMod;
import com.skinnydevi.songs_of_war.common.items.Weaponry;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			SongsOfWarMod.MOD_ID);

	// WEAPONRY
	public static final RegistryObject<Item> STUBBY_AXE = ITEMS.register("stubby_axe", () -> Weaponry.STUBBY_AXE);
	public static final RegistryObject<Item> IRON_FORGED_SWORD = ITEMS.register("iron_forged_sword",
			() -> Weaponry.IRON_FORGED_SWORD);
	public static final RegistryObject<Item> DIAMOND_FORGED_SWORD = ITEMS.register("diamond_forged_sword",
			() -> Weaponry.DIAMOND_FORGED_SWORD);

	public static final RegistryObject<Item> NESTORIS_STAFF = ITEMS.register("nestoris_staff",
			() -> Weaponry.NESTORIS_STAFF);
	public static final RegistryObject<Item> KALTARIS_STAFF = ITEMS.register("kaltaris_staff",
			() -> Weaponry.KALTARIS_STAFF);
	public static final RegistryObject<Item> MENDORIS_STAFF = ITEMS.register("mendoris_staff",
			() -> Weaponry.MENDORIS_STAFF);
	public static final RegistryObject<Item> SENDARIS_STAFF = ITEMS.register("sendaris_staff",
			() -> Weaponry.SENDARIS_STAFF);
	public static final RegistryObject<Item> VOLTARIS_STAFF = ITEMS.register("voltaris_staff",
			() -> Weaponry.VOLTARIS_STAFF);

	public static final RegistryObject<Item> DEATHSINGER_SWORD = ITEMS.register("deathsinger_sword",
			() -> Weaponry.DEATHSINGER_SWORD);
	public static final RegistryObject<Item> TIDESINGER_STAFF = ITEMS.register("tidesinger_staff",
			() -> Weaponry.TIDESINGER_STAFF);

	// BLACKSMITHS
	public static final RegistryObject<Item> IRON_BLACKSMITH_HAMMER = ITEMS.register("iron_blacksmith_hammer",
			() -> Weaponry.IRON_BLACKSMITH_HAMMER);
	public static final RegistryObject<Item> DIAMOND_BLACKSMITH_HAMMER = ITEMS.register("diamond_blacksmith_hammer",
			() -> Weaponry.DIAMOND_BLACKSMITH_HAMMER);
}
