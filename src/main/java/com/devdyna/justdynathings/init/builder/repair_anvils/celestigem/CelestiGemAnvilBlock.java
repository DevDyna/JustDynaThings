package com.devdyna.justdynathings.init.builder.repair_anvils.celestigem;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.api.Actions;
import com.devdyna.justdynathings.api.repair_anvils.FunctionalAnvilBlock;

public class CelestiGemAnvilBlock extends FunctionalAnvilBlock {

    public CelestiGemAnvilBlock(Properties p) {
        super(p);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new CelestiGemAnvilBE( p, s);
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
        Actions.openMenu(p, (w, i, e) -> new CelestiGemAnvilGUI(w, i, b), b);
    }

    @Override
    public boolean isValidBE(BlockEntity b) {
        return b instanceof CelestiGemAnvilBE;
    }

    @Override
    public boolean supportFluidContent() {
        return false;
    }

    @Override
    public String getTier() {
        return Constants.Anvils.t3;
    }

}