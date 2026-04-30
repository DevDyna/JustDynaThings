package com.devdyna.justdynathings.datagen.server;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.init.types.zEntityTags;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.neoforged.neoforge.common.Tags;

public class DataEntityTag extends EntityTypeTagsProvider{

    public DataEntityTag(PackOutput output, CompletableFuture<Provider> lookupProvider) {
        super(output, lookupProvider,MODULE_ID);
    }

     @Override
        protected void addTags(Provider p) {

                tag(zEntityTags.LIGHT_WAND_GLOWING_DENY).addTags(
                                Tags.EntityTypes.BOSSES, Tags.EntityTypes.BOATS,
                                Tags.EntityTypes.CAPTURING_NOT_SUPPORTED, Tags.EntityTypes.MINECARTS,
                                Tags.EntityTypes.TELEPORTING_NOT_SUPPORTED);

        }
    
}
