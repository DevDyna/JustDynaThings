package com.devdyna.justdynathings.init.types;

import com.devdyna.justdynathings.JustDynaThings;
import com.devdyna.justdynathings.api.RecipeRegister;
import com.devdyna.justdynathings.common.recipes.anvils.blazegold.RepairBlazegoldAnvilRecipe;
import com.devdyna.justdynathings.common.recipes.anvils.eclipsealloy.RepairEclipseAlloyAnvilRecipe;
import com.devdyna.justdynathings.common.recipes.anvils.ferricore.RepairFerricoreAnvilRecipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zRecipeTypes {

    public static void register(IEventBus bus) {
        SERIALIZERS.register(bus);
        TYPES.register(bus);
    }

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister
            .create(Registries.RECIPE_SERIALIZER, JustDynaThings.MODULE_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES = DeferredRegister.create(Registries.RECIPE_TYPE,
            JustDynaThings.MODULE_ID);

    public static final RecipeRegister<RepairFerricoreAnvilRecipe> FERRICORE_ANVIL = RecipeRegister.of("ferricore_anvil_fuels",()-> RepairFerricoreAnvilRecipe.serializer());
    public static final RecipeRegister<RepairBlazegoldAnvilRecipe> BLAZEGOLD_ANVIL = RecipeRegister.of("blazegold_anvil_fuels",()-> RepairBlazegoldAnvilRecipe.serializer());
    public static final RecipeRegister<RepairEclipseAlloyAnvilRecipe> ECLIPSEALLOY_ANVIL = RecipeRegister.of("eclipsealloy_anvil_fuels",()-> RepairEclipseAlloyAnvilRecipe.serializer());

}
