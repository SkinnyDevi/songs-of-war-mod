package com.skinnydevi.songs_of_war.data.generators.server.loot_tables;

import com.skinnydevi.songs_of_war.initializers.BlockInit;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class SOWBlockLootTable extends BlockLoot {

	@Override
	protected void addTables() {
		this.dropSelf(BlockInit.WEAPON_FORGER.get());
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
