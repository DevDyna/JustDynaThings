package com.devdyna.justdynathings.datagen.client;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zItems;
import com.devdyna.justdynathings.utils.DataGenUtil;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DataItemModel extends ItemModelProvider {

        public DataItemModel(PackOutput o, ExistingFileHelper f) {
                super(o, Main.ID, f);
        }

        @Override
        protected void registerModels() {

                zItems.zItem.getEntries()
                                .forEach(item -> DataGenUtil.itemModel(item.get(), this));

                DataGenUtil.itemBlockwithParent(zBlocks.BLAZING_ANVIL.get(), this,
                                ID + ":block/" + DataGenUtil.getName(zBlocks.BLAZING_ANVIL.get()));

                DataGenUtil.itemBlockwithParent(zBlocks.FERRITECORE_CLOCK.get(), this,
                                "block/cube_all", "all",
                                ID + ":block/" + DataGenUtil.getName(zBlocks.FERRITECORE_CLOCK.get()) + "/on");

                DataGenUtil.itemBlockwithParent(zBlocks.PHASEBOX.get(), this,
                                ID + ":block/" + DataGenUtil.getName(zBlocks.PHASEBOX.get()) + "/true");

                DataGenUtil.itemBlockwithParent(zBlocks.REFORGER.get(), this,
                                ID + ":block/" + DataGenUtil.getName(zBlocks.REFORGER.get()) + "/off");

                DataGenUtil.itemBlockwithParent(zBlocks.REVITALIZER.get(), this,
                                ID + ":block/" + DataGenUtil.getName(zBlocks.REVITALIZER.get()) + "/x/off");

                GooItemModel(zBlocks.ENERGIZED_GOO.get());
                GooItemModel(zBlocks.CREATIVE_GOO.get());
                GooItemModel(zBlocks.T1_GOO.get());
                GooItemModel(zBlocks.T2_GOO.get());
                GooItemModel(zBlocks.T3_GOO.get());
                GooItemModel(zBlocks.T4_GOO.get());

        }

        private void GooItemModel(Block b) {
                DataGenUtil.itemBlockwithParent(b, this,
                                ID + ":block/goo/" + DataGenUtil.getName(b) + "/dead");

        }

}
