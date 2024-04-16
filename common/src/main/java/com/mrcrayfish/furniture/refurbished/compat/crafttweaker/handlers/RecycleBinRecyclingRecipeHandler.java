package com.mrcrayfish.furniture.refurbished.compat.crafttweaker.handlers;

import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.component.BuiltinRecipeComponents;
import com.blamejared.crafttweaker.api.recipe.component.IDecomposedRecipe;
import com.blamejared.crafttweaker.api.recipe.handler.IRecipeHandler;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker.api.util.StringUtil;
import com.mrcrayfish.furniture.refurbished.crafting.RecycleBinRecyclingRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Author: MrCrayfish
 */
@IRecipeHandler.For(RecycleBinRecyclingRecipe.class)
public class RecycleBinRecyclingRecipeHandler implements IRecipeHandler<RecycleBinRecyclingRecipe>
{
    @Override
    public String dumpToCommandString(IRecipeManager<? super RecycleBinRecyclingRecipe> manager, RecycleBinRecyclingRecipe recipe)
    {
        return String.format("%s.addRecipe(%s, %s, %s);",
                manager.getCommandString(),
                StringUtil.quoteAndEscape(recipe.getId()),
                IItemStack.ofMutable(recipe.getRecyclable()).getCommandString(),
                "[" + String.join(", ", recipe.getScraps().stream().map(stack -> IItemStack.ofMutable(stack).getCommandString()).toArray(String[]::new)) + "]");
    }

    @Override
    public <U extends Recipe<?>> boolean doesConflict(IRecipeManager<? super RecycleBinRecyclingRecipe> manager, RecycleBinRecyclingRecipe firstRecipe, U secondRecipe)
    {
        if(!(secondRecipe instanceof RecycleBinRecyclingRecipe recyclingRecipe))
            return true;
        return ItemStack.isSameItem(firstRecipe.getRecyclable(), recyclingRecipe.getRecyclable());
    }

    @Override
    public Optional<IDecomposedRecipe> decompose(IRecipeManager<? super RecycleBinRecyclingRecipe> manager, RecycleBinRecyclingRecipe recipe)
    {
        IDecomposedRecipe decomposedRecipe = IDecomposedRecipe.builder()
                .with(BuiltinRecipeComponents.Input.INGREDIENTS, IItemStack.of(recipe.getRecyclable()))
                .with(BuiltinRecipeComponents.Output.ITEMS, recipe.getScraps().stream().map(IItemStack::ofMutable).collect(Collectors.toList()))
                .build();
        return Optional.of(decomposedRecipe);
    }

    @Override
    public Optional<RecycleBinRecyclingRecipe> recompose(IRecipeManager<? super RecycleBinRecyclingRecipe> manager, ResourceLocation id, IDecomposedRecipe recipe)
    {
        ItemStack recyclable = recipe.getOrThrowSingle(BuiltinRecipeComponents.Input.INGREDIENTS).asVanillaIngredient().getItems()[0];
        ItemStack[] scraps = recipe.get(BuiltinRecipeComponents.Output.ITEMS).stream().map(IItemStack::getInternal).toArray(ItemStack[]::new);
        return Optional.of(new RecycleBinRecyclingRecipe(id, recyclable, NonNullList.of(ItemStack.EMPTY, scraps)));
    }
}
