package com.devdyna.justdynathings.datagen.server;

import static com.devdyna.justdynathings.Main.ID;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.registry.types.zEntityTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

@SuppressWarnings({ "unchecked", "null" })
public class DataEntityTag extends EntityTypeTagsProvider {

        public DataEntityTag(PackOutput o, CompletableFuture<Provider> p, CompletableFuture<TagLookup<Block>> b,
                        ExistingFileHelper f) {
                super(o, p, ID, f);
        }

        @Override
        protected void addTags(Provider p) {

                tag(zEntityTags.LIGHT_WAND_GLOWING_DENY).addTags(
                                Tags.EntityTypes.BOSSES, Tags.EntityTypes.BOATS,
                                Tags.EntityTypes.CAPTURING_NOT_SUPPORTED, Tags.EntityTypes.MINECARTS,
                                Tags.EntityTypes.TELEPORTING_NOT_SUPPORTED);

        }

}