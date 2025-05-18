package com.devdyna.justdynathings.client.builder.solarGen.blazegold;

import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zContainers;
import com.direwolf20.justdirethings.common.containers.basecontainers.BaseMachineContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("null")
public class BlazegoldSolarPanelGUI extends BaseMachineContainer {

    public BlazegoldSolarPanelGUI(int windowId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(windowId, playerInventory, extraData.readBlockPos());
    }

    public BlazegoldSolarPanelGUI(int windowId, Inventory playerInventory, BlockPos blockPos) {
        super(zContainers.BLAZEGOLD_SOLAR_PANEL.get(), windowId, playerInventory, blockPos);
        addPlayerSlots(player.getInventory());
    }


    @Override
    public void addMachineSlots() {
        machineHandler = baseMachineBE.getMachineHandler();
    }

    @Override
    public boolean stillValid(Player playerIn) {
        return stillValid(ContainerLevelAccess.create(player.level(), pos), player, zBlocks.BLAZEGOLD_SOLARGEN.get());
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        return super.quickMoveStack(playerIn, index);
    }

    @Override
    public void removed(Player playerIn) {
        super.removed(playerIn);
    }

}