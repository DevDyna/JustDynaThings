package com.devdyna.justdynathings.init.builder.solar_panels.ferricore;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.Actions;
import com.devdyna.justdynathings.api.solar_panels.SolarBlockBase;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FerricoreSolarBlock extends SolarBlockBase {

        public FerricoreSolarBlock(Properties p) {
                super(p);
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
                Actions.openMenu(p, (w, i, e) -> new FerricoreSolarPanelGUI(w, i, b), b);
        }

        @Override
        public int getFERate() {
                return Config.SOLARPANEL_FERRICORE_FE_RATE.get();
        }
}
