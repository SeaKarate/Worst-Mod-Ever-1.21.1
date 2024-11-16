package com.youtube.kjthedev.item;

import com.youtube.kjthedev.WorstModEVER;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Items;

public class ModFuels {

    public static void registerModFuels() {
        FuelRegistry.INSTANCE.add(Items.LAVA_BUCKET, 20000);

        WorstModEVER.LOGGER.info("Registered Mod Fuel Items For " + WorstModEVER.MOD_ID);
    }
}
