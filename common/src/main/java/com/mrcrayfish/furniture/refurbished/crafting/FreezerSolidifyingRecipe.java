package com.mrcrayfish.furniture.refurbished.crafting;

import com.mrcrayfish.furniture.refurbished.core.ModRecipeSerializers;
import com.mrcrayfish.furniture.refurbished.core.ModRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

/**
 * Author: MrCrayfish
 */
public class FreezerSolidifyingRecipe extends AbstractCookingRecipe
{
    public FreezerSolidifyingRecipe(String group, CookingBookCategory category, Ingredient ingredient, ItemStack stack, float experience, int cookingTime)
    {
        super(ModRecipeTypes.FREEZER_SOLIDIFYING.get(), group, category, ingredient, stack, experience, cookingTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer()
    {
        return ModRecipeSerializers.FREEZER_RECIPE.get();
    }

    public Ingredient getInput()
    {
        return this.ingredient;
    }

    public ItemStack getOutput()
    {
        return this.result;
    }
}