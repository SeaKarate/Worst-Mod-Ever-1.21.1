package com.youtube.kjthedev.datagen;

import com.youtube.kjthedev.block.ModBlocks;
import com.youtube.kjthedev.item.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.MAGIC_BLOCK)
                .add(ModBlocks.SELF_PROMO_ORE)
                .add(ModBlocks.SELF_PROMO_BLOCK)
                .add(ModBlocks.SELF_PROMO_DEEPSLATE_ORE);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.SELF_PROMO_ORE)
                .add(ModBlocks.SELF_PROMO_DEEPSLATE_ORE);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SELF_PROMO_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.MAGIC_BLOCK);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.SELF_PROMO_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.SELF_PROMO_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.SELF_PROMO_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_SELF_PROMO_TOOL)
                .add(ModBlocks.MAGIC_BLOCK)
                .add(ModBlocks.SELF_PROMO_ORE)
                .add(ModBlocks.SELF_PROMO_BLOCK)
                .add(ModBlocks.SELF_PROMO_DEEPSLATE_ORE)
                .add(ModBlocks.SELF_PROMO_FENCE)
                .add(ModBlocks.SELF_PROMO_WALL)
                .add(ModBlocks.SELF_PROMO_STAIRS)
                .add(ModBlocks.SELF_PROMO_SLAB)
                .add(ModBlocks.SELF_PROMO_BUTTON)
                .add(ModBlocks.SELF_PROMO_PRESSURE_PLATE)
                .add(ModBlocks.SELF_PROMO_DOOR)
                .add(ModBlocks.SELF_PROMO_TRAPDOOR)
                .add(ModBlocks.SELF_PROMO_FENCE_GATE)

                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

    }
}
