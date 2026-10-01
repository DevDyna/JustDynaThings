package com.devdyna.justdynathings.mixin;

import com.direwolf20.justdirethings.common.blockentities.EnergyTransmitterBE;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.capabilities.BlockCapabilityCache;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.transfer.energy.EnergyHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EnergyTransmitterBE.class)
public abstract class EnergyTransmitterMixin {

        @Overwrite
        public EnergyHandler getTransmitterHandler(BlockPos blockPos) {
                EnergyTransmitterBE self = (EnergyTransmitterBE) (Object) this;

                var temp = ((EnergyTransmitterAccessor) self).getTransmitterHandlers().get(blockPos);

                if (temp != null) 
                        return temp.getCapability();
                

                BlockState blockState = self.getLevel().getBlockState(blockPos);

                if (!(self.getLevel().getBlockEntity(blockPos) instanceof EnergyTransmitterBE)) 
                        return null;
                

                temp = BlockCapabilityCache.create(
                                Capabilities.Energy.BLOCK,
                                (ServerLevel) self.getLevel(),
                                blockPos,
                                blockState.getValue(BlockStateProperties.FACING));

                if (temp.getCapability() == null) 
                        return null;
                

                ((EnergyTransmitterAccessor) self).getTransmitterHandlers().put(blockPos, temp);

                return temp.getCapability();
        }
}