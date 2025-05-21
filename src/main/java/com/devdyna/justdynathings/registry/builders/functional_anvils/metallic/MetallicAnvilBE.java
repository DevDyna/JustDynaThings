package com.devdyna.justdynathings.registry.builders.functional_anvils.metallic;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.registry.builders.functional_anvils.CAnvilBE;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.utils.Actions;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MetallicAnvilBE extends CAnvilBE {

    public MetallicAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        this.MACHINE_SLOTS = 2;
    }

    public MetallicAnvilBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.METALLIC_ANVIL.get(), pos, state);
    }

    int delay = Config.ANVILS_FERRICORE_ITEM_COOLDOWN.get();
    int i = delay - 1;

    @Override
    public void tickServer() {
        var tool = getMachineHandler().getStackInSlot(0);
        var catalyst = getMachineHandler().getStackInSlot(1);
        if (isActiveRedstone()) {
            // getMachineHandler() only work inside tick event!
            if (catalyst.is(zItemTags.FERRICORE_ANVIL_REPAIR) && tool.isDamageableItem()
                    && tool.isDamaged() && tool.is(zItemTags.FERRICORE_ANVIL_ALLOW)) {

                if (i < delay)
                    i++;

                if (i >= delay) {
                    i = 0;
                    catalyst.shrink(1);
                }
                Actions.repairItem(tool);

                if (Config.ANVIL_FERRICORE_SOUND_EVENT.get())
                    applySound();

            }
        }
    }

}