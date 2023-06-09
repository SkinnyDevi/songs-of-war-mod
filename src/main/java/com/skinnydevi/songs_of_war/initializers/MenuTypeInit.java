package com.skinnydevi.songs_of_war.initializers;

import com.skinnydevi.songs_of_war.SongsOfWarMod;
import com.skinnydevi.songs_of_war.client.gui.WeaponForgerGui;
import com.skinnydevi.songs_of_war.client.gui.WeaponForgerMenu;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypeInit {
	public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES,
			SongsOfWarMod.MOD_ID);

	public static final RegistryObject<MenuType<WeaponForgerMenu>> WEAPON_FORGER_MENU = registerMenuType(
			WeaponForgerMenu::new, "weapon_forger_menu");

	private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(
			IContainerFactory<T> factory, String name) {
		return MENUS.register(name, () -> IForgeMenuType.create(factory));
	}

	public static void registerScreens() {
		MenuScreens.register(WEAPON_FORGER_MENU.get(), WeaponForgerGui::new);
	}
}
