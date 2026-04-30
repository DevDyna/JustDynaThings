package com.devdyna.justdynathings.init.builder.repair_anvils.blazegold;



import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.be.FluidMachine;
import com.devdyna.justdynathings.api.repair_anvils.FunctionalAnvilBE;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.capabilities.JustDireFluidTank;
import com.direwolf20.justdirethings.setup.JDTRegistration;

import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BlazeGoldAnvilBE extends FunctionalAnvilBE implements FluidMachine {

    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public BlazeGoldAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        this.MACHINE_SLOTS = 1;
    }

    public BlazeGoldAnvilBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.BLAZEGOLD_ANVIL.get(), pos, state);
    }

    @Override
    public void tickServer() {
        super.tickServer();//TODO logic
        // var fluid = getFluidStack().getFluidHolder().getData(zDataMaps.BLAZEGOLD_FLUID);
        // var tool = getMachineHandler().getStackInSlot(0);
        // if (isActiveRedstone() && fluid != null) {
        //     // getMachineHandler() only work inside tick event!
        //     if (canExtractMB() && tool.isDamageableItem()
        //             && tool.isDamaged() && !tool.is(zItemTags.BLAZEGOLD_ANVIL_DENY)) {
        //         extractMBWhenPossible((int) (20/fluid.efficiency()));
        //         Actions.repairItem(tool,(int) fluid.efficiency());
        //         if (CommonConfig.ANVIL_BLAZEGOLD_SOUND_EVENT.get())
        //             applySound();
        //     }
        // }
    }

    @Override
    public ContainerData getFluidContainerData() {
        return fluidContainerData;
    }

    @Override
    public JustDireFluidTank getFluidTank() {
        return getData(JDTRegistration.MACHINE_FLUID_HANDLER);
    }

    @Override
    public int getMaxMB() {
        return Config.ANVILS_BLAZEGOLD_MB_CAPACITY.get();
    }

    @Override
    public int getStandardFluidCost() {
        return Config.ANVILS_BLAZEGOLD_MB_RATE.get();
    }
}