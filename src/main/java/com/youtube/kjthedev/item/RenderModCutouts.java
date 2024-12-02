package com.youtube.kjthedev.item;

import com.youtube.kjthedev.WorstModEVER;
import com.youtube.kjthedev.block.ModBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class RenderModCutouts {
    public static void Renders() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SELF_PROMO_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SELF_PROMO_TRAPDOOR, RenderLayer.getCutout());

        WorstModEVER.LOGGER.info("Registered Cutouts For " + WorstModEVER.MOD_ID);
    }
}
