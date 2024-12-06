package com.youtube.kjthedev.item;

import com.youtube.kjthedev.item.util.HammerUsageEvent;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

public class ModUsageEvents {
    public static void registerModEvents() {
        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
    }
}
