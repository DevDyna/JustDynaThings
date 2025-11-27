package com.devdyna.justdynathings.registry.builders.paradox_mixer;

import java.util.List;

import com.devdyna.justdynathings.config.CommonConfig;
import com.devdyna.justdynathings.recipetypes.type.ParadoxMixerRecipe;
import com.devdyna.justdynathings.registry.builders.stabilizer.StabilizerBlock;
import com.devdyna.justdynathings.registry.interfaces.be.FluidMachine;
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

    @Override
    public void tickServer() {

        updateBlock();

        for (int i = 0; i < getMachineHandler().getSlots(); i++) {

            var catalyst = getMachineHandler().getStackInSlot(i);

            List<RecipeHolder<ParadoxMixerRecipe>> recipes = level.getRecipeManager()
                    .getAllRecipesFor(zRecipeTypes.PARADOX_MIXER.getType());

            var recipe = recipes.stream().filter(r -> r.value().getCatalyst().test(catalyst)
                    && getFluidStack().is(r.value().getInput().getFluidType())
                    && getFluidStack().getAmount() == r.value().getInput().getAmount()).findFirst();

            if (recipe.isPresent() && getBlockState().getValue(zProperties.GOO_ALIVE)) {

                var fluid = recipe.get().value().getOutput();
                setFluidStack(fluid.getFluid(), fluid.getAmount());
                catalyst.shrink(1);

                if (CommonConfig.PARADOX_MIXER_SOUND_EVENT.get())
                    level.playSound(null, getBlockPos(),
                            SoundEvents.BREWING_STAND_BREW,
                            SoundSource.BLOCKS, (level.random.nextInt(10) + 1) * 0.01F,
                            level.random.nextInt(50) + 1 * 0.01F);

                level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(zProperties.GOO_ALIVE, false));

                break;
            }
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
        if (i <= 0)
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
        return CommonConfig.PARADOX_MIXER_MB_CAPACITY.get();
    }

    @Override
    public int getStandardFluidCost() {
        return 0;
    }

}
