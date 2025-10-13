package com.devdyna.justdynathings.registry.builders._core.block;

import com.devdyna.justdynathings.registry.interfaces.block.BucketInteractive;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

@SuppressWarnings("null")
public abstract class BaseFluidMachineBlock extends BaseMachineBlock implements BucketInteractive{

    public BaseFluidMachineBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
            Player player, InteractionHand hand, BlockHitResult hitResult) {
        return bucketAction(stack, state, level, pos, player, hand, hitResult);
    }

}
