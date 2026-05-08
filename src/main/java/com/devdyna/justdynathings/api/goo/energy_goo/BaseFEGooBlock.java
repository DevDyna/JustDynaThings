package com.devdyna.justdynathings.api.goo.energy_goo;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.api.TippedGooBlock;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public abstract class BaseFEGooBlock extends GooBlock_Base implements TippedGooBlock {

    public BaseFEGooBlock(Properties p) {
        super(p);
    }

    protected boolean validRevivalItem(ItemStack itemStack) {
        return false;
    }

    @Override
    public Component extra() {
        return Component.translatable(MODULE_ID + "." + Constants.GooType + "." + Constants.Goo.Energized);
    }

}