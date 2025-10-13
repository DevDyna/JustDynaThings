package com.devdyna.justdynathings.registry.interfaces.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;

public interface BucketInteractive {

    default ItemInteractionResult bucketAction(ItemStack item, BlockState blockState, Level level,
            BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if (level.isClientSide)
            return ItemInteractionResult.SUCCESS;

        IFluidHandlerItem bucket = item.getCapability(Capabilities.FluidHandler.ITEM);
        if (bucket == null) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        IFluidHandler cap = level.getCapability(Capabilities.FluidHandler.BLOCK, blockPos,
                blockHitResult.getDirection());

        if (cap == null)
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        int droplet = 0;

        if (bucket.getFluidInTank(0).isEmpty()) {
            // bucket full -> drain to BE
            FluidStack sim = cap.drain(bucket.getTankCapacity(0),
                    IFluidHandler.FluidAction.SIMULATE);

            if (sim.getAmount() > 0) {

                droplet = bucket.fill(sim, IFluidHandler.FluidAction.SIMULATE);
                if (droplet > 0) {

                    bucket.fill(cap.drain(droplet,
                            IFluidHandler.FluidAction.EXECUTE),
                            player.isCreative() ? IFluidHandler.FluidAction.SIMULATE
                                    : IFluidHandler.FluidAction.EXECUTE);
                    if (item.getItem() instanceof BucketItem)
                        player.setItemInHand(hand, bucket.getContainer());

                    level.playSound(null, blockPos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1F, 1.0F);
                    return ItemInteractionResult.SUCCESS;
                }

            }

        } else {
            // bucket empty -> fill from BE
            droplet = cap.fill(bucket.getFluidInTank(0), IFluidHandler.FluidAction.SIMULATE);
            if (droplet > 0) {
                FluidStack tank = bucket.drain(droplet, player.isCreative() ? IFluidHandler.FluidAction.SIMULATE
                        : IFluidHandler.FluidAction.EXECUTE);
                if (!tank.isEmpty()) {
                    cap.fill(tank, IFluidHandler.FluidAction.EXECUTE);
                    if (item.getItem() instanceof BucketItem)
                        player.setItemInHand(hand, bucket.getContainer());

                    level.playSound(null, blockPos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1F, 1.0F);
                    return ItemInteractionResult.SUCCESS;
                }
            }

        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
