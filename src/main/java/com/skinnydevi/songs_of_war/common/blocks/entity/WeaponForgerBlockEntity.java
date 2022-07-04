package com.skinnydevi.songs_of_war.common.blocks.entity;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;

import com.skinnydevi.songs_of_war.client.gui.WeaponForgerMenu;
import com.skinnydevi.songs_of_war.initializers.BlockEntityInit;
import com.skinnydevi.songs_of_war.initializers.ItemInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class WeaponForgerBlockEntity extends BlockEntity implements MenuProvider {
	private final ItemStackHandler itemHandler=new ItemStackHandler(26){@Override protected void onContentsChanged(int slot){setChanged();};};

	private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

	public WeaponForgerBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
		super(BlockEntityInit.WEAPON_FORGER_BLOCK_ENTITY.get(), p_155229_, p_155230_);
	}

	@Override
	public AbstractContainerMenu createMenu(int containerId, Inventory inv, Player p_39956_) {
		return new WeaponForgerMenu(containerId, inv, this);
	}

	@Override
	public Component getDisplayName() {
		return Component.literal("Weapon Forger");
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return lazyItemHandler.cast();
		}

		return super.getCapability(cap, side);
	}

	@Override
	public void onLoad() {
		super.onLoad();
		lazyItemHandler = LazyOptional.of(() -> itemHandler);
	}

	@Override
	public void invalidateCaps() {
		super.invalidateCaps();
		lazyItemHandler.invalidate();
	}

	@Override
	protected void saveAdditional(@NotNull CompoundTag tag) {
		tag.put("inventory", itemHandler.serializeNBT());
		super.saveAdditional(tag);
	}

	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
		itemHandler.deserializeNBT(nbt.getCompound("inventory"));
	}

	public void drops() {
		SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
		for (int i = 0; i < itemHandler.getSlots(); i++) 
			inventory.setItem(i, itemHandler.getStackInSlot(i));
		

		Containers.dropContents(this.level, this.worldPosition, inventory);
	}

	public static void tick(Level pLevel, BlockPos pPos, BlockState pState, WeaponForgerBlockEntity pBlockEntity) {
		if (hasRecipe(pBlockEntity) && hasNotReachedStackLimit(pBlockEntity)) {
			craftItem(pBlockEntity);
		}
	}

	private static void craftItem(WeaponForgerBlockEntity entity) {
		entity.itemHandler.extractItem(0, 1, false);
		entity.itemHandler.extractItem(1, 1, false);
		entity.itemHandler.extractItem(2, 1, false);

		entity.itemHandler.setStackInSlot(25, new ItemStack(ItemInit.DEATHSINGER_SWORD.get(),
				entity.itemHandler.getStackInSlot(25).getCount() + 1));
	}

	private static boolean hasRecipe(WeaponForgerBlockEntity entity) {
		boolean hasDiamonds1 = entity.itemHandler.getStackInSlot(0).getItem() == Items.DIAMOND;
		boolean hasDiamonds2 = entity.itemHandler.getStackInSlot(1).getItem() == Items.DIAMOND;
		boolean hasDiamonds3 = entity.itemHandler.getStackInSlot(2).getItem() == Items.DIAMOND;

		return hasDiamonds1 && hasDiamonds2 && hasDiamonds3;
	}

	private static boolean hasNotReachedStackLimit(WeaponForgerBlockEntity entity) {
		return entity.itemHandler.getStackInSlot(25).getCount() < entity.itemHandler.getStackInSlot(25)
				.getMaxStackSize();
	}

}
