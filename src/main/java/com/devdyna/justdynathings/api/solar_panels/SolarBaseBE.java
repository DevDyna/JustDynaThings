package com.devdyna.justdynathings.api.solar_panels;

import java.util.HashMap;
import java.util.Map;

import com.devdyna.cakesticklib.api.utils.DirectionUtil;
import com.devdyna.cakesticklib.api.utils.x;
import com.devdyna.justdynathings.api.Actions;
import com.devdyna.justdynathings.init.types.zProperties;
import com.devdyna.justdynathings.interfaces.be.EnergyCharger;
import com.devdyna.justdynathings.interfaces.be.EnergyGenerator;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.RedstoneControlledBE;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.direwolf20.justdirethings.util.interfacehelpers.RedstoneControlData;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.BlockCapabilityCache;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.energy.EnergyHandler;

public abstract class SolarBaseBE extends BaseMachineBE implements EnergyGenerator, RedstoneControlledBE, EnergyCharger {

    public RedstoneControlData redstoneControlData = new RedstoneControlData();
    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);
    private final Map<Direction, BlockCapabilityCache<EnergyHandler, Direction>> cache = new HashMap<>();

    public SolarBaseBE(BlockEntityType<?> t, BlockPos p, BlockState b) {
        super(t, p, b);
        MACHINE_SLOTS = 1;

    }

    @Deprecated
    public SolarBaseBE(BlockPos p, BlockState b) {
        this(null, p, b);
    }

    @Override
    public void tickServer() {
        super.tickServer();
        updateBlock();
        if (isActiveRedstone() && getBlockState().getValue(zProperties.ACTIVE).booleanValue()) {
            increaseFEWhenPossible(calculateFE());
        }
        if (canExtractFE())
            Actions.providePowerAdjacent(level, getBlockPos(), cache, calculateFE());

        if (isActiveRedstone() && canExtractFE())
            chargeFEtoItemStack(level, getBlockPos(), ItemAccess.forHandlerIndex(getMachineHandler(), 0), getEnergyStorage());

    }

    public void updateBlock() {
        level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(zProperties.ACTIVE,
                canGenerateWhen()));
    }

    /**
     * DONT use to set FE gen
     */
    @Override
    public int getStandardEnergyCost() {
        return 0;
    }

    @Override
    public int getMaxEnergy() {
        return 0;
    }

    @Override
    public ContainerData getContainerData() {
        return poweredMachineData;
    }

    @Override
    public MachineEnergyStorage getEnergyStorage() {
        return getData(JDTRegistration.ENERGYSTORAGE_GENERATORS);
    }

    @Override
    public BlockEntity getBlockEntity() {
        return this;
    }

    @Override
    public RedstoneControlData getRedstoneControlData() {
        return redstoneControlData;
    }

    private int calculateFE() {
        float multiplier = 1f;

        if (enableMultiPopulator()) {
            int blocks = 1;

            for (BlockPos blockPos : DirectionUtil.around(getBlockPos())) {
                if (level.getBlockState(blockPos).is(getBlockState().getBlock()))
                    blocks++;
            }

            multiplier *= (blocks / DirectionUtil.around(getBlockPos()).size() + 1);
        }

        if (enableMultiYLevel()) {

            int min = level.getMinY();
            int max = level.getMaxY() - 1;

            int y = getBlockPos().getY();

            float middle = (min + max) / 2.0f;

            float unckecked = 1.0f - (((y - middle) / (max - min)) * ((y - middle) / (max - min)) * 4);
            unckecked = Math.max(unckecked, 0);
            multiplier *= 0.05f + (1.0f - 0.05f) * (1.0f - unckecked);
        }

        return (int) (FErate() * multiplier);
    }

    public int FErate() {
        return 0;
    }

    private boolean canGenerateWhen() {
        var result = true;
        if (enableCleanSky())
            result &= canSeeSky();

        if (enableDayTimeOnly())
            result &= isDayTime();

        var checkBiome = isBiome(level, getBlockPos(), getBiomeTag());

        result &= isAllowBiome() ? checkBiome : !checkBiome;

        return result;
    }

    /**
     * More solar panels are placed around it -> more FE rate will generate
     */
    public boolean enableMultiPopulator() {
        return false;
    }

    /**
     * Y-level condition multiplier -> Y more higher/lower -> more FE rate will
     * generate
     */
    public boolean enableMultiYLevel() {
        return false;
    }

    private boolean canSeeSky() {
        return level.canSeeSkyFromBelowWater(getBlockPos().above())
                && level.getBlockState(getBlockPos().above()).isAir();
    }

    private boolean isDayTime() {
        return level.isBrightOutside();
    }

    public TagKey<Biome> getBiomeTag() {
        return null;
    }

    public boolean isAllowBiome() {
        return false;
    }

    public boolean enableCleanSky() {
        return true;
    }

    public boolean enableDayTimeOnly() {
        return true;
    }



public static boolean isDimension(Level level, ResourceKey<Level> dim) {
        return level.dimension().equals(dim);
    }

    public static boolean isBiome(Level level, BlockPos pos, String modid, String biome) {
        return level.getBiome(pos).is(x.rl(modid, biome));
    }

    public static boolean isBiome(Level level, BlockPos pos, TagKey<Biome> biome) {
        return level.getBiome(pos).is(biome);
    }

}
