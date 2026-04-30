package com.devdyna.justdynathings.datagen.server;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.init.types.zItemTags;
import com.devdyna.justdynathings.init.types.zItems;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.direwolf20.justdirethings.util.ModTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

public class DataItemTag extends ItemTagsProvider {

    public DataItemTag(PackOutput o, CompletableFuture<HolderLookup.Provider> p,
            CompletableFuture<TagLookup<Block>> b) {
        super(o, p, MODULE_ID);
    }

    @Override
    protected void addTags(Provider p) {

        tag(zItemTags.AMETHYST_BLOCKS)
                .add(Items.AMETHYST_BLOCK, Items.BUDDING_AMETHYST);

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
                .addOptionalTag(ModTags.Items.WRENCHES);

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

        tag(zItemTags.TIME_BUDDING).add(
                JDTRegistration.TimeCrystalBlock_ITEM.get(),
                JDTRegistration.TimeCrystalBuddingBlock_ITEM.get());

        tag(zItemTags.INTERACTIVE)
                .add(
                        JDTRegistration.FerricoreWrench.get(),
                        JDTRegistration.MachineSettingsCopier.get())
                .addTag(Tags.Items.BUCKETS);

        tag(zItemTags.TIME_WANDS).add(zItems.ADVANCED_TIME_WAND.get(), JDTRegistration.TimeWand.get());
    }

}
