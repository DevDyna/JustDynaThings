package com.devdyna.justdynathings.datagen.client;

import static com.devdyna.justdynathings.Main.ID;

import java.util.Set;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zItems;
import com.devdyna.justdynathings.utils.DataGenUtil;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.loaders.DynamicFluidContainerModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.internal.versions.neoforge.NeoForgeVersion;
import net.neoforged.neoforge.registries.DeferredHolder;

public class DataItemModel extends ItemModelProvider {

        public DataItemModel(PackOutput o, ExistingFileHelper f) {
                super(o, Main.ID, f);
        }

        // private Set<DeferredHolder<Item, ?>> blacklist = Set.of(zItems.REDSTONIC_GEM);

        @Override
        protected void registerModels() {

                zItems.zItem.getEntries()//.stream().filter(item -> !blacklist.contains(item))
                                .forEach(item -> DataGenUtil.itemModel(item.get(), this));

                DataGenUtil.itemBlockwithParent(zBlocks.BLAZING_ANVIL.get(), this,
                                ID + ":block/blazing_anvil");

                DataGenUtil.itemBlockwithParent(zBlocks.FERRITECORE_CLOCK.get(), this,
                                "block/cube_all", "all", ID + ":block/ferritecore_clock/on");

                DataGenUtil.itemBlockwithParent(zBlocks.CREATIVE_GOO.get(), this,
                                ID + ":block/goo/creative/dead");

                DataGenUtil.itemBlockwithParent(zBlocks.ENERGIZED_GOO.get(), this,
                                ID + ":block/goo/energized/dead");

                DataGenUtil.itemBlockwithParent(zBlocks.PHASEBOX.get(), this,
                                ID + ":block/phase_box/true");

                // DataGenUtil.itemBlockwithParent(zBlocks.RAW_CHAOTIC.get(), this,
                //                 ID + ":block/raw_chaotic_ore");

                // DataGenUtil.itemBlockwithParent(zBlocks.RAW_COPRINIUM.get(), this,
                //                 ID + ":block/raw_coprinium_ore");

                // DataGenUtil.itemBlockwithParent(zBlocks.RAW_REDSTONIC.get(), this,
                //                 ID + ":block/raw_redstonic_ore");

                DataGenUtil.itemBlockwithParent(zBlocks.REFORGER.get(), this,
                                ID + ":block/reforger/off");

                DataGenUtil.itemBlockwithParent(zBlocks.REVITALIZER.get(), this,
                                ID + ":block/revitalizer/x/off");

                // zItems.zBucketItem.getEntries().forEach(b -> withExistingParent(b.getId().getPath(),
                //                 ResourceLocation.fromNamespaceAndPath(NeoForgeVersion.MOD_ID, "item/bucket"))
                //                 .customLoader(DynamicFluidContainerModelBuilder::begin)
                //                 .fluid(((BucketItem) b.get()).content));

                // NYC
                // withExistingParent(Items.REDSTONIC_GEM.getId().getPath(),
                // ResourceLocation.fromNamespaceAndPath("minecraft", "item/generated"))
                // .customLoader(ItemLayerModelBuilder::begin)
                // .color(0, 0xFF4C3F7C).renderType("justdynathings:item/shard", 0);

        }

}
