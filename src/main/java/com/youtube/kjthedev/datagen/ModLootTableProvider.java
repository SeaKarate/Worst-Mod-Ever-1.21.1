package com.youtube.kjthedev.datagen;

import com.youtube.kjthedev.block.ModBlocks;
import com.youtube.kjthedev.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MAGIC_BLOCK);
        addDrop(ModBlocks.SUSLAMP);
        addDrop(ModBlocks.SELF_PROMO_BLOCK);
        addDrop(ModBlocks.SELF_PROMO_WALL);
        addDrop(ModBlocks.SELF_PROMO_DOOR, doorDrops(ModBlocks.SELF_PROMO_DOOR));
        addDrop(ModBlocks.SELF_PROMO_TRAPDOOR);
        addDrop(ModBlocks.SELF_PROMO_BUTTON);
        addDrop(ModBlocks.SELF_PROMO_FENCE_GATE);
        addDrop(ModBlocks.SELF_PROMO_FENCE);
        addDrop(ModBlocks.SELF_PROMO_PRESSURE_PLATE);
        addDrop(ModBlocks.SELF_PROMO_SLAB, slabDrops(ModBlocks.SELF_PROMO_SLAB));
        addDrop(ModBlocks.SELF_PROMO_STAIRS);
        addDrop(ModBlocks.SELF_PROMO_ORE, multipleOreDrops(ModBlocks.SELF_PROMO_ORE, ModItems.SELF_PROMO,1,3));
        addDrop(ModBlocks.SELF_PROMO_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.SELF_PROMO_DEEPSLATE_ORE, ModItems.SELF_PROMO, 2,5));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
