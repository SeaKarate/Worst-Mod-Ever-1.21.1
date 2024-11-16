package com.youtube.kjthedev.block.custom;

import com.youtube.kjthedev.item.ModItems;
import com.youtube.kjthedev.item.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class MagicBlock extends Block {
    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                                 BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1f, 1f);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if(isValidItem(itemEntity.getStack())) {
                            itemEntity.setStack(new ItemStack(Items.DIAMOND_BLOCK, itemEntity.getStack().getCount()));
            }
            if(itemEntity.getStack().getItem() == Items.GLASS_BOTTLE) {
                            itemEntity.setStack(new ItemStack(ModItems.SUS_DRINK, itemEntity.getStack().getCount()));
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.worst-mod-ever.magic_block.tooltip"));
        tooltip.add(Text.translatable("tooltip.worst-mod-ever.magic_block.tooltip1"));
        tooltip.add(Text.translatable("tooltip.worst-mod-ever.magic_block.tooltip2"));
        tooltip.add(Text.translatable("tooltip.worst-mod-ever.magic_block.tooltip3"));
        tooltip.add(Text.translatable("tooltip.worst-mod-ever.magic_block.tooltip4"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}
