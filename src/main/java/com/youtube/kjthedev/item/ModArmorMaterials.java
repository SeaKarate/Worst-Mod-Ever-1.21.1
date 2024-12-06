package com.youtube.kjthedev.item;

import com.youtube.kjthedev.WorstModEVER;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> SELF_PROMO_ARMOR_MATERIAL = registerArmorMaterial("self_promo",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 4);
            }),20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.SELF_PROMO),
                    List.of(new ArmorMaterial.Layer(Identifier.of(WorstModEVER.MOD_ID, "self_promo"))), 0, 0));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name,Supplier<ArmorMaterial> material ) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(WorstModEVER.MOD_ID, name), material.get());
    }
}
