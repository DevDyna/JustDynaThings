package com.devdyna.justdynathings.common.events;

import com.devdyna.justdynathings.init.types.zItemTags;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.item.ItemEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

public class ItemAbstractParadox {

    @SubscribeEvent
    public static void onParadoxDrop(EntityTickEvent.Post e) {
        var entity = e.getEntity();
        var level = entity.level();

        // TODO float random is more accurate! level.getRandom().nextFloat() < 25 *
        // 0.001f

        if (entity instanceof ItemEntity itemEntity && itemEntity.getItem().is(zItemTags.ABSTRACT_PARADOX)) {

            itemEntity.setNoGravity(true);

            if (level.isClientSide() && level.getGameTime() % 10 == 0)
                level.addParticle(ParticleTypes.SCULK_SOUL, entity.getX(), entity.getY(), entity.getZ(), 0,
                        0, 0);
        }

    }

}
