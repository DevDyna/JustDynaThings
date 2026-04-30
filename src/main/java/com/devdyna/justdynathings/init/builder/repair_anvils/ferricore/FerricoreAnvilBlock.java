package com.devdyna.justdynathings.init.builder.repair_anvils.ferricore;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.api.Actions;
import com.devdyna.justdynathings.api.repair_anvils.CAnvilBlock;
import com.devdyna.justdynathings.init.builder.repair_anvils.FunctionalAnvils;
import com.devdyna.justdynathings.init.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class FerricoreAnvilBlock extends CAnvilBlock implements FunctionalAnvils {

    public FerricoreAnvilBlock(Properties p) {
        super(p);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new FerricoreAnvilBE(zBlockEntities.FERRICORE_ANVIL.get(), p, s);
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
        Actions.openMenu(p, (w, i, e) -> new FerricoreAnvilGUI(w, i, b), b);
    }

    @Override
    public boolean isValidBE(BlockEntity b) {
        return b instanceof FerricoreAnvilBE;
    }

    @Override
    public boolean supportFluidContent() {
        return false;
    }

    @Override
    public String getTier() {
        return Constants.Anvils.t1;
    }

}