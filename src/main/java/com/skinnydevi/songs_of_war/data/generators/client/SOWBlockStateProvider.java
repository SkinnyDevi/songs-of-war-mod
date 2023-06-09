package com.skinnydevi.songs_of_war.data.generators.client;

import com.skinnydevi.songs_of_war.SongsOfWarMod;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SOWBlockStateProvider extends BlockStateProvider {

	public SOWBlockStateProvider(PackOutput pckout, ExistingFileHelper exFileHelper) {
		super(pckout, SongsOfWarMod.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {

	}

}