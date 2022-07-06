package com.skinnydevi.songs_of_war.common.items.itemgroups;

import com.skinnydevi.songs_of_war.common.items.Weaponry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/**
 * Songs Of War Weaponry Creative Tab.
 */
public class WeaponryTab extends CreativeModeTab {

	public WeaponryTab() {
		super("sow_weapons_tab");
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(Weaponry.DEATHSINGER_SWORD);
	}

}
