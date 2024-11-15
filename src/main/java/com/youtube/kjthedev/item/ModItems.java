package com.youtube.kjthedev.item;

import com.youtube.kjthedev.WorstModEVER;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item SELF_PROMO = registerItem("self_promo", new Item(new Item.Settings()));

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