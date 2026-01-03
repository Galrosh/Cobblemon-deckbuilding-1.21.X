package com.galrosh.cobbledeckbuilding.datagen;

import com.galrosh.cobbledeckbuilding.CobbleDeckBuilding;
import com.galrosh.cobbledeckbuilding.block.ModBlocks;
import com.galrosh.cobbledeckbuilding.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> FOIL_SMELTABLES = List.of(ModItems.RAW_FOIL,
                ModBlocks.FOIL_ORE, ModBlocks.FOIL_DEEPSLATE_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FOIL_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.FOIL.get())
                .unlockedBy("has_foil", has(ModItems.FOIL)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FOIL.get(), 9)
                .requires(ModBlocks.FOIL_BLOCK)
                .unlockedBy("has_foil_block", has(ModBlocks.FOIL_BLOCK)).save(recipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FOIL.get(), 18)
                .requires(ModBlocks.MAGIC_BLOCK)
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK))
                .save(recipeOutput, "cobbledeckbuilding:foil_from_magic_block");


        oreSmelting(recipeOutput, FOIL_SMELTABLES, RecipeCategory.MISC, ModItems.FOIL.get(), 0.25f,200,"foil");
        oreBlasting(recipeOutput, FOIL_SMELTABLES, RecipeCategory.MISC, ModItems.FOIL.get(), 0.25f,100,"foil");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, CobbleDeckBuilding.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
