package com.devdyna.justdynathings.init.builder.repair_anvils.blazegold;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.api.Actions;
import com.devdyna.justdynathings.api.repair_anvils.FunctionalAnvilBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class BlazeGoldAnvilBlock extends FunctionalAnvilBlock {

    public BlazeGoldAnvilBlock(Properties p) {
        super(p);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new BlazeGoldAnvilBE( p, s);
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
        Actions.openMenu(p, (w, i, e) -> new BlazeGoldAnvilGUI(w, i, b), b);
    }

    @Override
    public boolean isValidBE(BlockEntity b) {
        return b instanceof BlazeGoldAnvilBE;
    }

    @Override
    public boolean supportFluidContent() {
        return true;
    }

    @Override
    public String getTier() {
        return Constants.Anvils.t2;
    }

}