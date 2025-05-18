package com.devdyna.justdynathings.registry.builders.solar.blazegold;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.client.builder.solarGen.blazegold.BlazegoldSolarPanelGUI;
import com.devdyna.justdynathings.registry.builders.solar.SolarBlockBase;
import com.devdyna.justdynathings.utils.Actions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlazeGoldSolarBlock extends SolarBlockBase {

    public BlazeGoldSolarBlock() {
        super();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlazeGoldSolarBE(pos, state);
    }

    @Override
    public boolean isValidBE(BlockEntity be) {
        return be instanceof BlazeGoldSolarBE;
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
        Actions.openMenu(p, (w, i, e) -> new BlazegoldSolarPanelGUI(w, i, b),b);
    }

}
