package com.galrosh.cobbledeckbuilding.item;

import com.galrosh.cobbledeckbuilding.CobbleDeckBuilding;
import com.galrosh.cobbledeckbuilding.item.custom.ChiselItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CobbleDeckBuilding.MODID);

    public static final DeferredItem<Item> DECK = ITEMS.register("deck",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CARD = ITEMS.register("card",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FOIL = ITEMS.register("foil",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_FOIL = ITEMS.register("raw_foil",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> RADISH = ITEMS.register("radish",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RADISH)));

    public static final DeferredItem<Item> FOILIUM = ITEMS.register("foilium",
            () -> new FuelItem(new Item.Properties(), 800));

    public static final DeferredItem<Item> FOILIUM_GAS = ITEMS.register("foilium_gas",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);
    }

}
