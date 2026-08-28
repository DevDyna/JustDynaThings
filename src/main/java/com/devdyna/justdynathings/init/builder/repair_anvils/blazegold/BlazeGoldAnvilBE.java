package com.devdyna.justdynathings.init.builder.repair_anvils.blazegold;

import java.util.Optional;

import com.devdyna.cakesticklib.api.recipe.recipeInput.FluidInput;
import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.be.FluidMachine;
import com.devdyna.justdynathings.api.repair_anvils.AnvilRecipeHandler;
import com.devdyna.justdynathings.api.repair_anvils.FunctionalAnvilBE;
import com.devdyna.justdynathings.common.recipes.anvils.blazegold.RepairBlazegoldAnvilRecipe;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.devdyna.justdynathings.init.types.zItemTags;
import com.devdyna.justdynathings.init.types.zRecipeTypes;

import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.capabilities.JustDireFluidTank;
import com.direwolf20.justdirethings.setup.JDTRegistration;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BlazeGoldAnvilBE extends FunctionalAnvilBE
        implements FluidMachine, AnvilRecipeHandler<RepairBlazegoldAnvilRecipe> {

    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public BlazeGoldAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        this.MACHINE_SLOTS = 1;
    }

    public BlazeGoldAnvilBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.BLAZEGOLD_ANVIL.get(), pos, state);
    }

    @Override
    public ContainerData getFluidContainerData() {
        return fluidContainerData;
    }

    @Override
    public JustDireFluidTank getFluidTank() {
        return getData(JDTRegistration.MACHINE_FLUID_HANDLER);
    }

    @Override
    public int getMaxMB() {
        return Config.ANVILS_BLAZEGOLD_MB_CAPACITY.get();
    }

    @Override
    public int getStandardFluidCost() {
        return 0;
    }

    @Override
    public void onToolValid() {
        processRecipe();
    }

    @Override
    public TagKey<Item> getDenyTag() {
        return zItemTags.BLAZEGOLD_ANVIL_DENY;
    }

    @Override
    public Boolean getSoundConfig() {
        return Config.ANVIL_BLAZEGOLD_SOUND_EVENT.get();
    }

    @Override
    public Optional<RecipeHolder<RepairBlazegoldAnvilRecipe>> getRecipe() {
        return level.getServer().getRecipeManager().getRecipeFor(
                zRecipeTypes.BLAZEGOLD_ANVIL.getType(),
                FluidInput.simple.of(getFluidTank().getResource(0).toStack(getAmountStored())), level);
    }

    @Override
    public void onRecipeValid(RepairBlazegoldAnvilRecipe recipe) {

        int recipeCost = recipe.getInput().amount();

        if (recipeCost <= 0)
            return;

        int toolDamage = getToolDamage();

        if (toolDamage <= 0)
            return;

        if (!ignoreDelay()) {

            if (getAmountStored() < recipeCost)
                return;

            int repairAmount = Math.min(recipe.getDurability(), toolDamage);

            extractMBWhenPossible(recipeCost);
            repair(repairAmount);

            return;
        }

        int operations = getAmountStored() / recipeCost;

        if (operations <= 0)
            return;

        int repairAmount = Math.min(operations * recipe.getDurability(), toolDamage);

        if (repairAmount <= 0)
            return;

        extractMBWhenPossible((int) Math.ceil((double) repairAmount / recipe.getDurability()) * recipeCost);
        repair(repairAmount);
    }

    @Override
    public Boolean ignoreDelay() {
        return Config.ANVIL_BLAZEGOLD_IGNORE_DELAY.get();
    }
}