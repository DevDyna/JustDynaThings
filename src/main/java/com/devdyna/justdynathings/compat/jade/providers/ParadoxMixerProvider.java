package com.devdyna.justdynathings.compat.jade.providers;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.builders.paradox_mixer.ParadoxMixerBE;
import com.devdyna.justdynathings.utils.DataGenUtil;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.*;

public enum ParadoxMixerProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
        var t = accessor.getServerData();

        if (t.contains("stabilized") && !t.getBoolean("stabilized"))
            tooltip.add(Component.translatable(Main.ID + "." + Constants.Blocks.ParadoxMixer + ".jade.dead"));
    }

    @Override
    public void appendServerData(CompoundTag data, BlockAccessor accessor) {
        ParadoxMixerBE st = (ParadoxMixerBE) accessor.getBlockEntity();
        data.putBoolean("stabilized", st.canProcess());

    }

    @Override
    public ResourceLocation getUid() {
        return DataGenUtil.getResource(Constants.Blocks.ParadoxMixer);
    }

}