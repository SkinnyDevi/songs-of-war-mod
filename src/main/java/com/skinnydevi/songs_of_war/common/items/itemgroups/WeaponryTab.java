package com.skinnydevi.songs_of_war.common.items.itemgroups;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class WeaponryTab extends CreativeModeTab {

	public WeaponryTab() {
		super("sow_weapons_tab");
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(Items.IRON_AXE);
	}

}
