package com.skinnydevi.songs_of_war.data.generators.client;

import com.skinnydevi.songs_of_war.SongsOfWarMod;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SOWItemModelProvider extends ItemModelProvider {

	public SOWItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, SongsOfWarMod.MOD_ID, existingFileHelper);
	}

	// private ItemModelBuilder builder(ModelFile itemGenerated, String itemId) {
	// return getBuilder(itemId).parent(itemGenerated).texture("layer0", "item/" +
	// itemId);
	// }

	@Override
	protected void registerModels() {
		// Items
		// ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
	}

}
