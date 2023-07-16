package com.mrcrayfish.furniture.refurbished.data;

import com.mrcrayfish.framework.Registration;
import com.mrcrayfish.furniture.refurbished.Constants;
import com.mrcrayfish.furniture.refurbished.data.model.PreparedBlockState;
import com.mrcrayfish.furniture.refurbished.data.model.ModelTemplate;
import com.mrcrayfish.furniture.refurbished.data.model.PreparedStateModel;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Author: MrCrayfish
 */
public class FurnitureModelProvider extends BlockStateProvider
{
    public static final ExistingFileHelper.ResourceType TEXTURE = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");
    public static final ExistingFileHelper.ResourceType MODEL = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".json", "models");

    public FurnitureModelProvider(PackOutput output, ExistingFileHelper helper)
    {
        super(output, Constants.MOD_ID, helper);
        this.registerExistingResources(helper);
    }

    private void registerExistingResources(ExistingFileHelper helper)
    {
        // Registers existing parent models since they aren't generated
        ModelTemplate.all().forEach(model -> helper.trackGenerated(model, MODEL));

        // Registers a default texture for all blocks in the mod
        Registration.get(Registries.BLOCK).stream().filter(entry -> entry.getId().getNamespace().equals(Constants.MOD_ID)).forEach(entry -> {
            helper.trackGenerated(this.blockTexture((Block) entry.get()), TEXTURE);
        });
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected void registerStatesAndModels()
    {
        new CommonModelProvider(builder -> {
            Block block = builder.getBlock();

            // Generates the blockstate and block models
            VariantBlockStateBuilder blockStateBuilder = this.getVariantBuilder(block);
            builder.getVariants().forEach(variant -> {
                VariantBlockStateBuilder.PartialBlockstate state = blockStateBuilder.partialState();
                for(Map.Entry<Property, Comparable> entry : variant.getValueMap().entrySet()) {
                    state = state.with(entry.getKey(), entry.getValue());
                }
                PreparedStateModel preparedModel = Objects.requireNonNull(variant.getPreparedModel());
                BlockModelBuilder modelBuilder = this.models().withExistingParent(preparedModel.getName(), preparedModel.getModel());
                TextureMapping textures = preparedModel.getTextures();
                for(TextureSlot slot : preparedModel.getSlots()) {
                    modelBuilder.texture(slot.getId(), textures.get(slot));
                }
                state.setModels(new ConfiguredModel(modelBuilder));
            });

            // Generates an item model if the block has an item and the state builder marked a variant for the item model
            Optional.ofNullable(Item.BY_BLOCK.get(block)).ifPresent(item -> {
                Optional.ofNullable(builder.getVariantForItem()).map(PreparedBlockState.Entry::getPreparedModel).ifPresent(definition -> {
                    ResourceLocation itemName = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
                    ResourceLocation model = builder.getVariantForItem().getPreparedModel().getModel();
                    this.itemModels().getBuilder(itemName.toString()).parent(new ModelFile.UncheckedModelFile(model));
                });
            });
        }).run();
    }
}