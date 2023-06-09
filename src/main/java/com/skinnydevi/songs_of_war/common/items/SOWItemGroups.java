package com.skinnydevi.songs_of_war.common.items;

import com.skinnydevi.songs_of_war.SongsOfWarMod;
import com.skinnydevi.songs_of_war.common.items.Weaponry;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Consumer;

/**
 * Songs Of War Creative Tabs Registry.
 */
@Mod.EventBusSubscriber(modid = SongsOfWarMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SOWItemGroups {

	public static CreativeModeTab FORGERY_TAB;
	public static CreativeModeTab WEAPONRY_TAB;

	@SubscribeEvent
	public static void registerCreativeTabs(CreativeModeTabEvent.Register event) {
	 	WEAPONRY_TAB = event.registerCreativeModeTab(tabIdResource("sow_weapons_tab"), tabBuilder(Weaponry.DEATHSINGER_SWORD, "SOW Weapons"));
		FORGERY_TAB = event.registerCreativeModeTab(tabIdResource("sow_forgery_tab"), tabBuilder(Weaponry.IRON_BLACKSMITH_HAMMER, "SOW Forgery"));
	}


	private static ResourceLocation tabIdResource(String id) {
		return new ResourceLocation(SongsOfWarMod.MOD_ID, id);
	}

	private static Consumer<CreativeModeTab.Builder> tabBuilder(Item tabIcon, String tabName) {
		return builder -> builder.icon(() -> new ItemStack(tabIcon)).title(Component.literal(tabName)).build();
	}
}
