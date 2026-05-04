package com.devdyna.justdynathings.init.builder.repair_anvils.ferricore;

import java.util.Optional;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.inputs.ItemFuelInput;
import com.devdyna.justdynathings.api.repair_anvils.AnvilRecipeHandler;
import com.devdyna.justdynathings.api.repair_anvils.FunctionalAnvilBE;
import com.devdyna.justdynathings.common.recipes.anvils.ferricore.RepairFerricoreAnvilRecipe;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.devdyna.justdynathings.init.types.zItemTags;
import com.devdyna.justdynathings.init.types.zRecipeTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class FerricoreAnvilBE extends FunctionalAnvilBE implements AnvilRecipeHandler<RepairFerricoreAnvilRecipe> {

    public FerricoreAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        this.MACHINE_SLOTS = 2;
    }

    public FerricoreAnvilBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.FERRICORE_ANVIL.get(), pos, state);
    }


    @Override
    public Optional<RecipeHolder<RepairFerricoreAnvilRecipe>> getRecipe() {
        var catalyst = getMachineHandler().getResource(1);
        return level.getServer().getRecipeManager().getRecipeFor(
                zRecipeTypes.FERRICORE_ANVIL.getType(),
                new ItemFuelInput(catalyst.toStack()),
                level);
    }

    @Override
    public void onRecipeValid(RepairFerricoreAnvilRecipe recipe) {
        var catalyst = getMachineHandler().getResource(1);
        getMachineHandler().set(1, catalyst,
                getMachineHandler().getAmountAsInt(1) - 1);
    }

    @Override
    public TagKey<Item> getDenyTag() {
        return zItemTags.FERRICORE_ANVIL_DENY;
    }

    @Override
    public Boolean getSoundConfig() {
        return Config.ANVIL_FERRICORE_SOUND_EVENT.get();
    }

    @Override
    public void whenToolValid() {
        processRecipe();
    }

    @Override
    public Boolean ignoreDelay() {
        return Config.ANVIL_FERRICORE_IGNORE_DELAY.get();
    }

}