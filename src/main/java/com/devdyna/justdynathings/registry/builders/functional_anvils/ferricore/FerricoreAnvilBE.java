package com.devdyna.justdynathings.registry.builders.functional_anvils.ferricore;

import com.devdyna.justdynathings.config.common;
import com.devdyna.justdynathings.datamaps.zDataMaps;
import com.devdyna.justdynathings.registry.builders.functional_anvils.CAnvilBE;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.utils.Actions;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class FerricoreAnvilBE extends CAnvilBE {

    public FerricoreAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        this.MACHINE_SLOTS = 2;
    }

    public FerricoreAnvilBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.FERRICORE_ANVIL.get(), pos, state);
    }

    // int delay = Config.ANVILS_FERRICORE_ITEM_COOLDOWN.get();
    // int i = delay - 1;

    private static boolean canConsume = true;
    private static int totalToRepair = 0;

    int i = 0;

    @Override
    public void tickServer() {
        var tool = getMachineHandler().getStackInSlot(0);
        var catalyst = getMachineHandler().getStackInSlot(1);
        if (isActiveRedstone()) {
            // getMachineHandler() only work inside tick event!
            var data = catalyst.getItemHolder().getData(zDataMaps.FERRICORE_REPAIR);

            if (data != null && tool.isDamageableItem()
                    && tool.isDamaged() && !tool.is(zItemTags.FERRICORE_ANVIL_DENY) && canConsume) {

                catalyst.shrink(1);
                canConsume = false;
                totalToRepair = data.durability();
            }

            if (!canConsume) {
                if (i < totalToRepair) {
                    i++;
                    Actions.repairItem(tool, 1);
                    if (common.ANVIL_FERRICORE_SOUND_EVENT.get())
                        applySound();
                }

                if (i >= totalToRepair) {
                    i = 0;
                    canConsume = true;
                }
            }

        }
    }

}