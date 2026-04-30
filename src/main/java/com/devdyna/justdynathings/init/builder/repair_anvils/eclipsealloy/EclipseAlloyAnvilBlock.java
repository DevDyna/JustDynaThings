package com.devdyna.justdynathings.init.builder.repair_anvils.eclipsealloy;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.api.Actions;
import com.devdyna.justdynathings.api.repair_anvils.FunctionalAnvilBlock;
import com.devdyna.justdynathings.init.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class EclipseAlloyAnvilBlock extends FunctionalAnvilBlock   {

    public EclipseAlloyAnvilBlock(Properties p) {
        super(p);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new EclipseAlloyAnvilBE(zBlockEntities.ECLIPSEALLOY_ANVIL.get(), p, s);
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
        Actions.openMenu(p, (w, i, e) -> new EclipseAlloyAnvilGUI(w, i, b), b);
    }

    @Override
    public boolean isValidBE(BlockEntity b) {
        return b instanceof EclipseAlloyAnvilBE;
    }

    @Override
    public boolean supportFluidContent() {
        return true;
    }

    @Override
    public String getTier() {
        return Constants.Anvils.t4;
    }

}