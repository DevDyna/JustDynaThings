package com.devdyna.justdynathings.init.builder.fluid_mixer;

import com.devdyna.justdynathings.api.be.FluidMachine;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.capabilities.JustDireFluidTank;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings({ "null" })
public class SimpleFluidMixerBE extends BaseMachineBE implements FluidMachine {

    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public SimpleFluidMixerBE(BlockEntityType<?> type, BlockPos pos, BlockState b) {
        super(type, pos, b);
        MACHINE_SLOTS = 4;
    }

    public SimpleFluidMixerBE(BlockPos pos, BlockState b) {
        this(zBlockEntities.SIMPLE_FLUID_MIXER.get(), pos, b);
    }

    @Override
    public void tickServer() {

        // TODO logic
        // for (int i = 0; i < getMachineHandler().getSlots(); i++) {

        // var catalyst = getMachineHandler().getStackInSlot(i);

        // List<RecipeHolder<ParadoxMixerRecipe>> recipes = level.getRecipeManager()
        // .getAllRecipesFor(zRecipeTypes.PARADOX_MIXER.getType());

        // var recipe = recipes.stream().filter(r ->
        // r.value().getCatalyst().test(catalyst)
        // && getFluidStack().is(r.value().getInput().getFluidType())
        // && getFluidStack().getAmount() ==
        // r.value().getInput().getAmount()).findFirst();

        // if (recipe.isPresent() && getBlockState().getValue(zProperties.GOO_ALIVE)) {

        // var fluid = recipe.get().value().getOutput();
        // setFluidStack(fluid.getFluid(), fluid.getAmount());
        // catalyst.shrink(1);

        // if (CommonConfig.PARADOX_MIXER_SOUND_EVENT.get())
        // level.playSound(null, getBlockPos(),
        // SoundEvents.BREWING_STAND_BREW,
        // SoundSource.BLOCKS, (level.random.nextInt(10) + 1) * 0.01F,
        // level.random.nextInt(50) + 1 * 0.01F);

        // level.setBlockAndUpdate(getBlockPos(),
        // getBlockState().setValue(zProperties.GOO_ALIVE, false));

        // break;
        // }
        // }
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
        return 1000;// Config.SIMPLE_FLUID_MIXER_MB_CAPACITY.get();
    }

    @Override
    public int getStandardFluidCost() {
        return 0;
    }

}
