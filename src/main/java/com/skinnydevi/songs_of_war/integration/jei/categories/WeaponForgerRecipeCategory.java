package com.skinnydevi.songs_of_war.integration.jei.categories;

import javax.annotation.Nonnull;

import com.skinnydevi.songs_of_war.SongsOfWarMod;
import com.skinnydevi.songs_of_war.common.recipes.WeaponForgerRecipe;
import com.skinnydevi.songs_of_war.initializers.BlockInit;
import com.skinnydevi.songs_of_war.integration.jei.SOWJEIRecipeTypes;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class WeaponForgerRecipeCategory implements IRecipeCategory<WeaponForgerRecipe> {
	public final static ResourceLocation UID = new ResourceLocation(SongsOfWarMod.MOD_ID, "weapon_forging");
	public final static ResourceLocation TEXTURE = new ResourceLocation(SongsOfWarMod.MOD_ID,
			"textures/gui/jei/weapon_forger_crafting_preview.png");

	private final IDrawable background;
	private final IDrawable icon;

	public WeaponForgerRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 124);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
				new ItemStack(BlockInit.WEAPON_FORGER.get()));
	}

	public static ResourceLocation getUid() {
		return UID;
	}

	@Override
	public RecipeType<WeaponForgerRecipe> getRecipeType() {
		return SOWJEIRecipeTypes.WEAPON_FORGING;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Weapon Forger");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, @Nonnull WeaponForgerRecipe recipe,
			@Nonnull IFocusGroup focuses) {
		int xStart = 16;
		int yStart = 18;
		final int slotSize = 18;
		int slotIndex = 0;
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				builder.addSlot(RecipeIngredientRole.INPUT, xStart + (x * slotSize), yStart + (y * slotSize))
						.addIngredients(recipe.getIngredients().get(slotIndex));
				slotIndex++;
			}
		}
		builder.addSlot(RecipeIngredientRole.OUTPUT, 142, 54).addItemStack(recipe.getResultItem());
	}

}
