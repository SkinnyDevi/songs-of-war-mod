package com.skinnydevi.songs_of_war.data.generators.server;

import java.util.function.Consumer;

import com.skinnydevi.songs_of_war.SongsOfWarMod;
import com.skinnydevi.songs_of_war.common.items.Weaponry;
import com.skinnydevi.songs_of_war.data.generators.server.recipes.WeaponForgingShapedRecipeBuilder;
import com.skinnydevi.songs_of_war.initializers.BlockInit;
import com.skinnydevi.songs_of_war.initializers.ItemInit;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

public class SOWRecipeProvider extends RecipeProvider {

	public SOWRecipeProvider(PackOutput pckout) {
		super(pckout);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
		this.registerNormalCraftingRecipes(consumer);
		this.registerWeaponForgerRecipes(consumer);
	}

	private void registerNormalCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemInit.IRON_BLACKSMITH_HAMMER.get())
				.define('I', Items.IRON_INGOT)
				.define('S', Items.STICK)
				.pattern("I  ")
				.pattern("SI ")
				.pattern("S  ")
				.unlockedBy("has_item", has(Items.IRON_INGOT))
				.save(consumer, idMaker("iron_blacksmith_hammer_recipe"));

		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemInit.DIAMOND_BLACKSMITH_HAMMER.get())
				.define('D', Items.DIAMOND)
				.define('S', Items.STICK)
				.pattern("D  ")
				.pattern("SD ")
				.pattern("S  ")
				.unlockedBy("has_item", has(Items.DIAMOND))
				.save(consumer, idMaker("diamond_blacksmith_hammer_recipe"));

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.WEAPON_FORGER.get())
				.define('I', Items.IRON_INGOT)
				.define('S', Items.STONE_BRICK_SLAB)
				.define('A', Blocks.ANVIL)
				.pattern(" I ")
				.pattern("IAI")
				.pattern("SSS")
				.unlockedBy("has_item", has(Blocks.ANVIL))
				.save(consumer, idMaker("weapon_forger_recipe"));

		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.STONE_DAGGER.get())
				.define('S', Items.STONE)
				.define('I', Items.STICK)
				.pattern(" S")
				.pattern("I ")
				.unlockedBy("has_item", has(Items.STONE))
				.save(consumer, idMaker("stone_dagger_recipe"));

		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.IRON_DAGGER.get())
				.define('I', Items.IRON_INGOT)
				.define('S', Items.STICK)
				.pattern(" I")
				.pattern("S ")
				.unlockedBy("has_item", has(Items.IRON_INGOT))
				.save(consumer, idMaker("iron_dagger_recipe"));

		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.DIAMOND_DAGGER.get())
				.define('D', Items.DIAMOND)
				.define('S', Items.STICK)
				.pattern(" D")
				.pattern("S ")
				.unlockedBy("has_item", has(Items.DIAMOND))
				.save(consumer, idMaker("diamond_dagger_recipe"));
	}

	private void registerWeaponForgerRecipes(Consumer<FinishedRecipe> consumer) {
		WeaponForgingShapedRecipeBuilder.shapedCombat(ItemInit.STUBBY_AXE.get())
				.define('S', Items.STICK)
				.define('I', Items.IRON_INGOT)
				.pattern("     ")
				.pattern(" II  ")
				.pattern(" ISI ")
				.pattern(" SII ")
				.pattern("S    ")
				.unlockedBy("has_item", has(BlockInit.WEAPON_FORGER.get()))
				.save(consumer, forgerIdMaker("stubby_axe"));

		WeaponForgingShapedRecipeBuilder.shapedCombat(ItemInit.IRON_FORGED_SWORD.get())
				.define('S', Items.STICK)
				.define('I', Items.IRON_INGOT)
				.pattern("    I")
				.pattern(" I I ")
				.pattern("  I  ")
				.pattern(" S I ")
				.pattern("     ")
				.unlockedBy("has_item", has(BlockInit.WEAPON_FORGER.get()))
				.save(consumer, forgerIdMaker("iron_forged_sword"));

		WeaponForgingShapedRecipeBuilder.shapedCombat(ItemInit.DIAMOND_FORGED_SWORD.get())
				.define('S', Items.STICK)
				.define('D', Items.DIAMOND)
				.pattern("    D")
				.pattern(" D D ")
				.pattern("  D  ")
				.pattern(" S D ")
				.pattern("     ")
				.unlockedBy("has_item", has(BlockInit.WEAPON_FORGER.get()))
				.save(consumer, forgerIdMaker("diamond_forged_sword"));

		WeaponForgingShapedRecipeBuilder.shapedCombat(ItemInit.IRON_BATTLE_AXE.get())
				.define('S', Items.STICK)
				.define('I', Items.IRON_INGOT)
				.pattern("   II")
				.pattern("  ISI")
				.pattern("  SI ")
				.pattern(" S   ")
				.pattern("S    ")
				.unlockedBy("has_item", has(BlockInit.WEAPON_FORGER.get()))
				.save(consumer, forgerIdMaker("iron_battle_axe"));

		WeaponForgingShapedRecipeBuilder.shapedCombat(ItemInit.DIAMOND_BATTLE_AXE.get())
				.define('S', Items.STICK)
				.define('D', Items.DIAMOND)
				.pattern("   DD")
				.pattern("  DSD")
				.pattern("  SD ")
				.pattern(" S   ")
				.pattern("S    ")
				.unlockedBy("has_item", has(BlockInit.WEAPON_FORGER.get()))
				.save(consumer, forgerIdMaker("diamond_battle_axe"));

		WeaponForgingShapedRecipeBuilder.shapedCombat(ItemInit.IRON_BLADE.get())
				.define('S', Items.STICK)
				.define('I', Items.IRON_INGOT)
				.pattern(" I   ")
				.pattern("  I  ")
				.pattern("   I ")
				.pattern("  S  ")
				.pattern(" S   ")
				.unlockedBy("has_item", has(BlockInit.WEAPON_FORGER.get()))
				.save(consumer, forgerIdMaker("iron_blade"));

		WeaponForgingShapedRecipeBuilder.shapedCombat(ItemInit.DIAMOND_BLADE.get())
				.define('S', Items.STICK)
				.define('D', Items.DIAMOND)
				.pattern(" D   ")
				.pattern("  D  ")
				.pattern("   D ")
				.pattern("  S  ")
				.pattern(" S   ")
				.unlockedBy("has_item", has(BlockInit.WEAPON_FORGER.get()))
				.save(consumer, forgerIdMaker("diamond_blade"));

		WeaponForgingShapedRecipeBuilder.shapedCombat(ItemInit.BLADED_STAFF.get())
				.define('B', Weaponry.IRON_BLADE)
				.define('S', Items.STICK)
				.pattern("     ")
				.pattern("     ")
				.pattern("  B  ")
				.pattern(" S   ")
				.pattern("S    ")
				.unlockedBy("has_item", has(BlockInit.WEAPON_FORGER.get()))
				.save(consumer, forgerIdMaker("bladed_staff"));

		WeaponForgingShapedRecipeBuilder.shapedCombat(ItemInit.IRON_GREATAXE.get())
				.define('I', Items.IRON_INGOT)
				.define('S', Items.STICK)
				.pattern("   II")
				.pattern("  ISI")
				.pattern("  SII")
				.pattern("IS   ")
				.pattern("II   ")
				.unlockedBy("has_item", has(BlockInit.WEAPON_FORGER.get()))
				.save(consumer, forgerIdMaker("iron_greataxe"));

		WeaponForgingShapedRecipeBuilder.shapedCombat(ItemInit.IRON_GREATSWORD.get())
				.define('I', Items.IRON_INGOT)
				.define('S', Items.STICK)
				.pattern("    D")
				.pattern("  DD ")
				.pattern(" DDD ")
				.pattern(" SD  ")
				.pattern("S    ")
				.unlockedBy("has_item", has(BlockInit.WEAPON_FORGER.get()))
				.save(consumer, "iron_greatsword");

		WeaponForgingShapedRecipeBuilder.shapedCombat(ItemInit.DIAMOND_GREATSWORD.get())
				.define('D', Items.DIAMOND)
				.define('S', Items.STICK)
				.pattern("    D")
				.pattern("  DD ")
				.pattern(" DDD ")
				.pattern(" SD  ")
				.pattern("S    ")
				.unlockedBy("has_item", has(BlockInit.WEAPON_FORGER.get()))
				.save(consumer, "diamond_greatsword");
	}

	private static ResourceLocation idMaker(String recipeId) {
		return new ResourceLocation(SongsOfWarMod.MOD_ID, recipeId);
	}

	private static ResourceLocation forgerIdMaker(String recipeId) {
		return new ResourceLocation(SongsOfWarMod.MOD_ID, "weapon_forger/" + recipeId);
	}

}
