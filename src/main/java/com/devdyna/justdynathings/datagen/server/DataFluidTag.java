package com.devdyna.justdynathings.datagen.server;

import static com.devdyna.justdynathings.Main.ID;
import com.devdyna.justdynathings.registry.types.zFluidTags;

import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.Nullable;

import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.FluidTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

@SuppressWarnings("null")
public class DataFluidTag extends FluidTagsProvider {

        public DataFluidTag(PackOutput o, CompletableFuture<Provider> p,
                        @Nullable ExistingFileHelper e) {
                super(o, p, ID, e);
        }

        @Override
        protected void addTags(Provider p) {

                tag(zFluidTags.THERMO_COOLERS).addOptionalTag(FluidTags.WATER);
        }

}