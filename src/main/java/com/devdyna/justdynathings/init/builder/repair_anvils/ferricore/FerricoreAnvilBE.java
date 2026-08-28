package com.devdyna.justdynathings.init.builder.repair_anvils.ferricore;

import java.util.Optional;

import com.devdyna.cakesticklib.api.recipe.recipeInput.ItemInput;
import com.devdyna.justdynathings.Config;
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

    private int totalToRepair = 0;

    @Override
    public Optional<RecipeHolder<RepairFerricoreAnvilRecipe>> getRecipe() {
        return level.getServer().getRecipeManager().getRecipeFor(
                zRecipeTypes.FERRICORE_ANVIL.getType(),
                ItemInput.simple.of(getMachineHandler().getResource(1).toStack()), level);
    }

    @Override
    public void onToolValid() {

        if (totalToRepair > 0) {

            if (ignoreDelay()) {
                repair(totalToRepair);
                totalToRepair = 0;
            } else {
                repair(1);
                totalToRepair--;
            }

            return;
        }

        processRecipe();
    }

    @Override
    public void onRecipeValid(RepairFerricoreAnvilRecipe recipe) {
        totalToRepair = recipe.getDurability();

        getMachineHandler().set(1, getMachineHandler().getResource(1), getMachineHandler().getAmountAsInt(1) - 1);

        if (ignoreDelay()) {
            repair(totalToRepair);
            totalToRepair = 0;
        }
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
    public Boolean ignoreDelay() {
        return Config.ANVIL_FERRICORE_IGNORE_DELAY.get();
    }
}