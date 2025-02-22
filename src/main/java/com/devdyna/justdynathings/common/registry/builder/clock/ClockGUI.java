package com.devdyna.justdynathings.common.registry.builder.clock;

import com.devdyna.justdynathings.common.registry.Material;
import com.direwolf20.justdirethings.common.containers.basecontainers.BaseMachineContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;

@SuppressWarnings("null")
public class ClockGUI extends BaseMachineContainer {

    public ClockGUI(int windowId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(windowId, playerInventory, extraData.readBlockPos());
    }

    public ClockGUI(int windowId, Inventory playerInventory, BlockPos blockPos) {
        super(Material.CLOCK_GUI.get(), windowId, playerInventory, blockPos);
        addPlayerSlots(player.getInventory());
    }

    @Override
    public boolean stillValid(Player playerIn) {
        return stillValid(ContainerLevelAccess.create(player.level(), pos), player, Material.CLOCK_BLOCK.get());
    }

    @Override
    public void removed(Player playerIn) {
        super.removed(playerIn);
    }
}