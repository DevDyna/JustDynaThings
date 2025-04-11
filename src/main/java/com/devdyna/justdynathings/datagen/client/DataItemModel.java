package com.devdyna.justdynathings.datagen.client;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.types.Blocks;
import com.devdyna.justdynathings.registry.types.Items;
import com.devdyna.justdynathings.utils.DataGenUtil;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DataItemModel extends ItemModelProvider {

    public DataItemModel(PackOutput o, ExistingFileHelper f) {
        super(o, Main.ID, f);
    }

    @Override
    protected void registerModels() {

        Items.zItem.getEntries().forEach(item -> {

            try {
                DataGenUtil.itemModel(item.get(), this);
            } catch (Exception e) {
                System.out.println(e);
            }

        });

        DataGenUtil.itemBlockwithParent(Blocks.BLAZING_ANVIL.get(), this,
                "justdynathings:block/blazing_anvil");

        DataGenUtil.itemBlockwithParent(Blocks.FERRITECORE_CLOCK.get(), this,
                "block/cube_all", "all", "justdynathings:block/clock/on");

        DataGenUtil.itemBlockwithParent(Blocks.CREATIVE_GOO.get(), this,
                "justdynathings:block/goo/creative/dead");

        DataGenUtil.itemBlockwithParent(Blocks.ENERGIZED_GOO.get(), this,
                "justdynathings:block/goo/energized/dead");

        DataGenUtil.itemBlockwithParent(Blocks.PHASEBOX.get(), this,
                "justdynathings:block/phase_box/true");

        DataGenUtil.itemBlockwithParent(Blocks.RAW_CHAOTIC.get(), this,
                "justdynathings:block/raw_chaotic_ore");

        DataGenUtil.itemBlockwithParent(Blocks.RAW_COPRINIUM.get(), this,
                "justdynathings:block/raw_coprinium_ore");

        DataGenUtil.itemBlockwithParent(Blocks.RAW_REDSTONIC.get(), this,
                "justdynathings:block/raw_redstonic_ore");

        DataGenUtil.itemBlockwithParent(Blocks.REFORGER.get(), this,
                "justdynathings:block/reforger/off");

        DataGenUtil.itemBlockwithParent(Blocks.REVITALIZER.get(), this,
                "justdynathings:block/revitalizer/x/off");

    }

}
