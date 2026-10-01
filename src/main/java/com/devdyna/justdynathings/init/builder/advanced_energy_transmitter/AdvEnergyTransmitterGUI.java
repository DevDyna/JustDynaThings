package com.devdyna.justdynathings.init.builder.advanced_energy_transmitter;

import com.devdyna.justdynathings.init.types.zBlocks;
import com.devdyna.justdynathings.init.types.zContainers;
import com.direwolf20.justdirethings.common.containers.basecontainers.BaseMachineContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;

public class AdvEnergyTransmitterGUI extends BaseMachineContainer {

    public AdvEnergyTransmitterGUI(int windowId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(windowId, playerInventory, extraData.readBlockPos());
    }

    public AdvEnergyTransmitterGUI(int windowId, Inventory playerInventory, BlockPos blockPos) {
        super(zContainers.ADVANCED_ENERGY_TRANSMITTER.get(), windowId, playerInventory, blockPos);
        this.addPlayerSlots(this.player.getInventory());
    }

    public boolean stillValid(Player playerIn) {
        return stillValid(ContainerLevelAccess.create(this.player.level(), this.pos), this.player,
                zBlocks.ADVANCED_ENERGY_TRANSMITTER.get());
    }

    public ItemStack quickMoveStack(Player playerIn, int index) {
        return super.quickMoveStack(playerIn, index);
    }

    public void removed(Player playerIn) {
        super.removed(playerIn);
    }

}
