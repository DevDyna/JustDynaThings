package com.devdyna.justdynathings.registry.builders.functional_anvils.ferricore;

import com.devdyna.justdynathings.client.builder.anvil.ferricore.FerricoreAnvilGUI;
import com.devdyna.justdynathings.registry.builders.functional_anvils.CAnvilBlock;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.utils.Actions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import javax.annotation.Nullable;

public class FerricoreAnvilBlock extends CAnvilBlock {

    public FerricoreAnvilBlock() {
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

}