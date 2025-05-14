package com.devdyna.justdynathings.registry.builders.functional_anvils.magmatic;

import com.devdyna.justdynathings.registry.builders.functional_anvils.CAnvilBE;
import com.devdyna.justdynathings.registry.interfaces.be.FluidMachine;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zHandlers;
import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.utils.Actions;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

public class MagmaAnvilBE extends CAnvilBE implements FluidMachine {

    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public MagmaAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        this.MACHINE_SLOTS = 2;
        this.condition = canExtractMB() && getMachineHandler().getStackInSlot(0).isDamageableItem()
                && getMachineHandler().getStackInSlot(0).isDamaged()
                && !getMachineHandler().getStackInSlot(0).is(zItemTags.BLAZING_ANVIL_DENY);
    }

    public MagmaAnvilBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.MAGMATIC_ANVIL.get(), pos, state);
    }

    public void runActions() {
        extractMBWhenPossible();
        Actions.repairItem(getMachineHandler().getStackInSlot(0));
    }

    @Override
    public ContainerData getFluidContainerData() {
        return fluidContainerData;
    }

    @Override
    public FluidTank getFluidTank() {
        return getData(zHandlers.MAGMATIC_LIQUID);
    }

    
    @Override
    public int getMaxMB() {
        return FLsize / 10;
    }

    @Override
    public int getStandardFluidCost() {
        return FLrate / 100;
    }
}