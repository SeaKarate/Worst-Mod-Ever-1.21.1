package com.youtube.kjthedev.item.util;

import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;

public class CustomVanillaCommand {
    public void modifySafeFallDistance(PlayerEntity player, double newValue) {
        // Get the player's attribute container
        AttributeContainer attributeContainer = player.getAttributes();

        // Get the safe fall distance attribute (generic safe fall)
        EntityAttributeInstance safeFallInstance = attributeContainer.getCustomInstance(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE);

        // Check if the attribute exists
        if (safeFallInstance != null) {
            // Set the base value for the attribute
            safeFallInstance.setBaseValue(newValue);
        }
    }
}
