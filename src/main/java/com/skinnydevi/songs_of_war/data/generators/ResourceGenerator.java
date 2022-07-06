package com.skinnydevi.songs_of_war.data.generators;

import com.skinnydevi.songs_of_war.SongsOfWarMod;
import com.skinnydevi.songs_of_war.data.generators.client.SOWItemModelProvider;
import com.skinnydevi.songs_of_war.data.generators.lang.EN_US_LangProvider;
import com.skinnydevi.songs_of_war.data.generators.server.SOWLootTableProvider;
import com.skinnydevi.songs_of_war.data.generators.server.SOWRecipeProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

/**
 * Main Data Generator class for various generators.
 */
@Mod.EventBusSubscriber(modid = SongsOfWarMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ResourceGenerator {
	public ResourceGenerator() {
	}

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();

		if (event.includeServer()) {
			// Recipes
			gen.addProvider(true, new SOWRecipeProvider(gen));

			// Loot Tables
			gen.addProvider(true, new SOWLootTableProvider(gen));
		}
		if (event.includeClient()) {
			// BlockStates
			// gen.addProvider(new WaterHeatModBlockStateProvider(gen, fileHelper));

			// Items
			gen.addProvider(true, new SOWItemModelProvider(gen, fileHelper));

			// Language Providers
			gen.addProvider(true, new EN_US_LangProvider(gen));
		}
	}
}
