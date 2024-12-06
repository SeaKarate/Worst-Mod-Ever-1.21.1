package com.youtube.kjthedev.datagen;

import com.youtube.kjthedev.block.ModBlocks;
import com.youtube.kjthedev.block.custom.SusLampBlock;
import com.youtube.kjthedev.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool self_promo_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SELF_PROMO_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SELF_PROMO_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SELF_PROMO_ORE);

        self_promo_pool.wall(ModBlocks.SELF_PROMO_WALL);
        self_promo_pool.fenceGate(ModBlocks.SELF_PROMO_FENCE_GATE);
        self_promo_pool.fence(ModBlocks.SELF_PROMO_FENCE);
        self_promo_pool.slab(ModBlocks.SELF_PROMO_SLAB);
        self_promo_pool.pressurePlate(ModBlocks.SELF_PROMO_PRESSURE_PLATE);
        self_promo_pool.stairs(ModBlocks.SELF_PROMO_STAIRS);
        self_promo_pool.button(ModBlocks.SELF_PROMO_BUTTON);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.SUSLAMP,blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifer = blockStateModelGenerator.createSubModel(ModBlocks.SUSLAMP,"_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.SUSLAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(SusLampBlock.CLICKED, lampOnIdentifer, lampOffIdentifier)));

        blockStateModelGenerator.registerDoor(ModBlocks.SELF_PROMO_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SELF_PROMO_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SELF_PROMO, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUS_DRINK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIRT_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARLIGHT, Models.GENERATED);
        itemModelGenerator.register(ModItems.NBT_SAVER, Models.GENERATED);

        itemModelGenerator.register(ModItems.SELF_PROMO_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SELF_PROMO_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SELF_PROMO_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SELF_PROMO_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SELF_PROMO_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.SELF_PROMO_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SELF_PROMO_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SELF_PROMO_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SELF_PROMO_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SELF_PROMO_BOOTS));
    }
}
