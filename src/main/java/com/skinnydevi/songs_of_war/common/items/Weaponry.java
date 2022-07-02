package com.skinnydevi.songs_of_war.common.items;

import com.skinnydevi.songs_of_war.SongsOfWarMod;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class Weaponry {
	private static Item.Properties getWeaponProps(int durability) {
		return new Item.Properties().tab(SongsOfWarMod.WEAPONRY_TAB).defaultDurability(durability);
	}

	private static int getDamage(int damage) {
		return damage - 3;
	}

	private static float getUseSpeed(float speed) {
		return speed - 4F;
	}

	// WEAPONS
	public static final SwordItem STUBBY_AXE = new SwordItem(Tiers.IRON, getDamage(10), getUseSpeed(1),
			getWeaponProps(350));
	public static final SwordItem IRON_FORGED_SWORD = new SwordItem(Tiers.IRON, getDamage(7), getUseSpeed(1.4F),
			getWeaponProps(350));
	public static final SwordItem DIAMOND_FORGED_SWORD = new SwordItem(Tiers.DIAMOND, getDamage(9), getUseSpeed(2F),
			getWeaponProps(1650));

	// BLACKSMITHS
	public static final SwordItem IRON_BLACKSMITH_HAMMER = new SwordItem(Tiers.IRON, 0, 0, getWeaponProps(650));
	public static final SwordItem DIAMOND_BLACKSMITH_HAMMER = new SwordItem(Tiers.DIAMOND, 1, 0, getWeaponProps(1700));
}
