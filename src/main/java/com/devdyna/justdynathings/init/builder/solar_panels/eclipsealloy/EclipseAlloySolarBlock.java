package com.devdyna.justdynathings.init.builder.solar_panels.eclipsealloy;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.Actions;
import com.devdyna.justdynathings.api.solar_panels.SolarBlockBase;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EclipseAlloySolarBlock extends SolarBlockBase {

        public EclipseAlloySolarBlock(Properties p) {
                super(p);
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
                Actions.openMenu(p, (w, i, e) -> new EclipseAlloySolarPanelGUI(w, i, b), b);
        }

        @Override
        public int getFERate() {
                return Config.SOLARPANEL_ECLIPSEALLOY_FE_RATE.get();
        }

}
