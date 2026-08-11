package com.devdyna.justdynathings.registry.builders.paradox_mixer;

import java.util.List;

import com.devdyna.justdynathings.api.aspects.FluidMachine;
import com.devdyna.justdynathings.config.ServerConfig;
import com.devdyna.justdynathings.recipetypes.type.ParadoxMixerRecipe;
import com.devdyna.justdynathings.registry.builders.stabilizer.StabilizerBlock;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.registry.types.zRecipeTypes;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.setup.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

@SuppressWarnings({ "null" })
public class ParadoxMixerBE extends BaseMachineBE
        implements FluidMachine {

    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public ParadoxMixerBE(BlockEntityType<?> type, BlockPos pos, BlockState b) {
        super(type, pos, b);
        MACHINE_SLOTS = 4;
    }

    public ParadoxMixerBE(BlockPos pos, BlockState b) {
        this(zBlockEntities.PARADOX_MIXER.get(), pos, b);
    }

    // TODO HOTFIX : port 26.1

    @Override
    public void tickServer() {

        updateBlock();

        if (!getBlockState().getValue(zProperties.GOO_ALIVE))
            return;

        var fluid = getFluidStack();

        if (fluid.isEmpty())
            return;

        List<RecipeHolder<ParadoxMixerRecipe>> recipes = level.getRecipeManager()
                .getAllRecipesFor(zRecipeTypes.PARADOX_MIXER.getType());

        for (RecipeHolder<ParadoxMixerRecipe> h : recipes) {

            var recipe = h.value();

            if (!fluid.is(recipe.getInput().getFluidType()))
                continue;

            var required = recipe.getInput().getAmount();
            var tank = fluid.getAmount();

            if (tank % required != 0)
                continue;

            var multiplier = tank / required;

            if (multiplier <= 0)
                continue;

            var catalysts = 0;

            for (var i = 0; i < getMachineHandler().getSlots(); i++) {
                var slot = getMachineHandler().getStackInSlot(i);
                if (recipe.getCatalyst().test(slot))
                    catalysts += slot.getCount();
            }

            if (catalysts < multiplier)
                continue;

            int remaining = multiplier;

            for (var i = 0; i < getMachineHandler().getSlots(); i++) {

                if (remaining <= 0)
                    break;

                var item = getMachineHandler().getStackInSlot(i);

                if (!recipe.getCatalyst().test(item))
                    continue;

                var taken = Math.min(item.getCount(), remaining);

                item.shrink(taken);
                remaining -= taken;
            }

            var output = recipe.getOutput();

            setFluidStack(
                    output.getFluid(),
                    output.getAmount() * multiplier);

            if (ServerConfig.PARADOX_MIXER_SOUND_EVENT.get()) {
                level.playSound(
                        null,
                        getBlockPos(),
                        SoundEvents.BREWING_STAND_BREW,
                        SoundSource.BLOCKS,
                        (level.random.nextInt(10) + 1) * 0.01F,
                        (level.random.nextInt(50) + 1) * 0.01F);
            }

            level.setBlockAndUpdate(
                    getBlockPos(),
                    getBlockState().setValue(zProperties.GOO_ALIVE, false));

            break;
        }
    }

    public void updateBlock() {
        int i = 0;
        for (Direction dir : Direction.values()) {
            var relative = level.getBlockState(getBlockPos().relative(dir));
            if (relative.getBlock() instanceof StabilizerBlock)
                if (relative.getValue(BlockStateProperties.FACING).equals(dir)
                        && relative.getValue(zProperties.ENERGIZED))
                    i++;
        }
        if (i <= 0 && getBlockState().getValue(zProperties.GOO_ALIVE))
            level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(zProperties.GOO_ALIVE, false));

    }

    @Override
    public ContainerData getFluidContainerData() {
        return fluidContainerData;
    }

    @Override
    public FluidTank getFluidTank() {
        return getData(Registration.MACHINE_FLUID_HANDLER);
    }

    @Override
    public int getMaxMB() {
        return ServerConfig.PARADOX_MIXER_MB_CAPACITY.get();
    }

    @Override
    public int getStandardFluidCost() {
        return 0;
    }

    public boolean canProcess() {
        return getBlockState().getValue(zProperties.GOO_ALIVE);
    }

}
