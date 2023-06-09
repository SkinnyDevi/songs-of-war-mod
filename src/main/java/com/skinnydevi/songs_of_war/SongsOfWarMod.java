package com.skinnydevi.songs_of_war;

import com.mojang.logging.LogUtils;

import com.skinnydevi.songs_of_war.initializers.*;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.slf4j.Logger;

@Mod(SongsOfWarMod.MOD_ID)
public class SongsOfWarMod {
	public static final String MOD_ID = "songs_of_war";
	public static final Logger LOGGER = LogUtils.getLogger();

	public SongsOfWarMod() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemInit.ITEMS.register(modBus);
		BlockInit.BLOCKS.register(modBus);
		BlockEntityInit.BLOCK_ENTITIES.register(modBus);
		MenuTypeInit.MENUS.register(modBus);
		RecipeInit.SERIALIZERS.register(modBus);

		modBus.addListener(this::preInit);
		modBus.addListener(this::preInitClient);

		MinecraftForge.EVENT_BUS.register(this);

		modBus.addListener(CreativeTabInit::addCreative);
	}

	private void preInit(final FMLCommonSetupEvent event) {
		LOGGER.debug("Starting PreInit for Songs Of War...");
		// Capabilities
	}

	private void preInitClient(final FMLClientSetupEvent event) {
		LOGGER.debug("Starting PreInitClient for Songs Of War...");
		MenuTypeInit.registerScreens();
		// Overlays
	}
}
