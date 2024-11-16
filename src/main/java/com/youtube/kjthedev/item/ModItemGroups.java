package com.youtube.kjthedev.item;

import com.youtube.kjthedev.WorstModEVER;
import com.youtube.kjthedev.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(WorstModEVER.MOD_ID, "worst_block_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.MAGIC_BLOCK))
                    .displayName(Text.translatable("itemgroup.worst-mod-ever.worstgroupblock"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.SELF_PROMO_BLOCK);
                        entries.add(ModBlocks.SELF_PROMO_ORE);
                        entries.add(ModBlocks.SELF_PROMO_DEEPSLATE_ORE);
                        entries.add(ModBlocks.MAGIC_BLOCK);

                    }).build());

    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(WorstModEVER.MOD_ID, "worst_item_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.DIRT_CHISEL))
                    .displayName(Text.translatable("itemgroup.worst-mod-ever.worstgroupitem"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SELF_PROMO);
                        entries.add(ModItems.DIRT_CHISEL);
                        entries.add(ModItems.CAULIFLOWER);
                        entries.add(ModItems.INF_CAULIFLOWER);

                    }).build());


    public static void registerItemGroups() {
        WorstModEVER.LOGGER.info("Registering Item Groups for " + WorstModEVER.MOD_ID);
    }
}