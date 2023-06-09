package com.skinnydevi.songs_of_war.data.generators.server.loot_tables;


import com.skinnydevi.songs_of_war.initializers.BlockInit;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class SOWBlockLootTable extends BlockLootSubProvider {

	public SOWBlockLootTable() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	protected void generate() {
		this.dropSelf(BlockInit.WEAPON_FORGER.get());
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
