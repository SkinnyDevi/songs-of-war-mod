package com.skinnydevi.songs_of_war.common.items;

import com.skinnydevi.songs_of_war.SongsOfWarMod;

import com.skinnydevi.songs_of_war.initializers.CreativeTabInit;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

/**
 * Main class that defines all Songs Of War weapons.
 */
public class Weaponry {

	// WEAPONS
	public static final SwordItem STUBBY_AXE = new SwordItem(Tiers.IRON, getDamage(10), getUseSpeed(1),
			getWeaponProps(350));
	public static final SwordItem IRON_GREATAXE = new SwordItem(Tiers.IRON, getDamage(11), getUseSpeed(1.3F),
			getWeaponProps(375));
	public static final SwordItem IRON_FORGED_SWORD = new SwordItem(Tiers.IRON, getDamage(7), getUseSpeed(1.4F),
			getWeaponProps(350));
	public static final SwordItem DIAMOND_FORGED_SWORD = new SwordItem(Tiers.DIAMOND, getDamage(9), getUseSpeed(2F),
			getWeaponProps(1650));
	public static final SwordItem IRON_BATTLE_AXE = new SwordItem(Tiers.IRON, getDamage(12), getUseSpeed(1.8F),
			getWeaponProps(450));
	public static final SwordItem DIAMOND_BATTLE_AXE = new SwordItem(Tiers.DIAMOND, getDamage(15), getUseSpeed(1.7F),
			getWeaponProps(1100));
	public static final SwordItem IRON_BLADE = new SwordItem(Tiers.IRON, getDamage(7), getUseSpeed(2.1F),
			getWeaponProps(150));
	public static final SwordItem DIAMOND_BLADE = new SwordItem(Tiers.DIAMOND, getDamage(11), getUseSpeed(2.3F),
			getWeaponProps(400));
	public static final SwordItem STONE_DAGGER = new SwordItem(Tiers.STONE, getDamage(3), getUseSpeed(1.7F),
			getWeaponProps(75));
	public static final SwordItem IRON_DAGGER = new SwordItem(Tiers.IRON, getDamage(5), getUseSpeed(2.2F),
			getWeaponProps(200));
	public static final SwordItem DIAMOND_DAGGER = new SwordItem(Tiers.DIAMOND, getDamage(6), getUseSpeed(2.7F),
			getWeaponProps(280));
	public static final SwordItem BLADED_STAFF = new SwordItem(Tiers.IRON, getDamage(9), getUseSpeed(1.4F),
			getWeaponProps(180));
	public static final SwordItem IRON_GREATSWORD = new SwordItem(Tiers.IRON, getDamage(8), getUseSpeed(1.6F),
			getWeaponProps(210));
	public static final SwordItem DIAMOND_GREATSWORD = new SwordItem(Tiers.DIAMOND, getDamage(11), getUseSpeed(1.8F),
			getWeaponProps(550));
	public static final SwordItem STONE_HALBERD = new SwordItem(Tiers.STONE, getDamage(4), getUseSpeed(1.3F),
			getWeaponProps(95));
	public static final SwordItem IRON_HALBERD = new SwordItem(Tiers.IRON, getDamage(6), getUseSpeed(1.3F),
			getWeaponProps(175));
	public static final SwordItem DIAMOND_HALBERD = new SwordItem(Tiers.DIAMOND, getDamage(7), getUseSpeed(1.3F),
			getWeaponProps(325));
	public static final SwordItem IRON_HALBERD_DOUBLE = new SwordItem(Tiers.IRON, getDamage(7), getUseSpeed(1.2F),
			getWeaponProps(225));
	public static final SwordItem DIAMOND_HALBERD_DOUBLE = new SwordItem(Tiers.DIAMOND, getDamage(8), getUseSpeed(1.2F),
			getWeaponProps(380));
	public static final SwordItem IRON_REFORGED_HALBERD = new SwordItem(Tiers.IRON, getDamage(7), getUseSpeed(1.4F),
			getWeaponProps(200));
	public static final SwordItem DIAMOND_REFORGED_HALBERD = new SwordItem(Tiers.DIAMOND, getDamage(8), getUseSpeed(1.4F),
			getWeaponProps(375));



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

	// BLACKSMITH'S TOOLS

	public static final SwordItem IRON_BLACKSMITH_HAMMER = new SwordItem(Tiers.IRON, 0, 0, getForgerProps(650));
	public static final SwordItem DIAMOND_BLACKSMITH_HAMMER = new SwordItem(Tiers.DIAMOND, 1, 0, getForgerProps(1700));

	// REGISTER TO CREATIVE TAB
	public static void addWeaponryTabContents() {
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(STUBBY_AXE);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(IRON_FORGED_SWORD);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(DIAMOND_FORGED_SWORD);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(IRON_BATTLE_AXE);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(DIAMOND_BATTLE_AXE);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(IRON_BLADE);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(DIAMOND_BLADE);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(DEATHSINGER_SWORD);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(TIDESINGER_STAFF);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(NESTORIS_STAFF);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(KALTARIS_STAFF);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(MENDORIS_STAFF);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(SENDARIS_STAFF);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(VOLTARIS_STAFF);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(STONE_DAGGER);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(IRON_DAGGER);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(DIAMOND_DAGGER);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(BLADED_STAFF);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(IRON_GREATAXE);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(IRON_GREATSWORD);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(DIAMOND_GREATSWORD);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(STONE_HALBERD);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(IRON_HALBERD);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(DIAMOND_HALBERD);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(IRON_HALBERD_DOUBLE);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(DIAMOND_HALBERD_DOUBLE);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(IRON_REFORGED_HALBERD);
		CreativeTabInit.WEAPONRY_TAB_ITEMS.add(DIAMOND_REFORGED_HALBERD);
	}

	public static void addForgeryTabContents() {
		CreativeTabInit.FORGERY_TAB_ITEMS.add(IRON_BLACKSMITH_HAMMER);
		CreativeTabInit.FORGERY_TAB_ITEMS.add(DIAMOND_BLACKSMITH_HAMMER);
	}

	// Helper Methods

	private static Item.Properties getWeaponProps(int durability) {
		return new Item.Properties().defaultDurability(durability);
	}

	private static Item.Properties getForgerProps(int durability) {
		return new Item.Properties().defaultDurability(durability);
	}

	private static int getDamage(int damage) {
		return damage - 3;
	}

	private static float getUseSpeed(float speed) {
		return speed - 4F;
	}
}
