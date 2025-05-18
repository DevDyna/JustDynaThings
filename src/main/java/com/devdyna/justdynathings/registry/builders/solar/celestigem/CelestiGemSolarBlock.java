package com.devdyna.justdynathings.registry.builders.solar.celestigem;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.client.builder.solarGen.celestigem.CelestigemSolarPanelGUI;
import com.devdyna.justdynathings.registry.builders.solar.SolarBlockBase;
import com.devdyna.justdynathings.utils.Actions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CelestiGemSolarBlock extends SolarBlockBase {

    public CelestiGemSolarBlock() {
        super();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CelestiGemSolarBE(pos, state);
    }

    @Override
    public boolean isValidBE(BlockEntity be) {
        return be instanceof CelestiGemSolarBE;
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
        Actions.openMenu(p, (w, i, e) -> new CelestigemSolarPanelGUI(w, i, b),b);
    }

}
