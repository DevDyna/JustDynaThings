package com.devdyna.justdynathings.registry.builders.fluid_tank;

import java.util.List;
import com.devdyna.justdynathings.config.common;
import com.devdyna.justdynathings.recipetypes.type.FluidTankRecipe;
import com.devdyna.justdynathings.registry.interfaces.be.EnergyMachine;
import com.devdyna.justdynathings.registry.interfaces.be.FluidMachine;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.registry.types.zRecipeTypes;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.RedstoneControlledBE;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.Registration;
import com.direwolf20.justdirethings.util.interfacehelpers.RedstoneControlData;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

@SuppressWarnings({ "null" })
public class FluidTankBE extends BaseMachineBE
        implements EnergyMachine, RedstoneControlledBE, FluidMachine {

    public RedstoneControlData redstoneControlData = new RedstoneControlData();
    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);
    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public FluidTankBE(BlockEntityType<?> type, BlockPos pos, BlockState b) {
        super(type, pos, b);
        MACHINE_SLOTS = 1;
    }

    public FluidTankBE(BlockPos pos, BlockState b) {
        this(zBlockEntities.FLUID_TANK.get(), pos, b);
    }

    @Override
    public void tickServer() {

        updateBlock(isActiveRedstone());

        var catalyst = getMachineHandler().getStackInSlot(0);

        List<RecipeHolder<FluidTankRecipe>> recipes = level.getRecipeManager()
                .getAllRecipesFor(zRecipeTypes.FLUID_TANK_RECIPES.getType());

        var recipe = recipes.stream().filter(r -> r.value().getCatalyst().test(catalyst)
                && getFluidStack().is(r.value().getInput().getFluidType())
                && getFluidStack().getAmount() == r.value().getInput().getAmount()).findFirst();

                 

        if (recipe.isPresent() && isActiveRedstone() && canExtractFE()) {
            
            var fluid = recipe.get().value().getOutput();
            // fluid.setAmount(recipe.get().value().getOutput().getAmount());

            // LogUtil.info("fired "+fluid+" -> "+getFluidTank());
            setFluidStack(fluid.getFluid(), fluid.getAmount());
            catalyst.shrink(1);
            extractFEWhenPossible();
            level.playSound(null, getBlockPos(),
                    SoundEvents.BREWING_STAND_BREW,
                    SoundSource.BLOCKS, (level.random.nextInt(10) + 1) * 0.01F,
                    level.random.nextInt(50) + 1 * 0.01F);
        }

    }

    public void updateBlock(boolean state) {
        level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(zProperties.ACTIVE, state));
    }

    @Override
    public ContainerData getFluidContainerData() {
        return fluidContainerData;
    }

    @Override
    public FluidTank getFluidTank() {
        return getData(Registration.MACHINE_FLUID_HANDLER);
    }

    @Override
    public MachineEnergyStorage getEnergyStorage() {
        return getData(Registration.ENERGYSTORAGE_MACHINES);
    }

    @Override
    public ContainerData getContainerData() {
        return poweredMachineData;
    }

    @Override
    public BlockEntity getBlockEntity() {
        return this;
    }

    @Override
    public RedstoneControlData getRedstoneControlData() {
        return redstoneControlData;
    }

    @Override
    public int getStandardEnergyCost() {
        return common.FLUID_TANK_FE_RATE.get();
    }

    @Override
    public int getMaxEnergy() {
        return common.FLUID_TANK_FE_CAPACITY.get();
    }

    @Override
    public int getMaxMB() {
        return common.FLUID_TANK_MB_CAPACITY.get();
    }

    @Override
    public int getStandardFluidCost() {
        return 0;
    }

}
