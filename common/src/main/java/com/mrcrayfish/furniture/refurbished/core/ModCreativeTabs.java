package com.mrcrayfish.furniture.refurbished.core;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import com.mrcrayfish.furniture.refurbished.Constants;
import com.mrcrayfish.furniture.refurbished.util.Utils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/**
 * Author: MrCrayfish
 */
@RegistryContainer
public class ModCreativeTabs
{
    public static final RegistryEntry<CreativeModeTab> MAIN = RegistryEntry.creativeModeTab(Utils.resource("creative_tab"), builder -> {
        builder.icon(() -> new ItemStack(ModBlocks.TABLE_OAK.get()));
        builder.title(Component.translatable("itemGroup." + Constants.MOD_ID).withStyle(ChatFormatting.GOLD));
        builder.displayItems((params, output) -> {
            output.accept(ModBlocks.CHAIR_OAK.get());
            output.accept(ModBlocks.CHAIR_SPRUCE.get());
            output.accept(ModBlocks.CHAIR_BIRCH.get());
            output.accept(ModBlocks.CHAIR_JUNGLE.get());
            output.accept(ModBlocks.CHAIR_ACACIA.get());
            output.accept(ModBlocks.CHAIR_DARK_OAK.get());
            output.accept(ModBlocks.CHAIR_MANGROVE.get());
            output.accept(ModBlocks.CHAIR_CHERRY.get());
            output.accept(ModBlocks.CHAIR_CRIMSON.get());
            output.accept(ModBlocks.CHAIR_WARPED.get());
            output.accept(ModBlocks.TABLE_OAK.get());
            output.accept(ModBlocks.TABLE_SPRUCE.get());
            output.accept(ModBlocks.TABLE_BIRCH.get());
            output.accept(ModBlocks.TABLE_JUNGLE.get());
            output.accept(ModBlocks.TABLE_ACACIA.get());
            output.accept(ModBlocks.TABLE_DARK_OAK.get());
            output.accept(ModBlocks.TABLE_MANGROVE.get());
            output.accept(ModBlocks.TABLE_CHERRY.get());
            output.accept(ModBlocks.TABLE_CRIMSON.get());
            output.accept(ModBlocks.TABLE_WARPED.get());
            output.accept(ModBlocks.DESK_OAK.get());
            output.accept(ModBlocks.DESK_SPRUCE.get());
            output.accept(ModBlocks.DESK_BIRCH.get());
            output.accept(ModBlocks.DESK_JUNGLE.get());
            output.accept(ModBlocks.DESK_ACACIA.get());
            output.accept(ModBlocks.DESK_DARK_OAK.get());
            output.accept(ModBlocks.DESK_MANGROVE.get());
            output.accept(ModBlocks.DESK_CHERRY.get());
            output.accept(ModBlocks.DESK_CRIMSON.get());
            output.accept(ModBlocks.DESK_WARPED.get());
            output.accept(ModBlocks.DRAWER_OAK.get());
            output.accept(ModBlocks.DRAWER_SPRUCE.get());
            output.accept(ModBlocks.DRAWER_BIRCH.get());
            output.accept(ModBlocks.DRAWER_JUNGLE.get());
            output.accept(ModBlocks.DRAWER_ACACIA.get());
            output.accept(ModBlocks.DRAWER_DARK_OAK.get());
            output.accept(ModBlocks.DRAWER_MANGROVE.get());
            output.accept(ModBlocks.DRAWER_CHERRY.get());
            output.accept(ModBlocks.DRAWER_CRIMSON.get());
            output.accept(ModBlocks.DRAWER_WARPED.get());
            output.accept(ModBlocks.SOFA_WHITE.get());
            output.accept(ModBlocks.SOFA_ORANGE.get());
            output.accept(ModBlocks.SOFA_MAGENTA.get());
            output.accept(ModBlocks.SOFA_LIGHT_BLUE.get());
            output.accept(ModBlocks.SOFA_YELLOW.get());
            output.accept(ModBlocks.SOFA_LIME.get());
            output.accept(ModBlocks.SOFA_PINK.get());
            output.accept(ModBlocks.SOFA_GRAY.get());
            output.accept(ModBlocks.SOFA_LIGHT_GRAY.get());
            output.accept(ModBlocks.SOFA_CYAN.get());
            output.accept(ModBlocks.SOFA_PURPLE.get());
            output.accept(ModBlocks.SOFA_BLUE.get());
            output.accept(ModBlocks.SOFA_BROWN.get());
            output.accept(ModBlocks.SOFA_GREEN.get());
            output.accept(ModBlocks.SOFA_RED.get());
            output.accept(ModBlocks.SOFA_BLACK.get());
            output.accept(ModBlocks.STOOL_WHITE.get());
            output.accept(ModBlocks.STOOL_ORANGE.get());
            output.accept(ModBlocks.STOOL_MAGENTA.get());
            output.accept(ModBlocks.STOOL_LIGHT_BLUE.get());
            output.accept(ModBlocks.STOOL_YELLOW.get());
            output.accept(ModBlocks.STOOL_LIME.get());
            output.accept(ModBlocks.STOOL_PINK.get());
            output.accept(ModBlocks.STOOL_GRAY.get());
            output.accept(ModBlocks.STOOL_LIGHT_GRAY.get());
            output.accept(ModBlocks.STOOL_CYAN.get());
            output.accept(ModBlocks.STOOL_PURPLE.get());
            output.accept(ModBlocks.STOOL_BLUE.get());
            output.accept(ModBlocks.STOOL_BROWN.get());
            output.accept(ModBlocks.STOOL_GREEN.get());
            output.accept(ModBlocks.STOOL_RED.get());
            output.accept(ModBlocks.STOOL_BLACK.get());
            output.accept(ModBlocks.LAMP_WHITE.get());
            output.accept(ModBlocks.LAMP_ORANGE.get());
            output.accept(ModBlocks.LAMP_MAGENTA.get());
            output.accept(ModBlocks.LAMP_LIGHT_BLUE.get());
            output.accept(ModBlocks.LAMP_YELLOW.get());
            output.accept(ModBlocks.LAMP_LIME.get());
            output.accept(ModBlocks.LAMP_PINK.get());
            output.accept(ModBlocks.LAMP_GRAY.get());
            output.accept(ModBlocks.LAMP_LIGHT_GRAY.get());
            output.accept(ModBlocks.LAMP_CYAN.get());
            output.accept(ModBlocks.LAMP_PURPLE.get());
            output.accept(ModBlocks.LAMP_BLUE.get());
            output.accept(ModBlocks.LAMP_BROWN.get());
            output.accept(ModBlocks.LAMP_GREEN.get());
            output.accept(ModBlocks.LAMP_RED.get());
            output.accept(ModBlocks.LAMP_BLACK.get());
            output.accept(ModBlocks.CEILING_FAN_OAK_LIGHT.get());
            output.accept(ModBlocks.CEILING_FAN_SPRUCE_LIGHT.get());
            output.accept(ModBlocks.CEILING_FAN_BIRCH_LIGHT.get());
            output.accept(ModBlocks.CEILING_FAN_JUNGLE_LIGHT.get());
            output.accept(ModBlocks.CEILING_FAN_ACACIA_LIGHT.get());
            output.accept(ModBlocks.CEILING_FAN_DARK_OAK_LIGHT.get());
            output.accept(ModBlocks.CEILING_FAN_MANGROVE_LIGHT.get());
            output.accept(ModBlocks.CEILING_FAN_CHERRY_LIGHT.get());
            output.accept(ModBlocks.CEILING_FAN_CRIMSON_LIGHT.get());
            output.accept(ModBlocks.CEILING_FAN_WARPED_LIGHT.get());
            output.accept(ModBlocks.CEILING_FAN_OAK_DARK.get());
            output.accept(ModBlocks.CEILING_FAN_SPRUCE_DARK.get());
            output.accept(ModBlocks.CEILING_FAN_BIRCH_DARK.get());
            output.accept(ModBlocks.CEILING_FAN_JUNGLE_DARK.get());
            output.accept(ModBlocks.CEILING_FAN_ACACIA_DARK.get());
            output.accept(ModBlocks.CEILING_FAN_DARK_OAK_DARK.get());
            output.accept(ModBlocks.CEILING_FAN_MANGROVE_DARK.get());
            output.accept(ModBlocks.CEILING_FAN_CHERRY_DARK.get());
            output.accept(ModBlocks.CEILING_FAN_CRIMSON_DARK.get());
            output.accept(ModBlocks.CEILING_FAN_WARPED_DARK.get());
            output.accept(ModBlocks.STORAGE_CABINET_OAK.get());
            output.accept(ModBlocks.STORAGE_CABINET_SPRUCE.get());
            output.accept(ModBlocks.STORAGE_CABINET_BIRCH.get());
            output.accept(ModBlocks.STORAGE_CABINET_JUNGLE.get());
            output.accept(ModBlocks.STORAGE_CABINET_ACACIA.get());
            output.accept(ModBlocks.STORAGE_CABINET_DARK_OAK.get());
            output.accept(ModBlocks.STORAGE_CABINET_MANGROVE.get());
            output.accept(ModBlocks.STORAGE_CABINET_CHERRY.get());
            output.accept(ModBlocks.STORAGE_CABINET_CRIMSON.get());
            output.accept(ModBlocks.STORAGE_CABINET_WARPED.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_OAK.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_SPRUCE.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_BIRCH.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_JUNGLE.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_ACACIA.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_DARK_OAK.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_MANGROVE.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_CHERRY.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_CRIMSON.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_WARPED.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_OAK.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_SPRUCE.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_BIRCH.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_JUNGLE.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_ACACIA.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_DARK_OAK.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_MANGROVE.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_CHERRY.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_CRIMSON.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_WARPED.get());
            output.accept(ModBlocks.KITCHEN_SINK_OAK.get());
            output.accept(ModBlocks.KITCHEN_SINK_SPRUCE.get());
            output.accept(ModBlocks.KITCHEN_SINK_BIRCH.get());
            output.accept(ModBlocks.KITCHEN_SINK_JUNGLE.get());
            output.accept(ModBlocks.KITCHEN_SINK_ACACIA.get());
            output.accept(ModBlocks.KITCHEN_SINK_DARK_OAK.get());
            output.accept(ModBlocks.KITCHEN_SINK_MANGROVE.get());
            output.accept(ModBlocks.KITCHEN_SINK_CHERRY.get());
            output.accept(ModBlocks.KITCHEN_SINK_CRIMSON.get());
            output.accept(ModBlocks.KITCHEN_SINK_WARPED.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_OAK.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_SPRUCE.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_BIRCH.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_JUNGLE.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_ACACIA.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_DARK_OAK.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_MANGROVE.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_CHERRY.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_CRIMSON.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_WARPED.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_WHITE.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_ORANGE.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_MAGENTA.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_LIGHT_BLUE.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_YELLOW.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_LIME.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_PINK.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_GRAY.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_LIGHT_GRAY.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_CYAN.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_PURPLE.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_BLUE.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_BROWN.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_GREEN.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_RED.get());
            output.accept(ModBlocks.KITCHEN_CABINETRY_BLACK.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_WHITE.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_ORANGE.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_MAGENTA.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_LIGHT_BLUE.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_YELLOW.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_LIME.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_PINK.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_GRAY.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_LIGHT_GRAY.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_CYAN.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_PURPLE.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_BLUE.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_BROWN.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_GREEN.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_RED.get());
            output.accept(ModBlocks.KITCHEN_DRAWER_BLACK.get());
            output.accept(ModBlocks.KITCHEN_SINK_WHITE.get());
            output.accept(ModBlocks.KITCHEN_SINK_ORANGE.get());
            output.accept(ModBlocks.KITCHEN_SINK_MAGENTA.get());
            output.accept(ModBlocks.KITCHEN_SINK_LIGHT_BLUE.get());
            output.accept(ModBlocks.KITCHEN_SINK_YELLOW.get());
            output.accept(ModBlocks.KITCHEN_SINK_LIME.get());
            output.accept(ModBlocks.KITCHEN_SINK_PINK.get());
            output.accept(ModBlocks.KITCHEN_SINK_GRAY.get());
            output.accept(ModBlocks.KITCHEN_SINK_LIGHT_GRAY.get());
            output.accept(ModBlocks.KITCHEN_SINK_CYAN.get());
            output.accept(ModBlocks.KITCHEN_SINK_PURPLE.get());
            output.accept(ModBlocks.KITCHEN_SINK_BLUE.get());
            output.accept(ModBlocks.KITCHEN_SINK_BROWN.get());
            output.accept(ModBlocks.KITCHEN_SINK_GREEN.get());
            output.accept(ModBlocks.KITCHEN_SINK_RED.get());
            output.accept(ModBlocks.KITCHEN_SINK_BLACK.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_WHITE.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_ORANGE.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_MAGENTA.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_LIGHT_BLUE.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_YELLOW.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_LIME.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_PINK.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_GRAY.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_LIGHT_GRAY.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_CYAN.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_PURPLE.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_BLUE.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_BROWN.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_GREEN.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_RED.get());
            output.accept(ModBlocks.KITCHEN_STORAGE_CABINET_BLACK.get());
            output.accept(ModBlocks.FRIDGE_LIGHT.get());
            output.accept(ModBlocks.FRIDGE_DARK.get());
            output.accept(ModBlocks.TOASTER_LIGHT.get());
            output.accept(ModBlocks.TOASTER_DARK.get());
            output.accept(ModBlocks.MICROWAVE_LIGHT.get());
            output.accept(ModBlocks.MICROWAVE_DARK.get());
            output.accept(ModBlocks.STOVE_LIGHT.get());
            output.accept(ModBlocks.STOVE_DARK.get());
            output.accept(ModBlocks.RANGE_HOOD_LIGHT.get());
            output.accept(ModBlocks.RANGE_HOOD_DARK.get());
            output.accept(ModBlocks.FRYING_PAN.get());
            output.accept(ModBlocks.RECYCLE_BIN.get());
            output.accept(ModBlocks.CUTTING_BOARD_OAK.get());
            output.accept(ModBlocks.CUTTING_BOARD_SPRUCE.get());
            output.accept(ModBlocks.CUTTING_BOARD_BIRCH.get());
            output.accept(ModBlocks.CUTTING_BOARD_JUNGLE.get());
            output.accept(ModBlocks.CUTTING_BOARD_ACACIA.get());
            output.accept(ModBlocks.CUTTING_BOARD_DARK_OAK.get());
            output.accept(ModBlocks.CUTTING_BOARD_MANGROVE.get());
            output.accept(ModBlocks.CUTTING_BOARD_CHERRY.get());
            output.accept(ModBlocks.CUTTING_BOARD_CRIMSON.get());
            output.accept(ModBlocks.CUTTING_BOARD_WARPED.get());
            output.accept(ModBlocks.PLATE.get());
            output.accept(ModBlocks.STORAGE_JAR_OAK.get());
            output.accept(ModBlocks.STORAGE_JAR_SPRUCE.get());
            output.accept(ModBlocks.STORAGE_JAR_BIRCH.get());
            output.accept(ModBlocks.STORAGE_JAR_JUNGLE.get());
            output.accept(ModBlocks.STORAGE_JAR_ACACIA.get());
            output.accept(ModBlocks.STORAGE_JAR_DARK_OAK.get());
            output.accept(ModBlocks.STORAGE_JAR_MANGROVE.get());
            output.accept(ModBlocks.STORAGE_JAR_CHERRY.get());
            output.accept(ModBlocks.STORAGE_JAR_CRIMSON.get());
            output.accept(ModBlocks.STORAGE_JAR_WARPED.get());
            output.accept(ModItems.SPATULA.get());
            output.accept(ModItems.KNIFE.get());
            output.accept(ModBlocks.CRATE_OAK.get());
            output.accept(ModBlocks.CRATE_SPRUCE.get());
            output.accept(ModBlocks.CRATE_BIRCH.get());
            output.accept(ModBlocks.CRATE_JUNGLE.get());
            output.accept(ModBlocks.CRATE_ACACIA.get());
            output.accept(ModBlocks.CRATE_DARK_OAK.get());
            output.accept(ModBlocks.CRATE_MANGROVE.get());
            output.accept(ModBlocks.CRATE_CHERRY.get());
            output.accept(ModBlocks.CRATE_CRIMSON.get());
            output.accept(ModBlocks.CRATE_WARPED.get());
            output.accept(ModBlocks.GRILL_WHITE.get());
            output.accept(ModBlocks.GRILL_ORANGE.get());
            output.accept(ModBlocks.GRILL_MAGENTA.get());
            output.accept(ModBlocks.GRILL_LIGHT_BLUE.get());
            output.accept(ModBlocks.GRILL_YELLOW.get());
            output.accept(ModBlocks.GRILL_LIME.get());
            output.accept(ModBlocks.GRILL_PINK.get());
            output.accept(ModBlocks.GRILL_GRAY.get());
            output.accept(ModBlocks.GRILL_LIGHT_GRAY.get());
            output.accept(ModBlocks.GRILL_CYAN.get());
            output.accept(ModBlocks.GRILL_PURPLE.get());
            output.accept(ModBlocks.GRILL_BLUE.get());
            output.accept(ModBlocks.GRILL_BROWN.get());
            output.accept(ModBlocks.GRILL_GREEN.get());
            output.accept(ModBlocks.GRILL_RED.get());
            output.accept(ModBlocks.GRILL_BLACK.get());
            output.accept(ModBlocks.COOLER_WHITE.get());
            output.accept(ModBlocks.COOLER_ORANGE.get());
            output.accept(ModBlocks.COOLER_MAGENTA.get());
            output.accept(ModBlocks.COOLER_LIGHT_BLUE.get());
            output.accept(ModBlocks.COOLER_YELLOW.get());
            output.accept(ModBlocks.COOLER_LIME.get());
            output.accept(ModBlocks.COOLER_PINK.get());
            output.accept(ModBlocks.COOLER_GRAY.get());
            output.accept(ModBlocks.COOLER_LIGHT_GRAY.get());
            output.accept(ModBlocks.COOLER_CYAN.get());
            output.accept(ModBlocks.COOLER_PURPLE.get());
            output.accept(ModBlocks.COOLER_BLUE.get());
            output.accept(ModBlocks.COOLER_BROWN.get());
            output.accept(ModBlocks.COOLER_GREEN.get());
            output.accept(ModBlocks.COOLER_RED.get());
            output.accept(ModBlocks.COOLER_BLACK.get());
            output.accept(ModBlocks.MAIL_BOX_OAK.get());
            output.accept(ModBlocks.MAIL_BOX_SPRUCE.get());
            output.accept(ModBlocks.MAIL_BOX_BIRCH.get());
            output.accept(ModBlocks.MAIL_BOX_JUNGLE.get());
            output.accept(ModBlocks.MAIL_BOX_ACACIA.get());
            output.accept(ModBlocks.MAIL_BOX_DARK_OAK.get());
            output.accept(ModBlocks.MAIL_BOX_MANGROVE.get());
            output.accept(ModBlocks.MAIL_BOX_CHERRY.get());
            output.accept(ModBlocks.MAIL_BOX_CRIMSON.get());
            output.accept(ModBlocks.MAIL_BOX_WARPED.get());
            output.accept(ModBlocks.POST_BOX.get());
            output.accept(ModBlocks.TRAMPOLINE_WHITE.get());
            output.accept(ModBlocks.TRAMPOLINE_ORANGE.get());
            output.accept(ModBlocks.TRAMPOLINE_MAGENTA.get());
            output.accept(ModBlocks.TRAMPOLINE_LIGHT_BLUE.get());
            output.accept(ModBlocks.TRAMPOLINE_YELLOW.get());
            output.accept(ModBlocks.TRAMPOLINE_LIME.get());
            output.accept(ModBlocks.TRAMPOLINE_PINK.get());
            output.accept(ModBlocks.TRAMPOLINE_GRAY.get());
            output.accept(ModBlocks.TRAMPOLINE_LIGHT_GRAY.get());
            output.accept(ModBlocks.TRAMPOLINE_CYAN.get());
            output.accept(ModBlocks.TRAMPOLINE_PURPLE.get());
            output.accept(ModBlocks.TRAMPOLINE_BLUE.get());
            output.accept(ModBlocks.TRAMPOLINE_BROWN.get());
            output.accept(ModBlocks.TRAMPOLINE_GREEN.get());
            output.accept(ModBlocks.TRAMPOLINE_RED.get());
            output.accept(ModBlocks.TRAMPOLINE_BLACK.get());
            output.accept(ModBlocks.HEDGE_OAK.get());
            output.accept(ModBlocks.HEDGE_SPRUCE.get());
            output.accept(ModBlocks.HEDGE_BIRCH.get());
            output.accept(ModBlocks.HEDGE_JUNGLE.get());
            output.accept(ModBlocks.HEDGE_ACACIA.get());
            output.accept(ModBlocks.HEDGE_DARK_OAK.get());
            output.accept(ModBlocks.HEDGE_MANGROVE.get());
            output.accept(ModBlocks.HEDGE_CHERRY.get());
            output.accept(ModBlocks.HEDGE_AZALEA.get());
            output.accept(ModBlocks.STEPPING_STONES_STONE.get());
            output.accept(ModBlocks.STEPPING_STONES_GRANITE.get());
            output.accept(ModBlocks.STEPPING_STONES_DIORITE.get());
            output.accept(ModBlocks.STEPPING_STONES_ANDESITE.get());
            output.accept(ModBlocks.STEPPING_STONES_DEEPSLATE.get());
            output.accept(ModBlocks.LATTICE_FENCE_OAK.get());
            output.accept(ModBlocks.LATTICE_FENCE_SPRUCE.get());
            output.accept(ModBlocks.LATTICE_FENCE_BIRCH.get());
            output.accept(ModBlocks.LATTICE_FENCE_JUNGLE.get());
            output.accept(ModBlocks.LATTICE_FENCE_ACACIA.get());
            output.accept(ModBlocks.LATTICE_FENCE_DARK_OAK.get());
            output.accept(ModBlocks.LATTICE_FENCE_MANGROVE.get());
            output.accept(ModBlocks.LATTICE_FENCE_CHERRY.get());
            output.accept(ModBlocks.LATTICE_FENCE_CRIMSON.get());
            output.accept(ModBlocks.LATTICE_FENCE_WARPED.get());
            output.accept(ModBlocks.LATTICE_FENCE_GATE_OAK.get());
            output.accept(ModBlocks.LATTICE_FENCE_GATE_SPRUCE.get());
            output.accept(ModBlocks.LATTICE_FENCE_GATE_BIRCH.get());
            output.accept(ModBlocks.LATTICE_FENCE_GATE_JUNGLE.get());
            output.accept(ModBlocks.LATTICE_FENCE_GATE_ACACIA.get());
            output.accept(ModBlocks.LATTICE_FENCE_GATE_DARK_OAK.get());
            output.accept(ModBlocks.LATTICE_FENCE_GATE_MANGROVE.get());
            output.accept(ModBlocks.LATTICE_FENCE_GATE_CHERRY.get());
            output.accept(ModBlocks.LATTICE_FENCE_GATE_CRIMSON.get());
            output.accept(ModBlocks.LATTICE_FENCE_GATE_WARPED.get());
            output.accept(ModBlocks.DOOR_MAT.get());
            output.accept(ModBlocks.TOILET_OAK.get());
            output.accept(ModBlocks.TOILET_SPRUCE.get());
            output.accept(ModBlocks.TOILET_BIRCH.get());
            output.accept(ModBlocks.TOILET_JUNGLE.get());
            output.accept(ModBlocks.TOILET_ACACIA.get());
            output.accept(ModBlocks.TOILET_DARK_OAK.get());
            output.accept(ModBlocks.TOILET_MANGROVE.get());
            output.accept(ModBlocks.TOILET_CHERRY.get());
            output.accept(ModBlocks.TOILET_CRIMSON.get());
            output.accept(ModBlocks.TOILET_WARPED.get());
            output.accept(ModBlocks.TOILET_WHITE.get());
            output.accept(ModBlocks.TOILET_ORANGE.get());
            output.accept(ModBlocks.TOILET_MAGENTA.get());
            output.accept(ModBlocks.TOILET_LIGHT_BLUE.get());
            output.accept(ModBlocks.TOILET_YELLOW.get());
            output.accept(ModBlocks.TOILET_LIME.get());
            output.accept(ModBlocks.TOILET_PINK.get());
            output.accept(ModBlocks.TOILET_GRAY.get());
            output.accept(ModBlocks.TOILET_LIGHT_GRAY.get());
            output.accept(ModBlocks.TOILET_CYAN.get());
            output.accept(ModBlocks.TOILET_PURPLE.get());
            output.accept(ModBlocks.TOILET_BLUE.get());
            output.accept(ModBlocks.TOILET_BROWN.get());
            output.accept(ModBlocks.TOILET_GREEN.get());
            output.accept(ModBlocks.TOILET_RED.get());
            output.accept(ModBlocks.TOILET_BLACK.get());
            output.accept(ModBlocks.BASIN_OAK.get());
            output.accept(ModBlocks.BASIN_SPRUCE.get());
            output.accept(ModBlocks.BASIN_BIRCH.get());
            output.accept(ModBlocks.BASIN_JUNGLE.get());
            output.accept(ModBlocks.BASIN_ACACIA.get());
            output.accept(ModBlocks.BASIN_DARK_OAK.get());
            output.accept(ModBlocks.BASIN_MANGROVE.get());
            output.accept(ModBlocks.BASIN_CHERRY.get());
            output.accept(ModBlocks.BASIN_CRIMSON.get());
            output.accept(ModBlocks.BASIN_WARPED.get());
            output.accept(ModBlocks.BASIN_WHITE.get());
            output.accept(ModBlocks.BASIN_ORANGE.get());
            output.accept(ModBlocks.BASIN_MAGENTA.get());
            output.accept(ModBlocks.BASIN_LIGHT_BLUE.get());
            output.accept(ModBlocks.BASIN_YELLOW.get());
            output.accept(ModBlocks.BASIN_LIME.get());
            output.accept(ModBlocks.BASIN_PINK.get());
            output.accept(ModBlocks.BASIN_GRAY.get());
            output.accept(ModBlocks.BASIN_LIGHT_GRAY.get());
            output.accept(ModBlocks.BASIN_CYAN.get());
            output.accept(ModBlocks.BASIN_PURPLE.get());
            output.accept(ModBlocks.BASIN_BLUE.get());
            output.accept(ModBlocks.BASIN_BROWN.get());
            output.accept(ModBlocks.BASIN_GREEN.get());
            output.accept(ModBlocks.BASIN_RED.get());
            output.accept(ModBlocks.BASIN_BLACK.get());
            output.accept(ModBlocks.BATH_OAK.get());
            output.accept(ModBlocks.BATH_SPRUCE.get());
            output.accept(ModBlocks.BATH_BIRCH.get());
            output.accept(ModBlocks.BATH_JUNGLE.get());
            output.accept(ModBlocks.BATH_ACACIA.get());
            output.accept(ModBlocks.BATH_DARK_OAK.get());
            output.accept(ModBlocks.BATH_MANGROVE.get());
            output.accept(ModBlocks.BATH_CHERRY.get());
            output.accept(ModBlocks.BATH_CRIMSON.get());
            output.accept(ModBlocks.BATH_WARPED.get());
            output.accept(ModBlocks.BATH_WHITE.get());
            output.accept(ModBlocks.BATH_ORANGE.get());
            output.accept(ModBlocks.BATH_MAGENTA.get());
            output.accept(ModBlocks.BATH_LIGHT_BLUE.get());
            output.accept(ModBlocks.BATH_YELLOW.get());
            output.accept(ModBlocks.BATH_LIME.get());
            output.accept(ModBlocks.BATH_PINK.get());
            output.accept(ModBlocks.BATH_GRAY.get());
            output.accept(ModBlocks.BATH_LIGHT_GRAY.get());
            output.accept(ModBlocks.BATH_CYAN.get());
            output.accept(ModBlocks.BATH_PURPLE.get());
            output.accept(ModBlocks.BATH_BLUE.get());
            output.accept(ModBlocks.BATH_BROWN.get());
            output.accept(ModBlocks.BATH_GREEN.get());
            output.accept(ModBlocks.BATH_RED.get());
            output.accept(ModBlocks.BATH_BLACK.get());
            output.accept(ModItems.WRENCH.get());
            output.accept(ModBlocks.ELECTRICITY_GENERATOR_LIGHT.get());
            output.accept(ModBlocks.ELECTRICITY_GENERATOR_DARK.get());
            output.accept(ModBlocks.CEILING_LIGHT_LIGHT.get());
            output.accept(ModBlocks.CEILING_LIGHT_DARK.get());
            output.accept(ModBlocks.LIGHTSWITCH_LIGHT.get());
            output.accept(ModBlocks.LIGHTSWITCH_DARK.get());
            output.accept(ModBlocks.DOORBELL.get());
            output.accept(ModBlocks.TELEVISION.get());
            output.accept(ModItems.TELEVISION_REMOTE.get());
            output.accept(ModBlocks.COMPUTER.get());
            output.accept(ModBlocks.WORKBENCH.get());
            output.accept(ModItems.SEA_SALT.get());
            output.accept(ModItems.WHEAT_FLOUR.get());
            output.accept(ModItems.DOUGH.get());
            output.accept(ModItems.CHEESE.get());
            output.accept(ModItems.SWEET_BERRY_JAM.get());
            output.accept(ModItems.GLOW_BERRY_JAM.get());
            output.accept(ModItems.BREAD_SLICE.get());
            output.accept(ModItems.TOAST.get());
            output.accept(ModItems.CHEESE_SANDWICH.get());
            output.accept(ModItems.CHEESE_TOASTIE.get());
            output.accept(ModItems.SWEET_BERRY_JAM_TOAST.get());
            output.accept(ModItems.GLOW_BERRY_JAM_TOAST.get());
            output.accept(ModItems.RAW_VEGETABLE_PIZZA.get());
            output.accept(ModItems.COOKED_VEGETABLE_PIZZA.get());
            output.accept(ModItems.VEGETABLE_PIZZA_SLICE.get());
            output.accept(ModItems.RAW_MEATLOVERS_PIZZA.get());
            output.accept(ModItems.COOKED_MEATLOVERS_PIZZA.get());
            output.accept(ModItems.MEATLOVERS_PIZZA_SLICE.get());
        });
    });
}
