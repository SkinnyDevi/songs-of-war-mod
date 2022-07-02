package com.skinnydevi.songs_of_war;

import com.mojang.logging.LogUtils;
import com.skinnydevi.songs_of_war.common.items.itemgroups.WeaponryTab;
import com.skinnydevi.songs_of_war.initializers.ItemInit;

import net.minecraft.world.item.CreativeModeTab;
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

	public static final CreativeModeTab WEAPONRY_TAB = new WeaponryTab();

	public SongsOfWarMod() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemInit.ITEMS.register(modBus);

		modBus.addListener(this::preInit);
		modBus.addListener(this::preInitClient);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void preInit(final FMLCommonSetupEvent event) {
		LOGGER.debug("Starting PreInit for Songs Of War...");
		// Capabilities
	}

	private void preInitClient(final FMLClientSetupEvent event) {
		LOGGER.debug("Starting PreInitClient for Songs Of War...");
		// Overlays
	}
}
