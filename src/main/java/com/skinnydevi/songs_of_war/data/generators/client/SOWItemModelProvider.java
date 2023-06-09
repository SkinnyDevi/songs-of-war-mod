package com.skinnydevi.songs_of_war.data.generators.client;

import com.skinnydevi.songs_of_war.SongsOfWarMod;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SOWItemModelProvider extends ItemModelProvider {

	public SOWItemModelProvider(PackOutput pckout, ExistingFileHelper existingFileHelper) {
		super(pckout, SongsOfWarMod.MOD_ID, existingFileHelper);
	}

	private ResourceLocation blockLoc(String blockId) {
		return modLoc("block/" + blockId);
	}

	// private ItemModelBuilder builder(ModelFile itemGenerated, String itemId) {
	// return getBuilder(itemId).parent(itemGenerated).texture("layer0", "item/" +
	// itemId);
	// }

	@Override
	protected void registerModels() {
		// BlockItems
		withExistingParent("weapon_forger", blockLoc("weapon_forger"));

		// Items
		// ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
	}

}
