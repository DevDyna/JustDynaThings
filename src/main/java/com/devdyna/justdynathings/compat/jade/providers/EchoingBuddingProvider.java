package com.devdyna.justdynathings.compat.jade.providers;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBE;
import com.devdyna.justdynathings.utils.DataGenUtil;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.*;

public enum EchoingBuddingProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {

    INSTANCE;

    @Override

    public void appendTooltip(
            ITooltip tooltip,
            BlockAccessor accessor,
            IPluginConfig config) {

        var t = accessor.getServerData();
        if (t.contains("time") && t.getBoolean("time"))
            tooltip.add(Component.translatable(Main.ID + "." + Constants.BuddingType + ".jade.time"));

        if (t.contains("fe") && t.getBoolean("fe"))
            tooltip.add(Component.translatable(Main.ID + "." + Constants.BuddingType + ".jade.fe"));

    }

    @Override

    public void appendServerData(CompoundTag data, BlockAccessor accessor) {
        BuddingBE bud = (BuddingBE) accessor.getBlockEntity();
        data.putBoolean("time", bud.requireTime());
        data.putBoolean("fe", bud.requireFE());

    }

    @Override
    public ResourceLocation getUid() {
        return DataGenUtil.getResource(Constants.BuddingType);
    }

}