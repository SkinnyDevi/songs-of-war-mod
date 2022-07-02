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

	// BLACKSMITHS
	public static final RegistryObject<Item> IRON_BLACKSMITH_HAMMER = ITEMS.register("iron_blacksmith_hammer",
			() -> Weaponry.IRON_BLACKSMITH_HAMMER);
	public static final RegistryObject<Item> DIAMOND_BLACKSMITH_HAMMER = ITEMS.register("diamond_blacksmith_hammer",
			() -> Weaponry.DIAMOND_BLACKSMITH_HAMMER);
}
