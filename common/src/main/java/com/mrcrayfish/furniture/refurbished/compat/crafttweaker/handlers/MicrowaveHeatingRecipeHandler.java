package com.mrcrayfish.furniture.refurbished.compat.crafttweaker.handlers;

import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.component.BuiltinRecipeComponents;
import com.blamejared.crafttweaker.api.recipe.component.IDecomposedRecipe;
import com.blamejared.crafttweaker.api.recipe.handler.IRecipeHandler;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker.api.util.IngredientUtil;
import com.blamejared.crafttweaker.api.util.StringUtil;
import com.mrcrayfish.furniture.refurbished.crafting.GrillCookingRecipe;
import com.mrcrayfish.furniture.refurbished.crafting.MicrowaveHeatingRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

import java.util.Optional;

/**
 * Author: MrCrayfish
 */
@IRecipeHandler.For(MicrowaveHeatingRecipe.class)
public class MicrowaveHeatingRecipeHandler implements IRecipeHandler<MicrowaveHeatingRecipe>
{
    @Override
    public String dumpToCommandString(IRecipeManager<? super MicrowaveHeatingRecipe> manager, MicrowaveHeatingRecipe recipe)
    {
        return String.format("%s.addRecipe(%s, %s, %s, %s, %s);",
                manager.getCommandString(),
                StringUtil.quoteAndEscape(recipe.getId()),
                IIngredient.fromIngredient(recipe.getInput()).getCommandString(),
                IItemStack.ofMutable(recipe.getOutput()).getCommandString(),
                recipe.getExperience(),
                recipe.getCookingTime());
    }

    @Override
    public <U extends Recipe<?>> boolean doesConflict(IRecipeManager<? super MicrowaveHeatingRecipe> manager, MicrowaveHeatingRecipe firstRecipe, U secondRecipe)
    {
        if(!(secondRecipe instanceof MicrowaveHeatingRecipe toasterRecipe))
            return true;
        // Toaster recipes are conflicting if the input is the same
        return IngredientUtil.canConflict(firstRecipe.getInput(), toasterRecipe.getInput());
    }

    @Override
    public Optional<IDecomposedRecipe> decompose(IRecipeManager<? super MicrowaveHeatingRecipe> manager, MicrowaveHeatingRecipe recipe)
    {
        IDecomposedRecipe decomposedRecipe = IDecomposedRecipe.builder()
                .with(BuiltinRecipeComponents.Input.INGREDIENTS, IIngredient.fromIngredient(recipe.getInput()))
                .with(BuiltinRecipeComponents.Output.ITEMS, IItemStack.ofMutable(recipe.getOutput()))
                .with(BuiltinRecipeComponents.Output.EXPERIENCE, recipe.getExperience())
                .with(BuiltinRecipeComponents.Processing.TIME, recipe.getCookingTime())
                .with(BuiltinRecipeComponents.Metadata.GROUP, recipe.getGroup())
                .with(BuiltinRecipeComponents.Metadata.COOKING_BOOK_CATEGORY, recipe.category())
                .build();
        return Optional.of(decomposedRecipe);
    }

    @Override
    public Optional<MicrowaveHeatingRecipe> recompose(IRecipeManager<? super MicrowaveHeatingRecipe> manager, ResourceLocation id, IDecomposedRecipe recipe)
    {
        Ingredient input = recipe.getOrThrowSingle(BuiltinRecipeComponents.Input.INGREDIENTS).asVanillaIngredient();
        String group = recipe.getOrThrowSingle(BuiltinRecipeComponents.Metadata.GROUP);
        CookingBookCategory category = recipe.getOrThrowSingle(BuiltinRecipeComponents.Metadata.COOKING_BOOK_CATEGORY);
        ItemStack output = recipe.getOrThrowSingle(BuiltinRecipeComponents.Output.ITEMS).getInternal();
        float experience = recipe.getOrThrowSingle(BuiltinRecipeComponents.Output.EXPERIENCE);
        int cookingTime = recipe.getOrThrowSingle(BuiltinRecipeComponents.Processing.TIME);
        return Optional.of(new MicrowaveHeatingRecipe(id, group, category, input, output, experience, cookingTime));
    }
}
