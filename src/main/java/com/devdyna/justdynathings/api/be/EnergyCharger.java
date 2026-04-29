package com.devdyna.justdynathings.api.be;

import com.mojang.logging.LogUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.energy.EnergyHandler;
import net.neoforged.neoforge.transfer.transaction.Transaction;

public interface EnergyCharger {

    default void chargeFEtoItemStack(Level level, BlockPos pos, ItemAccess item, EnergyHandler block) {
        try {
            if (block.getAmountAsInt() > 0 && item != null) {
                
                EnergyHandler cap = item.getCapability(Capabilities.Energy.ITEM);

                if (cap == null)
                    return;

                if (cap.getCapacityAsInt() <= 0 || cap.getAmountAsInt() >= cap.getCapacityAsInt()
                        || block.getCapacityAsInt() <= 0 || block.getAmountAsInt() <= 0)
                    return;

                try (var tx = Transaction.openRoot()) {
                    var extracted = block.extract(cap.getCapacityAsInt() - cap.getAmountAsInt(), tx);

                    if (extracted <= 0)
                        tx.close();

                    var insered = cap.insert(extracted, tx);

                    if (insered <= 0)
                        tx.close();
                    else
                        tx.commit();
                }

            }

        } catch (Exception e) {

            var be = level.getBlockEntity(pos);

            if (be == null)
                return;

            LogUtils.getLogger().error(
                    "Corrupted Block Entity Storage at " + pos.toString() + "-> Formatted to prevent crash and bugs");

            level.destroyBlock(pos, true);
        }

    }

}
