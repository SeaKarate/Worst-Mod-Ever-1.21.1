package com.youtube.kjthedev.block;

import com.youtube.kjthedev.WorstModEVER;
import com.youtube.kjthedev.block.custom.MagicBlock;
import com.youtube.kjthedev.block.custom.SusLampBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.List;

public class ModBlocks {

    public static final Block SELF_PROMO_BLOCK = registerBlock("self_promo_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.DECORATED_POT)){
                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
                    tooltip.add(Text.translatable("tooltip.worst-mod-ever.self-promo.tooltip"));
                    super.appendTooltip(stack, context, tooltip, options);
                }
            });
    public static final Block SELF_PROMO_ORE = registerBlock("self_promo_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block SELF_PROMO_DEEPSLATE_ORE = registerBlock("self_promo_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()));
    public static final Block SELF_PROMO_STAIRS = registerBlock("self_promo_stairs",
            new StairsBlock(ModBlocks.SELF_PROMO_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block SELF_PROMO_SLAB = registerBlock("self_promo_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block SELF_PROMO_BUTTON = registerBlock("self_promo_button",
            new ButtonBlock(BlockSetType.IRON,2, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));
    public static final Block SELF_PROMO_PRESSURE_PLATE = registerBlock("self_promo_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block SELF_PROMO_FENCE = registerBlock("self_promo_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block SELF_PROMO_FENCE_GATE = registerBlock("self_promo_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block SELF_PROMO_WALL = registerBlock("self_promo_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block SELF_PROMO_DOOR = registerBlock("self_promo_door",
            new DoorBlock(BlockSetType.IRON,AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
    public static final Block SELF_PROMO_TRAPDOOR = registerBlock("self_promo_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block SUSLAMP = registerBlock("suslamp",
            new SusLampBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .luminance(state -> state.get(SusLampBlock.CLICKED) ? 15 : 0)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(WorstModEVER.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name,Block block){
        Registry.register(Registries.ITEM, Identifier.of(WorstModEVER.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        WorstModEVER.LOGGER.info("Registering Mod Blocks for " + WorstModEVER.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SELF_PROMO_BLOCK);
        });
    }
}