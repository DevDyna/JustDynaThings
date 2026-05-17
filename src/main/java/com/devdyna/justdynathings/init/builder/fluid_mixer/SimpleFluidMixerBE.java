package com.devdyna.justdynathings.init.builder.fluid_mixer;

import com.devdyna.cakesticklib.api.utils.x;
import com.devdyna.justdynathings.api.be.FluidMachine;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.RedstoneControlledBE;
import com.direwolf20.justdirethings.common.capabilities.JustDireFluidTank;
import com.direwolf20.justdirethings.datagen.recipes.FluidDropRecipe;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.direwolf20.justdirethings.util.interfacehelpers.RedstoneControlData;

import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings({ "null" })
public class SimpleFluidMixerBE extends BaseMachineBE implements RedstoneControlledBE, FluidMachine {

    public final FluidContainerData fluidContainerData = new FluidContainerData(this);
    public final RedstoneControlData redstoneControlData = new RedstoneControlData();

    public SimpleFluidMixerBE(BlockEntityType<?> type, BlockPos pos, BlockState b) {
        super(type, pos, b);
        MACHINE_SLOTS = 1;
    }

    public SimpleFluidMixerBE(BlockPos pos, BlockState b) {
        this(zBlockEntities.SIMPLE_FLUID_MIXER.get(), pos, b);
    }

    @Override
    public void tickServer() {
        super.tickServer();

        if (!isActiveRedstone())
            return;

        var item = getMachineHandler().getResource(0);

        if (canExtractMB())
            for (RecipeHolder<FluidDropRecipe> r : level.getServer().getRecipeManager().recipeMap()
                    .byType(JDTRegistration.FLUID_DROP_RECIPE_TYPE.get())) {

                var recipe = r.value();

                if (recipe.matches(getFluidStack().getFluid().defaultFluidState().createLegacyBlock(),
                        x.item(item.getItem()))) {
                    if (recipe.getOutput().getBlock() instanceof LiquidBlock liquid) {
                        setFluidStack(liquid.fluid, 1000);
                        getMachineHandler().set(0, item,
                                getMachineHandler().getAmountAsInt(0) - 1);
                        break;
                    }
                }

            }

    }

    @Override
    public ContainerData getFluidContainerData() {
        return fluidContainerData;
    }

    @Override
    public RedstoneControlData getRedstoneControlData() {
        return redstoneControlData;
    }

    @Override
    public BlockEntity getBlockEntity() {
        return this;
    }

    @Override
    public JustDireFluidTank getFluidTank() {
        return getData(JDTRegistration.MACHINE_FLUID_HANDLER);
    }

    @Override
    public int getMaxMB() {
        return 1000;
    }

    @Override
    public int getStandardFluidCost() {
        return 0;
    }

}
