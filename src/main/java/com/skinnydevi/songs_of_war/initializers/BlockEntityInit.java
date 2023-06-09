package com.skinnydevi.songs_of_war.initializers;

import com.skinnydevi.songs_of_war.SongsOfWarMod;
import com.skinnydevi.songs_of_war.common.blocks.entity.WeaponForgerBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SongsOfWarMod.MOD_ID);

	public static final RegistryObject<BlockEntityType<WeaponForgerBlockEntity>> WEAPON_FORGER_BLOCK_ENTITY = BLOCK_ENTITIES
			.register("weapon_forger_block_entity", () -> BlockEntityType.Builder
					.of(WeaponForgerBlockEntity::new, BlockInit.WEAPON_FORGER.get()).build(null));
}
