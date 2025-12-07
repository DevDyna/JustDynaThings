package com.devdyna.justdynathings.compat.jade.providers;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.builders.stabilizer.StabilizerBE;
import com.devdyna.justdynathings.utils.DataGenUtil;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.*;

public enum StabilizerProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
        var t = accessor.getServerData();

        if (t.contains("goo"))
            tooltip.add(Component.translatable(Main.ID + "." + Constants.Blocks.Stabilizer + ".jade.goo")
                    .withStyle(t.getBoolean("goo") ? ChatFormatting.GREEN : ChatFormatting.RED));
        if (t.contains("energized"))
            tooltip.add(Component.translatable(Main.ID + "." + Constants.Blocks.Stabilizer + ".jade.energized")
                    .withStyle(t.getBoolean("energized") ? ChatFormatting.GREEN : ChatFormatting.RED));

    }

    @Override
    public void appendServerData(CompoundTag data, BlockAccessor accessor) {
        StabilizerBE st = (StabilizerBE) accessor.getBlockEntity();
        data.putBoolean("energized", st.isEnergized());
        data.putBoolean("goo", st.canReviveGoo());

    }

    @Override
    public ResourceLocation getUid() {
        return DataGenUtil.getResource(Constants.Blocks.Stabilizer);
    }

}