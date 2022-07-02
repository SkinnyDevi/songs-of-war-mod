package com.skinnydevi.songs_of_war.data.generators.client;

import com.skinnydevi.songs_of_war.SongsOfWarMod;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SOWBlockStateProvider extends BlockStateProvider {

	public SOWBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, SongsOfWarMod.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {

	}

}