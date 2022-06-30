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
	// return "death.attack.waterheatmod." + type;
	// }

	@Override
	protected void addTranslations() {
		// Creative Tabs
		add("itemGroup.sow_tab", "Songs Of War");

		// Songs
		add(ItemInit.PROTISSIUM_SONG.get(), "Protissium Song");
	}

}
