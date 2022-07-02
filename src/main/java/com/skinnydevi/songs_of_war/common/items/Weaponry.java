package com.skinnydevi.songs_of_war.common.items;

import com.skinnydevi.songs_of_war.SongsOfWarMod;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class Weaponry {
	private static Item.Properties getWeaponProps(int durability) {
		return new Item.Properties().tab(SongsOfWarMod.WEAPONRY_TAB).defaultDurability(durability);
	}

	// WEAPONS
	public static final SwordItem STUBBY_AXE = new SwordItem(Tiers.IRON, 7, -3F,
			getWeaponProps(350));

	// BLACKSMITHS
	public static final SwordItem IRON_BLACKSMITH_HAMMER = new SwordItem(Tiers.IRON, 0, 0, getWeaponProps(650));
	public static final SwordItem DIAMOND_BLACKSMITH_HAMMER = new SwordItem(Tiers.DIAMOND, 1, 0, getWeaponProps(1700));
}
