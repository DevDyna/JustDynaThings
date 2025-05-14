package com.devdyna.justdynathings.registry.builders.functional_anvils.metallic;

import com.devdyna.justdynathings.registry.builders.functional_anvils.CAnvilBE;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.utils.Actions;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;

public class MetallicAnvilBE extends CAnvilBE {

    public MetallicAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        this.MACHINE_SLOTS = 2;
        this.condition = 
        getMachineHandler().getStackInSlot(1).is(zItemTags.FERRICORE_ANVIL_REPAIR)
        && getMachineHandler().getStackInSlot(0).isDamageableItem()
        && getMachineHandler().getStackInSlot(0).isDamaged()
        && getMachineHandler().getStackInSlot(0).is(zItemTags.FERRICORE_ANVIL_ALLOW);
    }

    public MetallicAnvilBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.METALLIC_ANVIL.get(), pos, state);
    }

    int i = 0;
    int delay = 20;

    @SuppressWarnings("null")
    public void runActions() {
        if (i < delay) // TODO
            i++;

        if (i >= delay) {
            i = 0;
            getMachineHandler().getStackInSlot(1).shrink(1);
        }
        Actions.repairItem(Capabilities.ItemHandler.BLOCK
                .getCapability(level, getBlockPos(), getBlockState(), getBlockEntity(), getDirectionValue())
                .getStackInSlot(0));
    }

}