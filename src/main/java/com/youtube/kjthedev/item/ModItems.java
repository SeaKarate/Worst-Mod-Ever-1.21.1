package com.youtube.kjthedev.item;

import com.youtube.kjthedev.WorstModEVER;
import com.youtube.kjthedev.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item SELF_PROMO = registerItem("self_promo", new Item(new Item.Settings()));
    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)));
    public static final Item INF_CAULIFLOWER = registerItem("inf_cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER).recipeRemainder(ModItems.INF_CAULIFLOWER)));
    public static final Item DIRT_CHISEL = registerItem("dirt_chisel", new ChiselItem(new Item.Settings().maxDamage(32767)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(WorstModEVER.MOD_ID, name), item);
    }

    public static void registerModItems() {
        WorstModEVER.LOGGER.info("Registering Mod Items for " + WorstModEVER.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SELF_PROMO);
        });
    }

}