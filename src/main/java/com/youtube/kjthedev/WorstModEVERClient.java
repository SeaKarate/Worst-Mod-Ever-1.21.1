package com.youtube.kjthedev;

import com.youtube.kjthedev.item.RenderModCutouts;
import net.fabricmc.api.ClientModInitializer;

public class WorstModEVERClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RenderModCutouts.Renders();

    }
}
