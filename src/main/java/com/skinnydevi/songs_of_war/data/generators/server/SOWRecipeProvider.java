package com.skinnydevi.songs_of_war.data.generators.server;

import java.util.function.Consumer;

import com.skinnydevi.songs_of_war.SongsOfWarMod;
import com.skinnydevi.songs_of_war.initializers.BlockInit;
import com.skinnydevi.songs_of_war.initializers.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class SOWRecipeProvider extends RecipeProvider {

	public SOWRecipeProvider(DataGenerator gen) {
		super(gen);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		this.registerNormalCraftingRecipes(consumer);
		this.registerWeaponForgerRecipes(consumer);
	}

	private void registerNormalCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		ShapedRecipeBuilder.shaped(ItemInit.IRON_BLACKSMITH_HAMMER.get())
				.define('I', Items.IRON_INGOT)
				.define('S', Items.STICK)
				.pattern("I  ")
				.pattern("SI ")
				.pattern("S  ")
				.unlockedBy("has_item", has(Items.IRON_INGOT))
				.save(consumer, idMaker("iron_blacksmith_hammer_recipe"));

		ShapedRecipeBuilder.shaped(ItemInit.DIAMOND_BLACKSMITH_HAMMER.get())
				.define('D', Items.DIAMOND)
				.define('S', Items.STICK)
				.pattern("D  ")
				.pattern("SD ")
				.pattern("S  ")
				.unlockedBy("has_item", has(Items.DIAMOND))
				.save(consumer, idMaker("diamond_blacksmith_hammer_recipe"));

		ShapedRecipeBuilder.shaped(BlockInit.WEAPON_FORGER.get())
				.define('I', Items.IRON_INGOT)
				.define('S', Items.STONE_BRICK_SLAB)
				.define('A', Blocks.ANVIL)
				.pattern(" I ")
				.pattern("IAI")
				.pattern("SSS")
				.unlockedBy("has_item", has(Blocks.ANVIL))
				.save(consumer, idMaker("weapon_forger_recipe"));
	}

	private void registerWeaponForgerRecipes(Consumer<FinishedRecipe> consumer) {
		WeaponForgingShapedRecipeBuilder.shaped(ItemInit.STUBBY_AXE.get())
				.define('S', Items.STICK)
				.define('I', Items.IRON_INGOT)
				.pattern("     ")
				.pattern(" II  ")
				.pattern(" ISI ")
				.pattern(" SII ")
				.pattern("S    ")
				.unlockedBy("has_item", has(BlockInit.WEAPON_FORGER.get()))
				.save(consumer, forgerIdMaker("stubby_axe"));

		WeaponForgingShapedRecipeBuilder.shaped(ItemInit.IRON_FORGED_SWORD.get())
				.define('S', Items.STICK)
				.define('I', Items.IRON_INGOT)
				.pattern("    I")
				.pattern(" I I ")
				.pattern("  I  ")
				.pattern(" S I ")
				.pattern("     ")
				.unlockedBy("has_item", has(BlockInit.WEAPON_FORGER.get()))
				.save(consumer, forgerIdMaker("iron_forged_sword"));

		WeaponForgingShapedRecipeBuilder.shaped(ItemInit.DIAMOND_FORGED_SWORD.get())
				.define('S', Items.STICK)
				.define('D', Items.DIAMOND)
				.pattern("    D")
				.pattern(" D D ")
				.pattern("  D  ")
				.pattern(" S D ")
				.pattern("     ")
				.unlockedBy("has_item", has(BlockInit.WEAPON_FORGER.get()))
				.save(consumer, forgerIdMaker("diamond_forged_sword"));

	}

	private static ResourceLocation idMaker(String recipeId) {
		return new ResourceLocation(SongsOfWarMod.MOD_ID, recipeId);
	}

	private static ResourceLocation forgerIdMaker(String recipeId) {
		return new ResourceLocation(SongsOfWarMod.MOD_ID, "weapon_forger/" + recipeId);
	}

}
