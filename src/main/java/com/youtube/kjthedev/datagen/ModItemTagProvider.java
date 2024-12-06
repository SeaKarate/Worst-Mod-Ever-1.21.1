package com.youtube.kjthedev.datagen;

import com.youtube.kjthedev.item.ModItems;
import com.youtube.kjthedev.item.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.DIRT)
                .add(Items.GRASS_BLOCK)
                .add(Items.DIAMOND);
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.SELF_PROMO_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.SELF_PROMO_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.SELF_PROMO_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.SELF_PROMO_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.SELF_PROMO_HOE);
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SELF_PROMO_HELMET)
                .add(ModItems.SELF_PROMO_CHESTPLATE)
                .add(ModItems.SELF_PROMO_LEGGINGS)
                .add(ModItems.SELF_PROMO_BOOTS);
    }
}
