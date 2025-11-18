package com.devdyna.justdynathings.client.type.paradoxMixer;

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
public class ParadoxMixerGUI extends BaseMachineContainer {

    public ParadoxMixerGUI(int windowId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(windowId, playerInventory, extraData.readBlockPos());
    }

    public ParadoxMixerGUI(int windowId, Inventory playerInventory, BlockPos blockPos) {
        super(zContainers.PARADOX_MIXER.get(), windowId, playerInventory, blockPos);
        addPlayerSlots(player.getInventory());
    }

    @Override
    public void addMachineSlots() {
        machineHandler = baseMachineBE.getMachineHandler();
        // for (int i = 0; i < 4; i++)
        addSlotRange(machineHandler, 0, 80, 13, 4, 18);
    }

    @Override
    public boolean stillValid(Player playerIn) {
        return stillValid(ContainerLevelAccess.create(player.level(), pos), player, zBlocks.PARADOX_MIXER.get());
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