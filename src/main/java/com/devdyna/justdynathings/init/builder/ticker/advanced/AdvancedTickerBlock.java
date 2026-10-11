package com.devdyna.justdynathings.init.builder.ticker.advanced;

import com.devdyna.justdynathings.api.Actions;
import com.devdyna.justdynathings.init.builder.ticker.simple.SimpleTickerBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import javax.annotation.Nullable;

public class AdvancedTickerBlock extends SimpleTickerBlock {

    public AdvancedTickerBlock(Properties p) {
        super(p);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AdvancedTickerBE(pos, state);
    }

    @Override
    public void openMenu(Player player, BlockPos blockPos) {
        Actions.openMenu(player,
                (windowId, playerInventory, playerEntity) -> new AdvancedTickerGUI(windowId, playerInventory, blockPos),
                blockPos);
    }

    @Override
    public boolean isValidBE(BlockEntity blockEntity) {
        return blockEntity instanceof AdvancedTickerBE;
    }

}