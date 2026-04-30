package com.devdyna.justdynathings.datagen.server;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.init.types.zBiomeTags;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.neoforged.neoforge.common.Tags;

public class DataBiomeTag extends BiomeTagsProvider{

    public DataBiomeTag(PackOutput output, CompletableFuture<Provider> lookupProvider) {
        super(output, lookupProvider,MODULE_ID);
    }

    @Override
     protected void addTags(Provider p) {

                tag(zBiomeTags.FERRICORE_SOLAR_PANEL_BIOME_LIST)
                                .addTag(Tags.Biomes.IS_OVERWORLD).addTag(Tags.Biomes.IS_VOID);

                tag(zBiomeTags.BLAZEGOLD_SOLAR_PANEL_BIOME_LIST)
                                .addTag(Tags.Biomes.IS_NETHER);
                // noOp
                tag(zBiomeTags.CELESTIGEM_SOLAR_PANEL_BIOME_LIST);
                // noOp
                tag(zBiomeTags.ECLIPSEALLOY_SOLAR_PANEL_BIOME_LIST);
        }
    
}
