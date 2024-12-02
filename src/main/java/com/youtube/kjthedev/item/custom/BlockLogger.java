package com.youtube.kjthedev.item.custom;

import com.youtube.kjthedev.component.ModDataComponentTypes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.WordPackedArray;
import net.minecraft.world.World;

import java.util.List;

public class BlockLogger extends Item {
    public BlockLogger(Settings settings) {
        super(settings);

    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getBlockPos();

        context.getStack().set(ModDataComponentTypes.COORDINATES,context.getBlockPos());
        context.getStack().set(ModDataComponentTypes.STATE,context.getWorld().getBlockState(blockpos));

        if (!world.isClient) {
            context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

            world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        if (stack.get(ModDataComponentTypes.COORDINATES) != null && stack.get(ModDataComponentTypes.STATE) != null) {
            tooltip.add(Text.literal("You Saved " + stack.get(ModDataComponentTypes.STATE) + " At " + stack.get(ModDataComponentTypes.COORDINATES)));
        }
    }
}
