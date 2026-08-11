package com.devdyna.justdynathings.registry.types;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.recipetypes.zRecipe;
import com.devdyna.justdynathings.recipetypes.serializer.*;
import com.devdyna.justdynathings.recipetypes.type.*;
import com.devdyna.justdynathings.registry.builders.reforger.ReforgerRecipe;
import com.devdyna.justdynathings.registry.builders.reforger.ReforgerRecipeSerializer;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zRecipeTypes {
        // ------------------------------------------------------------------------------------------------------------------------------------//
        public static void register(IEventBus bus) {
                SERIALIZERS.register(bus);
                TYPES.register(bus);
        }

        // ------------------------------------------------------------------------------------------------------------------------------------//
        public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister
                        .create(Registries.RECIPE_SERIALIZER, ID);
        public static final DeferredRegister<RecipeType<?>> TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, ID);
        // ------------------------------------------------------------------------------------------------------------------------------------//

        public static final zRecipe<ReforgerRecipe> REFORGER = new zRecipe<ReforgerRecipe>(  Constants.Blocks.Reforger, ReforgerRecipeSerializer::new);

        public static final zRecipe<ParadoxMixerRecipe> PARADOX_MIXER = new zRecipe<ParadoxMixerRecipe>(
                        Constants.Blocks.ParadoxMixer, ParadoxMixerRecipeSerializer::new,
                        () -> new RecipeType<ParadoxMixerRecipe>() {
                                @Override
                                public String toString() {
                                        return PARADOX_MIXER.getId();
                                }
                        });

        // ------------------------------------------------------------------------------------------------------------------------------------//
}
