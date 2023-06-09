package com.skinnydevi.songs_of_war.client.gui;

import com.skinnydevi.songs_of_war.client.gui.slot.CustomResultSlot;
import com.skinnydevi.songs_of_war.common.blocks.entity.WeaponForgerBlockEntity;
import com.skinnydevi.songs_of_war.initializers.BlockInit;
import com.skinnydevi.songs_of_war.initializers.MenuTypeInit;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

/**
 * In charge of handling the Weapon Forger's Block Entity menu slots.
 */
public class WeaponForgerMenu extends AbstractContainerMenu {
	private final WeaponForgerBlockEntity blockEntity;
	private final Level level;

	private static final int SLOT_SIZE = 18;
	private static final int PLAYER_INVENTORY_UI_X = 8;
	private static final int PLAYER_INVENTORY_UI_Y = 140;
	private static final int PLAYER_HOTBAR_UI_Y = 198;

	/**
	 * In charge of handling the Weapon Forger's Block Entity menu slots.
	 */
	public WeaponForgerMenu(int containerId, Inventory inv, FriendlyByteBuf fbbuf) {
		this(containerId, inv, inv.player.level.getBlockEntity(fbbuf.readBlockPos()));
	}

	/**
	 * In charge of handling the Weapon Forger's Block Entity menu slots.
	 */
	public WeaponForgerMenu(int containerId, Inventory inv, BlockEntity entity) {
		super(MenuTypeInit.WEAPON_FORGER_MENU.get(), containerId);
		checkContainerSize(inv, 26);
		this.blockEntity = (WeaponForgerBlockEntity) entity;
		this.level = inv.player.level;

		addPlayerInventory(inv);
		addPlayerHotbar(inv);

		this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
			int slotIndex = 0;
			int xStart = 16;
			int yStart = 25;
			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					this.addSlot(
							new SlotItemHandler(handler, slotIndex, xStart + (x * SLOT_SIZE),
									yStart + (y * SLOT_SIZE)));
					slotIndex++;
				}
			}
			this.addSlot(new CustomResultSlot(handler, slotIndex++, 142, 61, this.blockEntity));
		});
	}

	private static final int HOTBAR_SLOT_COUNT = 9;
	private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
	private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
	private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
	private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
	private static final int VANILLA_FIRST_SLOT_INDEX = 0;
	private static final int BE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

	private static final int BE_INVENTORY_SLOT_COUNT = 26;

	// Credit to disieben07 for the logic of the method.
	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		Slot sourceSlot = slots.get(index);
		if (sourceSlot == null || !sourceSlot.hasItem())
			return ItemStack.EMPTY; // EMPTY_ITEM

		ItemStack sourceStack = sourceSlot.getItem();
		ItemStack copyOfSourceStack = sourceStack.copy();

		// Check if the slot clicked is one of the vanilla container slots
		if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
			// This is a vanilla container slot so merge the stack into the tile inventory
			if (!moveItemStackTo(sourceStack, BE_INVENTORY_FIRST_SLOT_INDEX, BE_INVENTORY_FIRST_SLOT_INDEX
					+ BE_INVENTORY_SLOT_COUNT, false))
				return ItemStack.EMPTY; // EMPTY_ITEM

		} else if (index < BE_INVENTORY_FIRST_SLOT_INDEX + BE_INVENTORY_SLOT_COUNT) {
			// This is a BE slot so merge the stack into the players inventory
			if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT,
					false))
				return ItemStack.EMPTY;

		} else {
			System.out.println("Invalid slotIndex: " + index);
			return ItemStack.EMPTY;
		}

		// If stack size == 0 (the entire stack was moved) set slot contents to null
		if (sourceStack.getCount() == 0)
			sourceSlot.set(ItemStack.EMPTY);
		else
			sourceSlot.setChanged();

		sourceSlot.onTake(playerIn, sourceStack);
		return copyOfSourceStack;
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
				pPlayer, BlockInit.WEAPON_FORGER.get());
	}

	/** Adds a working inventory section to our GUI */
	private void addPlayerInventory(Inventory playerInventory) {
		for (int y = 0; y < PLAYER_INVENTORY_ROW_COUNT; y++) {
			for (int x = 0; x < PLAYER_INVENTORY_COLUMN_COUNT; x++) {
				this.addSlot(
						new Slot(playerInventory, x + y * 9 + 9, PLAYER_INVENTORY_UI_X + (x * SLOT_SIZE),
								PLAYER_INVENTORY_UI_Y + (y * SLOT_SIZE)));
			}
		}
	}

	/** Adds a working hotbar section to our GUI */
	private void addPlayerHotbar(Inventory playerInventory) {
		for (int x = 0; x < HOTBAR_SLOT_COUNT; x++) {
			this.addSlot(new Slot(playerInventory, x, PLAYER_INVENTORY_UI_X + (x * SLOT_SIZE),
					PLAYER_HOTBAR_UI_Y));
		}
	}

}
