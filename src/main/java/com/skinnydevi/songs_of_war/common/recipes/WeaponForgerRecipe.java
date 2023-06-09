package com.skinnydevi.songs_of_war.common.recipes;

import java.util.HashMap;

import org.jetbrains.annotations.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.skinnydevi.songs_of_war.SongsOfWarMod;
import com.skinnydevi.songs_of_war.initializers.BlockInit;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

/**
 * Declaration of a new Recipe and RecipeType for the {@code WeaponForger}
 * craftings.
 */
public class WeaponForgerRecipe implements Recipe<SimpleContainer> {

	private final ResourceLocation id;
	private final NonNullList<Ingredient> ingredients;
	private final ItemStack result;

	/**
	 * Declaration of a new Recipe and RecipeType for the {@code WeaponForger}
	 * craftings.
	 */
	public WeaponForgerRecipe(ResourceLocation id, NonNullList<Ingredient> ingredients,
			ItemStack result) {
		this.id = id;
		this.ingredients = ingredients;
		this.result = result;
	}

	/**
	 * Check if the recipe passed with an inventory has a valid recipe.
	 * 
	 * In this case, the inventory is the {@code WeaponForgerBlockEntity}'s crafting
	 * slots.
	 */
	@Override
	public boolean matches(SimpleContainer inv, Level level) {
		for (int i = 0; i < inv.getContainerSize() - 1; i++) {
			if (!ingredients.get(i).test(inv.getItem(i)))
				return false;
		}

		return true;
	}

	@Override
	public ItemStack assemble(SimpleContainer inv) {
		return this.result;
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getResultItem() {
		return this.result;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	@Override
	public RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	@Override
	public ItemStack getToastSymbol() {
		return new ItemStack(BlockInit.WEAPON_FORGER.get());
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return this.ingredients;
	}

	/**
	 * Defines the RecipeType for the {@code WeaponForgerRecipe} recipes.
	 */
	public static class Type implements RecipeType<WeaponForgerRecipe> {
		public static final RecipeType<WeaponForgerRecipe> INSTANCE = new Type();
		public static final String ID = "weapon_forging";
	}

	/**
	 * Defines the RecipeSerializer for the {@code WeaponForgerRecipe} recipes.
	 */
	public static class Serializer implements RecipeSerializer<WeaponForgerRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		public static final ResourceLocation ID = new ResourceLocation(SongsOfWarMod.MOD_ID, "weapon_forging");

		@Override
		public WeaponForgerRecipe fromJson(ResourceLocation id, JsonObject json) {
			ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
			JsonObject recipeKeys = GsonHelper.getAsJsonObject(json, "key");

			HashMap<Integer, Character> existingKeys = parsePattern(GsonHelper.getAsJsonArray(json, "pattern"));
			// Initializes an empty recipe.
			NonNullList<Ingredient> ingredients = NonNullList.withSize(25, Ingredient.EMPTY);

			for (int i = 0; i < existingKeys.size(); i++) {
				// Adds the item to the recipe corresponding to its position in the crafting
				// recipe.
				if (existingKeys.get(i) != null)
					ingredients.set(i, Ingredient.fromJson(recipeKeys.get(existingKeys.get(i).toString())));
			}

			return new WeaponForgerRecipe(id, ingredients, result);
		}

		@Override
		public @Nullable WeaponForgerRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
			NonNullList<Ingredient> ingredients = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

			for (int i = 0; i < ingredients.size(); i++)
				ingredients.set(i, Ingredient.fromNetwork(buf));

			return new WeaponForgerRecipe(id, ingredients, buf.readItem());
		}

		@Override
		public void toNetwork(FriendlyByteBuf buf, WeaponForgerRecipe recipe) {
			buf.writeInt(recipe.getIngredients().size());

			for (Ingredient ing : recipe.getIngredients())
				ing.toNetwork(buf);

			buf.writeItemStack(recipe.getResultItem(), false);
		}

		/**
		 * Returns a list with the {@code slotIndex} of the inventory and the
		 * {@code Key} corresponding to an {@code Item}.
		 * 
		 * @return HashMap
		 */
		private HashMap<Integer, Character> parsePattern(JsonArray rawPattern) {
			HashMap<Integer, Character> existingKeys = new HashMap<>();

			int slotIndex = 0;
			for (JsonElement row : rawPattern) {
				for (char key : row.getAsString().toCharArray()) {
					existingKeys.put(slotIndex, key == ' ' ? null : key);
					slotIndex++;
				}
			}

			return existingKeys;
		}
	}
}
