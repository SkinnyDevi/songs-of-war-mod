package com.skinnydevi.songs_of_war.client.gui.slot;

import org.jetbrains.annotations.NotNull;

import com.skinnydevi.songs_of_war.common.blocks.entity.WeaponForgerBlockEntity;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Weapon Forger result slot that crafts the desired item on pickup.
 */
public class CustomResultSlot extends SlotItemHandler {
	private final WeaponForgerBlockEntity blockEntity;

	public CustomResultSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition,
			WeaponForgerBlockEntity entity) {
		super(itemHandler, index, xPosition, yPosition);
		this.blockEntity = entity;
	}

	@Override
	public boolean mayPlace(ItemStack stack) {
		return false;
	}

	@Override
	public @NotNull ItemStack remove(int amount) {
		WeaponForgerBlockEntity.craftItem(blockEntity);
		return super.remove(amount);
	}

}
