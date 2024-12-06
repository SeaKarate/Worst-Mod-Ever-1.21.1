package com.youtube.kjthedev;

import com.youtube.kjthedev.block.ModBlocks;
import com.youtube.kjthedev.component.ModDataComponentTypes;
import com.youtube.kjthedev.item.ModItemGroups;
import com.youtube.kjthedev.item.ModItems;
import com.youtube.kjthedev.item.ModFuels;
import com.youtube.kjthedev.item.ModUsageEvents;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorstModEVER implements ModInitializer {
	public static final String MOD_ID = "worst-mod-ever";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModFuels.registerModFuels();
		ModDataComponentTypes.registerDataComponentTypes();
		ModUsageEvents.registerModEvents();

	}
}