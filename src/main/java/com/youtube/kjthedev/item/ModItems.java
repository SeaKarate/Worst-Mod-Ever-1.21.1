package com.youtube.kjthedev.item;

import com.youtube.kjthedev.WorstModEVER;
import com.youtube.kjthedev.item.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {

    public static final Item SELF_PROMO = registerItem("self_promo", new Item(new Item.Settings()));
    public static final Item STARLIGHT = registerItem("starlight", new Item(new Item.Settings()));
    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)));
    public static final Item SUS_DRINK = registerItem("sus_drink", new SusDrinkItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).food(ModFoodComponents.SUS_DRINK).maxCount(16)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.worst-mod-ever.sus_drink"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item DIRT_CHISEL = registerItem("dirt_chisel", new ChiselItem(new Item.Settings().maxDamage(32767)));
    public static final Item NBT_SAVER = registerItem("nbt_saver", new BlockLogger(new Item.Settings().maxDamage(16)));
    public static final Item SELF_PROMO_SWORD = registerItem("self_promo_sword",
            new SwordItem(ModToolMaterials.SELF_PROMO_OP, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SELF_PROMO_OP,3,-2.4f))));

    public static final Item SELF_PROMO_PICKAXE = registerItem("self_promo_pickaxe",
            new PickaxeItem(ModToolMaterials.SELF_PROMO_OP, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SELF_PROMO_OP,3,-2.4f))));

    public static final Item SELF_PROMO_SHOVEL = registerItem("self_promo_shovel",
            new ShovelItem(ModToolMaterials.SELF_PROMO_OP, new Item.Settings()
            .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.SELF_PROMO_OP,1.5f,-3.0f))));

    public static final Item SELF_PROMO_AXE = registerItem("self_promo_axe",
            new AxeItem(ModToolMaterials.SELF_PROMO_OP, new Item.Settings()
            .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.SELF_PROMO_OP,6,-3.2f))));

    public static final Item SELF_PROMO_HOE = registerItem("self_promo_hoe",
            new HoeItem(ModToolMaterials.SELF_PROMO_OP, new Item.Settings()
            .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.SELF_PROMO_OP,0,-3))));

    public static final Item SELF_PROMO_HAMMER= registerItem("self_promo_hammer",
            new HammerItem(ModToolMaterials.SELF_PROMO_HAMMER, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SELF_PROMO_OP,7,-3.4f))));

    public static final Item SELF_PROMO_HELMET = registerItem("self_promo_helmet",
            new ModArmorItem(ModArmorMaterials.SELF_PROMO_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item SELF_PROMO_CHESTPLATE = registerItem("self_promo_chestplate",
            new ArmorItem(ModArmorMaterials.SELF_PROMO_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item SELF_PROMO_LEGGINGS = registerItem("self_promo_leggings",
            new ArmorItem(ModArmorMaterials.SELF_PROMO_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item SELF_PROMO_BOOTS = registerItem("self_promo_boots",
            new ArmorItem(ModArmorMaterials.SELF_PROMO_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item SELF_PROMO_HORSE_ARMOR = registerItem("self_promo_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.SELF_PROMO_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN,false,new Item.Settings().maxCount(1)));


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