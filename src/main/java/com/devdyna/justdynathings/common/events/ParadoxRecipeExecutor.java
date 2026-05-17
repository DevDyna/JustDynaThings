package com.devdyna.justdynathings.common.events;

import java.util.Optional;

import com.devdyna.cakesticklib.api.recipe.recipeInput.ItemInput;
import com.devdyna.justdynathings.common.recipes.paradox.ParadoxInfusionRecipe;
import com.devdyna.justdynathings.init.types.zRecipeTypes;
import com.direwolf20.justdirethings.common.entities.ParadoxEntity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

public class ParadoxRecipeExecutor {
    @SubscribeEvent
    public static void paradoxConversion(EntityTickEvent.Post e) {
        var entity = e.getEntity();
        var level = entity.level();

        var flag = false;

        if (entity instanceof ItemEntity itemEntity) {
            if (!level.isClientSide()) {

                var inputItem = itemEntity.getItem();

                var collidedParadox = entity.level().getEntitiesOfClass(
                        ParadoxEntity.class, entity.getBoundingBox().inflate(0.1f));

                if (collidedParadox.isEmpty())
                    return;

                Optional<RecipeHolder<ParadoxInfusionRecipe>> r = level.getServer().getRecipeManager()
                        .getRecipeFor(zRecipeTypes.PARADOX_INFUSION.getType(),
                                ItemInput.withNumber.of(inputItem, collidedParadox.getFirst().getRadius()), level);

                if (r.isEmpty())
                    return;

                var recipe = r.get().value();

                itemEntity.setItem(recipe.getOutput().create());

                flag = true;
            }

            if (level.isClientSide() && flag)
                level.addParticle(ParticleTypes.SONIC_BOOM, entity.getX(), entity.getY(), entity.getZ(), 0,
                        0, 0);

        }

    }
}
