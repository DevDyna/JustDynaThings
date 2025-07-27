package com.devdyna.justdynathings.datagen.server;

import static com.devdyna.justdynathings.Main.ID;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.devdyna.justdynathings.registry.types.zBiomeTags;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

@SuppressWarnings("null")

public class DataBiomeTag extends BiomeTagsProvider {

        public DataBiomeTag(PackOutput o, CompletableFuture<Provider> p,
                        @Nullable ExistingFileHelper f) {
                super(o, p, ID, f);
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