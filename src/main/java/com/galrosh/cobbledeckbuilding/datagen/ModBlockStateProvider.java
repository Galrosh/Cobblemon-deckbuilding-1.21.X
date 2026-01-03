package com.galrosh.cobbledeckbuilding.datagen;

import com.galrosh.cobbledeckbuilding.CobbleDeckBuilding;
import com.galrosh.cobbledeckbuilding.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CobbleDeckBuilding.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.FOIL_BLOCK);

        blockWithItem(ModBlocks.FOIL_ORE);
        blockWithItem(ModBlocks.FOIL_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
