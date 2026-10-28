package com.devdyna.justdynathings.mixin.jdt;

import com.devdyna.cakesticklib.api.utils.x;
import com.devdyna.justdynathings.config.Config;
import com.direwolf20.justdirethings.client.particles.gooexplodeparticle.GooExplodeParticleData;
import com.direwolf20.justdirethings.common.blockentities.basebe.GooBlockBE_Base;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(GooBlockBE_Base.class)
public abstract class GooBlockBEParticleMixin {

        @Inject(method = "spawnParticles(Lnet/minecraft/core/Direction;)V", at = @At("HEAD"), cancellable = true)
        private void overrideSpawnParticles(Direction dir, CallbackInfo ci) {

                var be = (GooBlockBE_Base) (Object) this;

                var random = new Random();
                var pos = be.getBlockPos().relative(dir);

                for (var direction : Direction.values())
                        for (int i = 0; i < Config.GOO_CONVERSION_PARTICLES_COUNT.get(); i++)
                                be.getLevel().addParticle(new GooExplodeParticleData(x.item(be.getBlockState())),
                                                pos.getX() + (0.5 + (0.6 * direction.getUnitVec3i().getX())
                                                                + (direction.getUnitVec3i().getX() == 0
                                                                                ? random.nextDouble() - 0.5
                                                                                : 0)),
                                                pos.getY() + (0.5 + (0.6 * direction.getUnitVec3i().getY())
                                                                + (direction.getUnitVec3i().getY() == 0
                                                                                ? random.nextDouble() - 0.5
                                                                                : 0)),
                                                pos.getZ() + (0.5 + (0.6 * direction.getUnitVec3i().getZ())
                                                                + (direction.getUnitVec3i().getZ() == 0
                                                                                ? random.nextDouble() - 0.5
                                                                                : 0)),
                                                0, 0, 0);

                ci.cancel();
        }
}
