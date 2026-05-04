package com.devdyna.justdynathings.init.builder.repair_anvils.eclipsealloy;

import java.util.Optional;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.be.FluidMachine;
import com.devdyna.justdynathings.api.inputs.FluidFuelInput;
import com.devdyna.justdynathings.api.repair_anvils.AnvilRecipeHandler;
import com.devdyna.justdynathings.api.repair_anvils.FunctionalAnvilBE;
import com.devdyna.justdynathings.common.recipes.anvils.eclipsealloy.RepairEclipseAlloyAnvilRecipe;
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
import net.neoforged.neoforge.transfer.fluid.FluidResource;

public class EclipseAlloyAnvilBE extends FunctionalAnvilBE
        implements FluidMachine, AnvilRecipeHandler<RepairEclipseAlloyAnvilRecipe> {

    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public EclipseAlloyAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        this.MACHINE_SLOTS = 1;
    }

    public EclipseAlloyAnvilBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.ECLIPSEALLOY_ANVIL.get(), pos, state);
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
        return Config.ANVILS_ECLIPSEALLOY_MB_CAPACITY.get();
    }

    @Override
    public int getStandardFluidCost() {
        return 0;
    }

    @Override
    public void whenToolValid() {
        processRecipe();
    }

    @Override
    public TagKey<Item> getDenyTag() {
        return zItemTags.ECLIPSE_ALLOY_ANVIL_DENY;
    }

    @Override
    public Boolean getSoundConfig() {
        return Config.ANVIL_ECLIPSEALLOY_SOUND_EVENT.get();
    }

    private FluidResource tank = getFluidTank().getResource(0);

    @Override
    public Optional<RecipeHolder<RepairEclipseAlloyAnvilRecipe>> getRecipe() {
        return level.getServer().getRecipeManager().getRecipeFor(
                zRecipeTypes.ECLIPSEALLOY_ANVIL.getType(),
                new FluidFuelInput(tank.toStack(getAmountStored())),
                level);
    }

    @Override
    public void onRecipeValid(RepairEclipseAlloyAnvilRecipe recipe) {
        extractMBWhenPossible(recipe.getInput().amount());
    }

    @Override
    public Boolean ignoreDelay() {
        return Config.ANVIL_ECLIPSEALLOY_IGNORE_DELAY.get();
    }
}