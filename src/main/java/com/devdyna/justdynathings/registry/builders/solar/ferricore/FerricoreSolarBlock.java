package com.devdyna.justdynathings.registry.builders.solar.ferricore;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.client.builder.solarGen.ferricore.FerricoreSolarPanelGUI;
import com.devdyna.justdynathings.registry.builders.solar.SolarBlockBase;
import com.devdyna.justdynathings.utils.Actions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FerricoreSolarBlock extends SolarBlockBase {

    public FerricoreSolarBlock() {
        super();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FerricoreSolarBE(pos, state);
    }

    @Override
    public boolean isValidBE(BlockEntity be) {
        return be instanceof FerricoreSolarBE;
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
        Actions.openMenu(p, (w, i, e) -> new FerricoreSolarPanelGUI(w, i, b),b);
    }

}
