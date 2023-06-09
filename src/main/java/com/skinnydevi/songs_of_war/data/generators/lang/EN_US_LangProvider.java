package com.skinnydevi.songs_of_war.data.generators.lang;

import com.skinnydevi.songs_of_war.SongsOfWarMod;
import com.skinnydevi.songs_of_war.initializers.BlockInit;
import com.skinnydevi.songs_of_war.initializers.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class EN_US_LangProvider extends LanguageProvider {

	public EN_US_LangProvider(PackOutput pckout) {
		super(pckout, SongsOfWarMod.MOD_ID, "en_us");
	}

	// private static String customdeath(String type) {
	// return "death.attack." + SongsOfWarMod.MOD_ID + "." + type;
	// }

	@Override
	protected void addTranslations() {
		// CREATIVE TABS
		add("itemGroup.sow_weapons_tab", "Songs Of War Weaponry");
		add("itemGroup.sow_forgery_tab", "Songs Of War Forgery");

		// ITEMS

		// Weapons
		add(ItemInit.STUBBY_AXE.get(), "Stubby Axe");
		add(ItemInit.IRON_FORGED_SWORD.get(), "Iron Forged Sword");
		add(ItemInit.DIAMOND_FORGED_SWORD.get(), "Diamond Forged Sword");
		add(ItemInit.IRON_BATTLE_AXE.get(), "Iron Battle Axe");
		add(ItemInit.DIAMOND_BATTLE_AXE.get(), "Diamond Battle Axe");
		add(ItemInit.IRON_BLADE.get(), "Iron Blade");
		add(ItemInit.DIAMOND_BLADE.get(), "Diamond Blade");

		add(ItemInit.DEATHSINGER_SWORD.get(), "DeathSinger's Sword");
		add(ItemInit.TIDESINGER_STAFF.get(), "TideSinger's Staff");

		// Weaponry - Clan Staffs
		add(ItemInit.NESTORIS_STAFF.get(), "Nestoris Clan Staff");
		add(ItemInit.KALTARIS_STAFF.get(), "Kaltaris Clan Staff");
		add(ItemInit.MENDORIS_STAFF.get(), "Mendoris Clan Staff");
		add(ItemInit.SENDARIS_STAFF.get(), "Sendaris Clan Staff");
		add(ItemInit.VOLTARIS_STAFF.get(), "Voltaris Clan Staff");

		// Weaponry - Blacksmiths
		add(ItemInit.IRON_BLACKSMITH_HAMMER.get(), "Blacksmith's Iron Hammer");
		add(ItemInit.DIAMOND_BLACKSMITH_HAMMER.get(), "Blacksmith's Diamond Hammer");

		// BLOCKS
		add(BlockInit.WEAPON_FORGER.get(), "Weapon Forger");
	}

}
