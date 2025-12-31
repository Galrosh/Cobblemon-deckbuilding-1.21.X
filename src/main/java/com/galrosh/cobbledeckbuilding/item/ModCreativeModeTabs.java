package com.galrosh.cobbledeckbuilding.item;

import com.galrosh.cobbledeckbuilding.CobbleDeckBuilding;
import com.galrosh.cobbledeckbuilding.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CobbleDeckBuilding.MODID);


    public static final Supplier<CreativeModeTab> COBBLEDECK_ITEMS_TAB = CREATIVE_MODE_TAB.register("cobbledeck_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DECK.get()))
                    .title(Component.translatable("creativetab.cobbledeckbuilding.cobbledeck_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModItems.DECK);
                      output.accept(ModItems.CARD);
                      output.accept(ModItems.FOIL);
                    }).build());

    public static final Supplier<CreativeModeTab> COBBLEDECK_BLOCKS_TAB = CREATIVE_MODE_TAB.register("cobbledeck_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.FOIL_ORE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CobbleDeckBuilding.MODID, "cobbledeck_items_tab"))
                    .title(Component.translatable("creativetab.cobbledeckbuilding.cobbledeck_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModBlocks.FOIL_ORE);
                      output.accept(ModBlocks.FOIL_BLOCK);
                      output.accept(ModBlocks.FOIL_DEEPSLATE_ORE);

                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }





}
