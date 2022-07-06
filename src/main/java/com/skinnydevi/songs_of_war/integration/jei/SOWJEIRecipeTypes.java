package com.skinnydevi.songs_of_war.integration.jei;

import com.skinnydevi.songs_of_war.SongsOfWarMod;
import com.skinnydevi.songs_of_war.common.recipes.WeaponForgerRecipe;

import mezz.jei.api.recipe.RecipeType;

/**
 * Defines RecipeTypes readable by JEI.
 */
public class SOWJEIRecipeTypes {
	public static final RecipeType<WeaponForgerRecipe> WEAPON_FORGING = RecipeType.create(SongsOfWarMod.MOD_ID,
			"weapon_forging", WeaponForgerRecipe.class);
}
