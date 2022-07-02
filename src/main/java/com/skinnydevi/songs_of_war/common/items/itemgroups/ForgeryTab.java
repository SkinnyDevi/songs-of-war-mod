package com.skinnydevi.songs_of_war.common.items.itemgroups;

import com.skinnydevi.songs_of_war.common.items.Weaponry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ForgeryTab extends CreativeModeTab {

	public ForgeryTab() {
		super("sow_forgery_tab");
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(Weaponry.IRON_BLACKSMITH_HAMMER);
	}

}
