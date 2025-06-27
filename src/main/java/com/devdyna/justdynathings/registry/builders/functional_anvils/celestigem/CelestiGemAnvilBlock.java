package com.devdyna.justdynathings.registry.builders.functional_anvils.celestigem;

import com.devdyna.justdynathings.client.builder.anvil.celestigem.CelestiGemAnvilGUI;
import com.devdyna.justdynathings.registry.builders.functional_anvils.CAnvilBlock;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.utils.Actions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import javax.annotation.Nullable;

public class CelestiGemAnvilBlock extends CAnvilBlock {

    public CelestiGemAnvilBlock() {
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new CelestiGemAnvilBE(zBlockEntities.CELESTIGEM_ANVIL.get(), p, s);
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
        Actions.openMenu(p, (w, i, e) -> new CelestiGemAnvilGUI(w, i, b), b);
    }

    @Override
    public boolean isValidBE(BlockEntity b) {
        return b instanceof CelestiGemAnvilBE;
    }

}