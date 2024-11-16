package com.youtube.kjthedev.datagen;

import com.youtube.kjthedev.WorstModEVER;
import com.youtube.kjthedev.block.ModBlocks;
import com.youtube.kjthedev.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.world.chunk.light.LightStorage;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> SELF_PROMO_SMELTABLES = List.of(ModBlocks.SELF_PROMO_ORE,ModBlocks.SELF_PROMO_DEEPSLATE_ORE,ModBlocks.SELF_PROMO_BLOCK);
        offerSmelting(recipeExporter, SELF_PROMO_SMELTABLES, RecipeCategory.MISC, ModItems.SELF_PROMO, 150f, 1, "self_promo");
        offerBlasting(recipeExporter, SELF_PROMO_SMELTABLES, RecipeCategory.MISC, ModItems.SELF_PROMO, 150f, 1, "self_promo");

        offerReversibleCompactingRecipes(recipeExporter,RecipeCategory.BUILDING_BLOCKS,ModItems.SELF_PROMO,RecipeCategory.MISC,ModBlocks.SELF_PROMO_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.DIRT_CHISEL, 1)
                .pattern("DDD")
                .pattern("DRD")
                .pattern("ddd")
                .input('D', Items.DIAMOND_BLOCK)
                .input('d', Items.DIRT)
                .input('R', Items.REDSTONE_BLOCK)
                .criterion(hasItem(Items.REDSTONE_BLOCK),conditionsFromItem(Items.REDSTONE_BLOCK))
                .offerTo(recipeExporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.STARLIGHT,1)
                .input(Items.COAL)
                .criterion(hasItem(Items.COAL),conditionsFromItem(Items.COAL))
                .offerTo(recipeExporter, Identifier.of(WorstModEVER.MOD_ID,"starlight_from_coal_broken_xd"));
    }
}
