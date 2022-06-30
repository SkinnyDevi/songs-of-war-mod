package com.skinnydevi.songs_of_war;

import com.mojang.logging.LogUtils;

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
	private static final Logger LOGGER = LogUtils.getLogger();

	public SongsOfWarMod() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

		modBus.addListener(this::preInit);
		modBus.addListener(this::preInitClient);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void preInit(final FMLCommonSetupEvent event) {
		// Capabilities
	}

	private void preInitClient(final FMLClientSetupEvent event) {
		// Overlays
	}
}
