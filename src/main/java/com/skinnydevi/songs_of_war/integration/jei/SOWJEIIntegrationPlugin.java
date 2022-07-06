package com.skinnydevi.songs_of_war.integration.jei;

import java.util.List;
import java.util.Objects;

import com.skinnydevi.songs_of_war.SongsOfWarMod;
import com.skinnydevi.songs_of_war.common.recipes.WeaponForgerRecipe;
import com.skinnydevi.songs_of_war.integration.jei.categories.WeaponForgerRecipeCategory;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

@JeiPlugin
public class SOWJEIIntegrationPlugin implements IModPlugin {

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation(SongsOfWarMod.MOD_ID, "jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new WeaponForgerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		Minecraft instance = Minecraft.getInstance();
		RecipeManager rm = Objects.requireNonNull(instance.level).getRecipeManager();

		List<WeaponForgerRecipe> recipes = rm.getAllRecipesFor(WeaponForgerRecipe.Type.INSTANCE);
		registration.addRecipes(SOWJEIRecipeTypes.WEAPON_FORGING, recipes);
	}
}
