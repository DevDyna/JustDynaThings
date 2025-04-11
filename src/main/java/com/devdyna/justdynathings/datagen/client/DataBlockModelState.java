package com.devdyna.justdynathings.datagen.client;

import com.devdyna.justdynathings.Main;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DataBlockModelState extends BlockStateProvider {

    public DataBlockModelState(PackOutput o, ExistingFileHelper f) {
        super(o, Main.ID, f);
    }

    @Override
    protected void registerStatesAndModels() {

        // simpleBlock(Blocks.BK.get(),
        // models().getExistingFile(DataGenUtil.getResource("block/stone")));

    }

}
