package com.skinnydevi.songs_of_war.initializers;

import com.skinnydevi.songs_of_war.SongsOfWarMod;
import com.skinnydevi.songs_of_war.common.recipes.WeaponForgerRecipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeInit {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister
			.create(ForgeRegistries.RECIPE_SERIALIZERS, SongsOfWarMod.MOD_ID);

	public static final RegistryObject<RecipeSerializer<WeaponForgerRecipe>> WEAPON_FORGER_SERIALIZER = SERIALIZERS
			.register("weapon_forging", () -> WeaponForgerRecipe.Serializer.INSTANCE);

}
