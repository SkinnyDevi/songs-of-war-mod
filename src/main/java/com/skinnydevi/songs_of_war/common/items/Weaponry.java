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

	public static final SwordItem DEATHSINGER_SWORD = new SwordItem(Tiers.NETHERITE, getDamage(24), getUseSpeed(2F),
			getWeaponProps(2400));
	public static final SwordItem TIDESINGER_STAFF = new SwordItem(Tiers.NETHERITE, getDamage(22), getUseSpeed(3F),
			getWeaponProps(2300));

	// CLAN STAFFS
	public static final SwordItem NESTORIS_STAFF = new SwordItem(Tiers.NETHERITE, getDamage(17), getUseSpeed(2),
			getWeaponProps(2400));
	public static final SwordItem KALTARIS_STAFF = new SwordItem(Tiers.NETHERITE, getDamage(19), getUseSpeed(2.3F),
			getWeaponProps(1400));
	public static final SwordItem MENDORIS_STAFF = new SwordItem(Tiers.NETHERITE, getDamage(13), getUseSpeed(1.5F),
			getWeaponProps(1550));
	public static final SwordItem SENDARIS_STAFF = new SwordItem(Tiers.NETHERITE, getDamage(18), getUseSpeed(1.9F),
			getWeaponProps(1350));
	public static final SwordItem VOLTARIS_STAFF = new SwordItem(Tiers.NETHERITE, getDamage(19), getUseSpeed(2.1F),
			getWeaponProps(1200));

	// BLACKSMITHS
	public static final SwordItem IRON_BLACKSMITH_HAMMER = new SwordItem(Tiers.IRON, 0, 0, getWeaponProps(650));
	public static final SwordItem DIAMOND_BLACKSMITH_HAMMER = new SwordItem(Tiers.DIAMOND, 1, 0, getWeaponProps(1700));
}
