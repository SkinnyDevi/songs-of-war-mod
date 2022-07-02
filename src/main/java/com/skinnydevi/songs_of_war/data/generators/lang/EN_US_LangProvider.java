package com.skinnydevi.songs_of_war.data.generators.lang;

import com.skinnydevi.songs_of_war.SongsOfWarMod;
import com.skinnydevi.songs_of_war.initializers.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class EN_US_LangProvider extends LanguageProvider {

	public EN_US_LangProvider(DataGenerator gen) {
		super(gen, SongsOfWarMod.MOD_ID, "en_us");
	}

	// private static String customdeath(String type) {
	// return "death.attack." + SongsOfWarMod.MOD_ID + "." + type;
	// }

	@Override
	protected void addTranslations() {
		// Creative Tabs
		add("itemGroup.sow_weapons_tab", "Songs Of War Weaponry");

		// Weapons
		add(ItemInit.STUBBY_AXE.get(), "Stubby Axe");
		add(ItemInit.IRON_FORGED_SWORD.get(), "Iron Forged Sword");
		add(ItemInit.DIAMOND_FORGED_SWORD.get(), "Diamond Forged Sword");

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
	}

}
