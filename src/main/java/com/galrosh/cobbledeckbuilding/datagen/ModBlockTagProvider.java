package com.galrosh.cobbledeckbuilding.datagen;

import com.galrosh.cobbledeckbuilding.CobbleDeckBuilding;
import com.galrosh.cobbledeckbuilding.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {


    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CobbleDeckBuilding.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.FOIL_BLOCK.get())
                .add(ModBlocks.FOIL_ORE.get())
                .add(ModBlocks.FOIL_DEEPSLATE_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.FOIL_DEEPSLATE_ORE.get());

    }
}
