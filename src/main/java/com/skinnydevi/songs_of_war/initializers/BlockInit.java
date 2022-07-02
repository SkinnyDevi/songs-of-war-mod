package com.skinnydevi.songs_of_war.initializers;

import java.util.function.Supplier;

import com.skinnydevi.songs_of_war.SongsOfWarMod;
import com.skinnydevi.songs_of_war.common.blocks.WeaponForger;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			SongsOfWarMod.MOD_ID);

	public static final RegistryObject<Block> WEAPON_FORGER = registerBlock("weapon_forger", () -> new WeaponForger(),
			SongsOfWarMod.FORGERY_TAB);

	// HELPER METHODS

	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
			CreativeModeTab tab) {
		RegistryObject<T> entry = BLOCKS.register(name, block);
		registerBlockItem(name, entry, tab);
		return entry;
	}

	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
			CreativeModeTab tab) {
		return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
