package com.galrosh.cobbledeckbuilding.datagen;

import com.galrosh.cobbledeckbuilding.CobbleDeckBuilding;
import com.galrosh.cobbledeckbuilding.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CobbleDeckBuilding.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.FOIL.get());
        basicItem(ModItems.RAW_FOIL.get());

        basicItem(ModItems.FOILIUM.get());
        basicItem(ModItems.FOILIUM_GAS.get());

        basicItem(ModItems.CHISEL.get());

        basicItem(ModItems.RADISH.get());

        basicItem(ModItems.DECK.get());
        //basicItem(ModItems.CARD.get());
    }
}
