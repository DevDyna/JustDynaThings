package com.devdyna.justdynathings.init.builder.solar_panels.blazegold;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.api.Actions;
import com.devdyna.justdynathings.api.solar_panels.SolarBlockBase;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlazeGoldSolarBlock extends SolarBlockBase {

        public BlazeGoldSolarBlock(Properties p) {
                super(p);
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
                Actions.openMenu(p, (w, i, e) -> new BlazegoldSolarPanelGUI(w, i, b), b);
        }

        
}
