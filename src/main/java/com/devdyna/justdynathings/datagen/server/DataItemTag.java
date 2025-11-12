package com.devdyna.justdynathings.datagen.server;

import static com.devdyna.justdynathings.Main.ID;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.registry.types.zBlockTags;
import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.registry.types.zItems;
import com.direwolf20.justdirethings.datagen.JustDireItemTags;
import com.direwolf20.justdirethings.setup.Registration;
import com.glodblock.github.extendedae.common.EAESingletons;

import appeng.core.definitions.AEBlocks;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

@SuppressWarnings("null")

public class DataItemTag extends ItemTagsProvider {

        public DataItemTag(PackOutput o, CompletableFuture<Provider> p, CompletableFuture<TagLookup<Block>> b,
                        ExistingFileHelper f) {
                super(o, p, b, ID, f);
        }

        @Override
        protected void addTags(Provider p) {

                tag(zItemTags.AMETHYST_BLOCKS)
                .add(Items.AMETHYST_BLOCK, Items.BUDDING_AMETHYST);

                copy(zBlockTags.T1_GOO_TYPE, zItemTags.T1_GOO_TYPE);
                copy(zBlockTags.T2_GOO_TYPE, zItemTags.T2_GOO_TYPE);
                copy(zBlockTags.T2_SPREAD, zItemTags.T2_SPREAD);
                copy(zBlockTags.T3_GOO_TYPE, zItemTags.T3_GOO_TYPE);
                copy(zBlockTags.T3_SPREAD, zItemTags.T3_SPREAD);
                copy(zBlockTags.T4_GOO_TYPE, zItemTags.T4_GOO_TYPE);
                copy(zBlockTags.T4_SPREAD, zItemTags.T4_SPREAD);

                tag(zItemTags.COPPER_BULBS).add(
                                Items.COPPER_BULB,
                                Items.EXPOSED_COPPER_BULB,
                                Items.WEATHERED_COPPER_BULB,
                                Items.OXIDIZED_COPPER_BULB,
                                Items.WAXED_COPPER_BULB,
                                Items.WAXED_EXPOSED_COPPER_BULB,
                                Items.WAXED_WEATHERED_COPPER_BULB,
                                Items.WAXED_OXIDIZED_COPPER_BULB);

                tag(zItemTags.UNIVERSAL_WRENCH)
                                .addOptionalTag(Tags.Items.TOOLS_WRENCH)
                                .addOptionalTag(JustDireItemTags.WRENCHES);

                tag(zItemTags.CREATIVE_GOO_WRENCHES)
                                .addTag(zItemTags.UNIVERSAL_WRENCH);

                tag(zItemTags.BLAZEGOLD_ANVIL_DENY)
                                .add(Items.MACE);

                tag(zItemTags.CELESTIGEM_DENY)
                                .add(Items.MACE);

                tag(zItemTags.FERRICORE_ANVIL_DENY)
                                .add(Items.MACE);

                tag(zItemTags.ECLIPSE_ALLOY_ANVIL_DENY)
                                .add(Items.MACE);

                tag(zItemTags.AE2_COMPAT).add(
                                AEBlocks.FLAWLESS_BUDDING_QUARTZ.asItem(),
                                AEBlocks.FLAWED_BUDDING_QUARTZ.asItem(),
                                AEBlocks.CHIPPED_BUDDING_QUARTZ.asItem(),
                                AEBlocks.DAMAGED_BUDDING_QUARTZ.asItem(),
                                AEBlocks.QUARTZ_BLOCK.asItem());

                tag(zItemTags.EXT_COMPAT).add(
                                EAESingletons.ENTRO_BLOCK.asItem(),
                                EAESingletons.HALF_ENTROIZED_FLUIX_BUDDING.asItem(),
                                EAESingletons.HARDLY_ENTROIZED_FLUIX_BUDDING.asItem(),
                                EAESingletons.MOSTLY_ENTROIZED_FLUIX_BUDDING.asItem(),
                                EAESingletons.FULLY_ENTROIZED_FLUIX_BUDDING.asItem());

                // tag(zItemTags.PHA_COMPAT).add(
                                // PNBlocks.INSTANCE.getBUDDING_PHASORITE_BLOCK().asItem(),
                                // PNBlocks.INSTANCE.getPHASORITE_BLOCK().asItem());

                tag(zItemTags.TIME_BUDDING).add(
                                Registration.TimeCrystalBlock_ITEM.get(),
                                Registration.TimeCrystalBuddingBlock_ITEM.get());

                tag(zItemTags.INTERACTIVE)
                                .add(
                                                Registration.FerricoreWrench.get(),
                                                Registration.MachineSettingsCopier.get())
                                .addTag(Tags.Items.BUCKETS);

                tag(zItemTags.TIME_WANDS).add(zItems.ADVANCED_TIME_WAND.get(), Registration.TimeWand.get());

        }

}