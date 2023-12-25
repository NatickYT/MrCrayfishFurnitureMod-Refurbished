package com.mrcrayfish.furniture.refurbished.util;

import com.mrcrayfish.furniture.refurbished.Constants;
import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.objects.Object2IntOpenCustomHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Author: MrCrayfish
 */
public class Utils
{
    /**
     * Utility to create a ResourceLocation specific to this mod
     *
     * @param name the name of the resource. can be a path
     * @return a resource location instance
     */
    public static ResourceLocation resource(String name)
    {
        return new ResourceLocation(Constants.MOD_ID, name);
    }

    /**
     * Creates a translatable Component specific to this mod. The translation key
     * uses a common format of a category, followed by the mod id, and then a path.
     *
     * @param category the category of the translation
     * @param path     the path of the translation
     * @return A translatable component
     */
    public static MutableComponent translation(String category, String path, Object ... params)
    {
        return Component.translatable(String.format("%s.%s.%s", category, Constants.MOD_ID, path), params);
    }

    /**
     * A Fisher–Yates shuffle implementation that uses Minecraft's RandomSource.
     *
     * @param list   a list
     * @param random a random source instance
     * @param <T>    any object type
     */
    public static <T> void shuffle(List<T> list, RandomSource random)
    {
        for(int i = list.size() - 1; i > 0; i--)
        {
            int randIndex = random.nextIntBetweenInclusive(0, i);
            T temp = list.get(i);
            list.set(i, list.get(randIndex));
            list.set(randIndex, temp);
        }
    }

    /**
     * Utility method to convert pixel units into world units. One pixel equals 0.0625 world units.
     *
     * @param value the input pixel unit
     * @return a world unit representation of the pixel input units.
     */
    public static double pixels(double value)
    {
        return value * 0.0625;
    }

    /**
     * Counts all the items in the given containers from the direction they are being accessed.
     *
     * @param skipDamaged if items that are damaged should be skipped in the count
     * @param containers  an array of container and direction pairs. The direction is the side the container is being accessed. The direction can be null.
     * @return a map containing items and their counts
     */
    public static Map<Item, Integer> countItems(boolean skipDamaged, List<Pair<Direction, Container>> containers)
    {
        Map<Item, Integer> map = new Object2IntOpenCustomHashMap<>(ItemHash.INSTANCE);
        for(Pair<Direction, Container> pair : containers)
        {
            Direction direction = pair.first();
            Container container = pair.second();
            getContainerSlots(container, direction).forEach(slot -> {
                ItemStack stack = container.getItem(slot);
                if(stack.isEmpty() || (skipDamaged && stack.isDamaged()))
                    return;
                if(!canTakeFromContainer(container, slot, stack, direction))
                    return;
                map.merge(stack.getItem(), stack.getCount(), Integer::sum);
            });
        }
        return map;
    }

    /**
     * Utility method to stream the available slots indexes of a given container, with an optional
     * direction representing the face of the block the container is being accessed from. This method
     * handles if the container is an instance of a worldly container, only returning slots that
     * are accessible from the given face (direction).
     *
     * @param container the container that is being accessed.
     * @param direction the side of the block the container is being accessed from or null.
     * @return An int stream of available slots
     */
    public static IntStream getContainerSlots(Container container, @Nullable Direction direction)
    {
        if(direction != null && container instanceof WorldlyContainer worldly)
        {
            return IntStream.of(worldly.getSlotsForFace(direction));
        }
        return IntStream.range(0, container.getContainerSize());
    }

    /**
     * Utility method to determine if the stack in the given slot can be taken from the given container.
     * This method handles if the container is an instance of a worldly container, and additionally
     * checks if the item can be taken through the face (direction).
     *
     * @param container the container that is being accessed
     * @param slot      the slot index of the stack being taken
     * @param stack     the stack that is being taken
     * @param direction the face of the block the container is being accessed from or null.
     * @return True if the stack can be taken
     */
    public static boolean canTakeFromContainer(Container container, int slot, ItemStack stack, @Nullable Direction direction)
    {
        if(container.canTakeItem(container, slot, stack))
        {
            if(direction != null && container instanceof WorldlyContainer worldly)
            {
                return worldly.canTakeItemThroughFace(slot, stack, direction);
            }
            return true;
        }
        return false;
    }
}
