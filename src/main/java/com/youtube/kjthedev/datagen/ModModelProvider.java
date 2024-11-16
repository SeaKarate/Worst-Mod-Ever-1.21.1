package com.youtube.kjthedev.datagen;

import com.youtube.kjthedev.block.ModBlocks;
import com.youtube.kjthedev.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SELF_PROMO_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SELF_PROMO_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SELF_PROMO_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SELF_PROMO, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUS_DRINK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIRT_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARLIGHT, Models.GENERATED);
    }
}
