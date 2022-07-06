package com.skinnydevi.songs_of_war.common.blocks.entity;

import java.util.Optional;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;

import com.skinnydevi.songs_of_war.client.gui.WeaponForgerMenu;
import com.skinnydevi.songs_of_war.common.recipes.WeaponForgerRecipe;
import com.skinnydevi.songs_of_war.initializers.BlockEntityInit;

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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class WeaponForgerBlockEntity extends BlockEntity implements MenuProvider {
	private final ItemStackHandler itemHandler = new ItemStackHandler(26) {
		@Override
		protected void onContentsChanged(int slot) {
			setChanged();
		};
	};

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
		if (hasRecipe(pBlockEntity)) {
			setChanged(pLevel, pPos, pState);
			setResultPreview(pBlockEntity);
		} else {
			setChanged(pLevel, pPos, pState);
		}
	}

	private static boolean hasRecipe(WeaponForgerBlockEntity entity) {
		Level level = entity.level;
		SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());

		for (int i = 0; i < entity.itemHandler.getSlots(); i++)
			inventory.setItem(i, entity.itemHandler.getStackInSlot(i));

		Optional<WeaponForgerRecipe> match = level.getRecipeManager()
				.getRecipeFor(WeaponForgerRecipe.Type.INSTANCE, inventory, level);

		if (!match.isPresent())
			clearResultPreview(entity);

		return match.isPresent()
				&& canInsertItemIntoOutputSlot(inventory, match.get().getResultItem());
	}

	private static void clearResultPreview(WeaponForgerBlockEntity entity) {
		if (!entity.itemHandler.getStackInSlot(25).isEmpty())
			entity.itemHandler.setStackInSlot(25, ItemStack.EMPTY);
	}

	private static void setResultPreview(WeaponForgerBlockEntity entity) {
		Optional<WeaponForgerRecipe> match = recipeMatches(entity);
		if (entity.itemHandler.getStackInSlot(25).isEmpty() && match.isPresent()) {
			entity.itemHandler.setStackInSlot(25, new ItemStack(match.get().getResultItem().getItem(), 1));
		}
	}

	public static void craftItem(WeaponForgerBlockEntity entity) {
		Optional<WeaponForgerRecipe> match = recipeMatches(entity);

		if (match.isPresent()) {
			for (int i = 0; i < 25; i++)
				entity.itemHandler.extractItem(i, 1, false);

			entity.itemHandler.setStackInSlot(25, new ItemStack(match.get().getResultItem().getItem(),
					entity.itemHandler.getStackInSlot(25).getCount() + 1));
		}
	}

	private static Optional<WeaponForgerRecipe> recipeMatches(WeaponForgerBlockEntity entity) {
		Level level = entity.level;
		SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
		for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
			inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
		}

		return level.getRecipeManager()
				.getRecipeFor(WeaponForgerRecipe.Type.INSTANCE, inventory, level);
	}

	private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack result) {
		return inventory.getItem(25).isEmpty();
		// return inventory.getItem(25).getItem() == result.getItem() ||
		// inventory.getItem(25).isEmpty();
	}
}
