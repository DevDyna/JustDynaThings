package com.devdyna.justdynathings.registry.builders.solar.eclipsealloy;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.client.builder.solarGen.eclipsealloy.EclipseAlloySolarPanelGUI;
import com.devdyna.justdynathings.registry.builders.solar.SolarBlockBase;
import com.devdyna.justdynathings.utils.Actions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EclipseAlloySolarBlock extends SolarBlockBase {

    public EclipseAlloySolarBlock() {
        super();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EclipseAlloySolarBE(pos, state);
    }

    @Override
    public boolean isValidBE(BlockEntity be) {
        return be instanceof EclipseAlloySolarBE;
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
        Actions.openMenu(p, (w, i, e) -> new EclipseAlloySolarPanelGUI(w, i, b),b);
    }

}
