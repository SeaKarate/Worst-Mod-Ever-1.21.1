package com.youtube.kjthedev.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200000, 255), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,0,5), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,0,5), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,0,5), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,0,5), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,0,5), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,0,5), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,0,5), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,0,5), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,0,5), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,0,5), 1f).build();


}
