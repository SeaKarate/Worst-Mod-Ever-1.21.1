package com.youtube.kjthedev.item;

import com.youtube.kjthedev.WorstModEVER;
import com.youtube.kjthedev.item.custom.ChiselItem;
import com.youtube.kjthedev.item.custom.SusDrinkItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item SELF_PROMO = registerItem("self_promo", new Item(new Item.Settings()));
    public static final Item STARLIGHT = registerItem("starlight", new Item(new Item.Settings()));
    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)));
    public static final Item SUS_DRINK = registerItem("sus_drink", new SusDrinkItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).food(ModFoodComponents.SUS_DRINK).maxCount(16)));
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