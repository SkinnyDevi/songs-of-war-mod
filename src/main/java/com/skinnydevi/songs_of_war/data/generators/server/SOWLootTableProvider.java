package com.skinnydevi.songs_of_war.data.generators.server;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;

import com.mojang.datafixers.util.Pair;

import com.skinnydevi.songs_of_war.data.generators.server.loot_tables.SOWBlockLootTable;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class SOWLootTableProvider extends LootTableProvider {
	public SOWLootTableProvider(PackOutput pckout) {
		super(pckout, Set.of(),
				List.of(new SubProviderEntry(SOWBlockLootTable::new, LootContextParamSets.BLOCK)));
	}
}
