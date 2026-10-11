package com.devdyna.justdynathings.init.builder.solar_panels.celestigem;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.solar_panels.SolarGUIBase;
import com.devdyna.justdynathings.init.types.zBiomeTags;
import com.devdyna.justdynathings.init.types.zBlocks;
import com.devdyna.justdynathings.init.types.zContainers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;

public class CelestigemSolarPanelGUI extends SolarGUIBase {

    public CelestigemSolarPanelGUI(int windowId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(windowId, playerInventory, extraData.readBlockPos());
    }

    public CelestigemSolarPanelGUI(int windowId, Inventory playerInventory, BlockPos blockPos) {
        super(zContainers.CELESTIGEM_SOLAR_PANEL.get(), windowId, playerInventory, blockPos);
        addPlayerSlots(player.getInventory());
    }

    @Override
    public void addMachineSlots() {
        machineHandler = baseMachineBE.getMachineHandler();
        addSlotRange(machineHandler, machineHandler::set, 0, 80, 13, 1, 18);
    }

    @Override
    public boolean stillValid(Player playerIn) {
        return stillValid(ContainerLevelAccess.create(player.level(), pos), player, zBlocks.CELESTIGEM_SOLARGEN.get());
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        return super.quickMoveStack(playerIn, index);
    }

    @Override
    public void removed(Player playerIn) {
        super.removed(playerIn);
    }

    @Override
    public int getFERate() {
        return Config.SOLARPANEL_CELESTIGEM_FE_RATE.get();
    }

    @Override
    public boolean enableMultiPopulator() {
        return Config.SOLARPANEL_CELESTIGEM_ENABLE_SPAM.get();
    }

    @Override
    public boolean enableMultiYLevel() {
        return Config.SOLARPANEL_CELESTIGEM_ENABLE_YLEVEL.get();
    }

    @Override
    public boolean enableCleanSky() {
        return Config.SOLARPANEL_CELESTIGEM_ENABLE_SKY.get();
    }

    @Override
    public boolean enableDayTimeOnly() {
        return Config.SOLARPANEL_CELESTIGEM_ENABLE_DAYTIME.get();
    }

    @Override
    public TagKey<Biome> getBiomeTag() {
        return zBiomeTags.CELESTIGEM_SOLAR_PANEL_BIOME_LIST;
    }

    @Override
    public boolean isAllowBiome() {
        return Config.SOLARPANEL_CELESTIGEM_BIOMES.get();
    }

}