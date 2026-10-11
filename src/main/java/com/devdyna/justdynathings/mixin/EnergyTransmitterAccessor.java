package com.devdyna.justdynathings.mixin;

import com.direwolf20.justdirethings.common.blockentities.EnergyTransmitterBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.neoforged.neoforge.capabilities.BlockCapabilityCache;
import net.neoforged.neoforge.transfer.energy.EnergyHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(EnergyTransmitterBE.class)
public interface EnergyTransmitterAccessor {

    @Accessor("transmitterHandlers")
    Map<BlockPos, BlockCapabilityCache<EnergyHandler, Direction>> getTransmitterHandlers();
}
