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
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

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
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.SELF_PROMO_DOOR, 3)
                .pattern("## ")
                .pattern("## ")
                .pattern("## ")
                .input('#', ModItems.SELF_PROMO)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,ModBlocks.SELF_PROMO_TRAPDOOR, 4)
                .pattern("   ")
                .pattern("# #")
                .pattern("###")
                .input('#', ModItems.SELF_PROMO)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.SELF_PROMO_FENCE, 6)
                .pattern("   ")
                .pattern("#S#")
                .pattern("#S#")
                .input('#', ModItems.SELF_PROMO)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.SELF_PROMO_FENCE_GATE, 2)
                .pattern("   ")
                .pattern("S#S")
                .pattern("S#S")
                .input('#', ModItems.SELF_PROMO)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,ModBlocks.SELF_PROMO_PRESSURE_PLATE, 2)
                .pattern("   ")
                .pattern("   ")
                .pattern("###")
                .input('#', ModItems.SELF_PROMO)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.SELF_PROMO_SLAB, 4)
                .pattern("   ")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.SELF_PROMO)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.SELF_PROMO_STAIRS, 12)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModItems.SELF_PROMO)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE,ModBlocks.SELF_PROMO_BUTTON,6)
                .input(ModItems.SELF_PROMO)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.SELF_PROMO_WALL, 6)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.SELF_PROMO)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModItems.NBT_SAVER, 1)
                .pattern(" # ")
                .pattern("###")
                .pattern(" # ")
                .input('#', Items.DIRT)
                .criterion(hasItem(Items.DIRT),conditionsFromItem(Items.DIRT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE,ModBlocks.SUSLAMP,1)
                .pattern(" # ")
                .pattern("#R#")
                .pattern(" # ")
                .input('#', Items.WHITE_WOOL)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE),conditionsFromItem(Items.REDSTONE))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.SELF_PROMO_SWORD,1)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" S ")
                .input('#', ModItems.SELF_PROMO)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.SELF_PROMO_PICKAXE,1)
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .input('#', ModItems.SELF_PROMO)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.SELF_PROMO_AXE,1)
                .pattern(" ##")
                .pattern(" S#")
                .pattern(" S ")
                .input('#', ModItems.SELF_PROMO)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.SELF_PROMO_SHOVEL,1)
                .pattern(" # ")
                .pattern(" S ")
                .pattern(" S ")
                .input('#', ModItems.SELF_PROMO)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.SELF_PROMO_HOE,1)
                .pattern("## ")
                .pattern(" S ")
                .pattern(" S ")
                .input('#', ModItems.SELF_PROMO)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,ModItems.SELF_PROMO_HAMMER,1)
                .pattern("DDD")
                .pattern("D#D")
                .pattern(" S ")
                .input('#', ModItems.SELF_PROMO)
                .input('D', Items.DIAMOND_BLOCK)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.SELF_PROMO_BOOTS,1)
                .pattern("   ")
                .pattern("# #")
                .pattern("# #")
                .input('#', ModItems.SELF_PROMO)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.SELF_PROMO_LEGGINGS,1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', ModItems.SELF_PROMO)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.SELF_PROMO_CHESTPLATE,1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.SELF_PROMO)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.SELF_PROMO_HELMET,1)
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
                .input('#', ModItems.SELF_PROMO)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.SELF_PROMO_HORSE_ARMOR,1)
                .pattern("  #")
                .pattern("#L#")
                .pattern("###")
                .input('#', ModItems.SELF_PROMO)
                .input('L', Items.LEATHER)
                .criterion(hasItem(ModItems.SELF_PROMO),conditionsFromItem(ModItems.SELF_PROMO))
                .offerTo(recipeExporter);
    }
}
