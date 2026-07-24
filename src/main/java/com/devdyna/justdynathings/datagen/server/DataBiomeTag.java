package com.devdyna.justdynathings.datagen.server;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import java.util.concurrent.CompletableFuture;

import com.devdyna.cakesticklib.api.utils.x;
import com.devdyna.justdynathings.init.types.zBiomeTags;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.Tags;

public class DataBiomeTag extends BiomeTagsProvider {

    public DataBiomeTag(PackOutput output, CompletableFuture<Provider> lookupProvider) {
        super(output, lookupProvider, MODULE_ID);
    }

    @Override
    protected void addTags(Provider p) {

        tag(zBiomeTags.FERRICORE_SOLAR_PANEL_BIOME_LIST)
                .addTag(Tags.Biomes.IS_OVERWORLD)
                .addTag(Tags.Biomes.IS_VOID)
                .addOptional(ResourceKey.create(Registries.BIOME, x.rl("jamd", "mining")))
                .addOptional(ResourceKey.create(Registries.BIOME, x.rl("javd", "void")));

        tag(zBiomeTags.BLAZEGOLD_SOLAR_PANEL_BIOME_LIST)
                .addTag(Tags.Biomes.IS_NETHER)
                .addOptional(ResourceKey.create(Registries.BIOME, x.rl("jamd", "nether")));
        // noOp
        tag(zBiomeTags.CELESTIGEM_SOLAR_PANEL_BIOME_LIST).add();
        // noOp
        tag(zBiomeTags.ECLIPSEALLOY_SOLAR_PANEL_BIOME_LIST).add();

        tag(zBiomeTags.SOLAR_PANEL_BIOME_IGNORE_DAYTIME)
                .addOptional(ResourceKey.create(Registries.BIOME, x.rl("jamd", "mining")))
                .addOptional(ResourceKey.create(Registries.BIOME, x.rl("jamd", "nether")))
                .addOptional(ResourceKey.create(Registries.BIOME, x.rl("jamd", "end")))
                .addOptional(ResourceKey.create(Registries.BIOME, x.rl("javd", "void")));
    }

}
