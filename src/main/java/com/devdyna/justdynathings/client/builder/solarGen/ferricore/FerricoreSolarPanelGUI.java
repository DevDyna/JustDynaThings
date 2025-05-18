package com.devdyna.justdynathings.client.builder.solarGen.ferricore;

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
public class FerricoreSolarPanelGUI extends BaseMachineContainer {

    public FerricoreSolarPanelGUI(int windowId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(windowId, playerInventory, extraData.readBlockPos());
    }

    public FerricoreSolarPanelGUI(int windowId, Inventory playerInventory, BlockPos blockPos) {
        super(zContainers.FERRICORE_SOLAR_PANEL.get(), windowId, playerInventory, blockPos);
        addPlayerSlots(player.getInventory());
    }


    @Override
    public void addMachineSlots() {
        machineHandler = baseMachineBE.getMachineHandler();
    }

    @Override
    public boolean stillValid(Player playerIn) {
        return stillValid(ContainerLevelAccess.create(player.level(), pos), player, zBlocks.FERRICORE_SOLARGEN.get());
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