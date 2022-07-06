package com.skinnydevi.songs_of_war.data.generators.server;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.skinnydevi.songs_of_war.common.recipes.WeaponForgerRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

public class WeaponForgingShapedRecipeBuilder implements RecipeBuilder {
	private final Item result;
	private final int count;
	private final List<String> rows = Lists.newArrayList();
	private final Map<Character, Ingredient> key = Maps.newLinkedHashMap();
	private final Advancement.Builder advancement = Advancement.Builder.advancement();
	@Nullable
	private String group;

	public WeaponForgingShapedRecipeBuilder(ItemLike result) {
		this(result, 1);
	}

	public WeaponForgingShapedRecipeBuilder(ItemLike result, int count) {
		this.result = result.asItem();
		this.count = count;
	}

	public static WeaponForgingShapedRecipeBuilder shaped(ItemLike result) {
		return shaped(result, 1);
	}

	public static WeaponForgingShapedRecipeBuilder shaped(ItemLike result, int count) {
		return new WeaponForgingShapedRecipeBuilder(result, count);
	}

	public WeaponForgingShapedRecipeBuilder define(Character identifier, TagKey<Item> ingredient) {
		return this.define(identifier, Ingredient.of(ingredient));
	}

	public WeaponForgingShapedRecipeBuilder define(Character identifier, ItemLike ingredient) {
		return this.define(identifier, Ingredient.of(ingredient));
	}

	public WeaponForgingShapedRecipeBuilder define(Character identifier, Ingredient ingredient) {
		if (this.key.containsKey(identifier)) {
			throw new IllegalArgumentException("Symbol '" + identifier + "' is already defined!");
		} else if (identifier == ' ') {
			throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
		} else {
			this.key.put(identifier, ingredient);
			return this;
		}
	}

	public WeaponForgingShapedRecipeBuilder pattern(String pattern) {
		if (!this.rows.isEmpty() && pattern.length() != 5) {
			throw new IllegalArgumentException("Pattern must be the same width (5) on every line!");
		} else {
			this.rows.add(pattern);
			return this;
		}
	}

	@Override
	public RecipeBuilder unlockedBy(String advancement, CriterionTriggerInstance criterion) {
		this.advancement.addCriterion(advancement, criterion);
		return this;
	}

	@Override
	public RecipeBuilder group(@Nullable String group) {
		this.group = group;
		return this;
	}

	@Override
	public Item getResult() {
		return this.result;
	}

	@Override
	public void save(Consumer<FinishedRecipe> consumer, ResourceLocation id) {
		this.ensureValid(id);
		this.advancement.parent(ROOT_RECIPE_ADVANCEMENT)
				.addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
				.rewards(AdvancementRewards.Builder.recipe(id)).requirements(RequirementsStrategy.OR);

		consumer.accept(new WeaponForgingShapedRecipeBuilder.Result(id, this.result, this.count,
				this.group == null ? "" : this.group, this.rows,
				this.key, this.advancement, this.recipeLocation(id)));
	}

	private ResourceLocation recipeLocation(ResourceLocation resultId) {
		return new ResourceLocation(resultId.getNamespace(),
				"recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + resultId.getPath());
	}

	private void ensureValid(ResourceLocation id) {
		if (this.rows.isEmpty()) {
			throw new IllegalStateException("No pattern was defined for the weapon forging recipe " + id);
		} else {
			Set<Character> set = Sets.newHashSet(this.key.keySet());
			set.remove(' ');

			for (String s : this.rows) {
				for (int i = 0; i < s.length(); ++i) {
					char c0 = s.charAt(i);
					if (!this.key.containsKey(c0) && c0 != ' ') {
						throw new IllegalStateException(
								"Pattern in recipe " + id + " uses undefined symbol '" + c0 + "'");
					}

					set.remove(c0);
				}
			}

			if (!set.isEmpty()) {
				throw new IllegalStateException(
						"Ingredients are defined but not used in pattern for recipe " + id);
			} else if (this.advancement.getCriteria().isEmpty()) {
				throw new IllegalStateException("No way of obtaining recipe " + id);
			}
		}
	}

	public static class Result implements FinishedRecipe {
		private final ResourceLocation id;
		private final Item result;
		private final int count;
		private final String group;
		private final List<String> pattern;
		private final Map<Character, Ingredient> key;
		private final Advancement.Builder advancement;
		private final ResourceLocation advancementId;

		public Result(ResourceLocation id, Item result, int count, String group,
				List<String> pattern, Map<Character, Ingredient> keys, Advancement.Builder advancement,
				ResourceLocation advancementId) {
			this.id = id;
			this.result = result;
			this.count = count;
			this.group = group;
			this.pattern = pattern;
			this.key = keys;
			this.advancement = advancement;
			this.advancementId = advancementId;
		}

		@Override
		@SuppressWarnings("deprecation")
		public void serializeRecipeData(JsonObject json) {
			if (!this.group.isEmpty()) {
				json.addProperty("group", this.group);
			}

			JsonArray jsonarray = new JsonArray();

			for (String s : this.pattern)
				jsonarray.add(s);

			json.add("pattern", jsonarray);
			JsonObject jsonobject = new JsonObject();

			for (Map.Entry<Character, Ingredient> entry : this.key.entrySet())
				jsonobject.add(String.valueOf(entry.getKey()), entry.getValue().toJson());

			json.add("key", jsonobject);
			JsonObject jsonobject1 = new JsonObject();
			jsonobject1.addProperty("item", Registry.ITEM.getKey(this.result).toString());

			if (this.count > 1)
				jsonobject1.addProperty("count", this.count);

			json.add("result", jsonobject1);
		}

		@Override
		public ResourceLocation getId() {
			return this.id;
		}

		@Override
		public RecipeSerializer<?> getType() {
			return WeaponForgerRecipe.Serializer.INSTANCE;
		}

		@Override
		public JsonObject serializeAdvancement() {
			return this.advancement.serializeToJson();
		}

		@Override
		public ResourceLocation getAdvancementId() {
			return this.advancementId;
		}

	}
}
