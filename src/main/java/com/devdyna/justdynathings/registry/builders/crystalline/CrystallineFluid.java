package com.devdyna.justdynathings.registry.builders.crystalline;

import com.devdyna.justdynathings.registry.types.Blocks;
import com.devdyna.justdynathings.registry.types.FluidTypes;
import com.devdyna.justdynathings.registry.types.Fluids;
import com.devdyna.justdynathings.registry.types.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public abstract class CrystallineFluid extends BaseFlowingFluid {

    public static final Properties P = new Properties(
            FluidTypes.CRYSTALLINE_FLUID_TYPE,
            Fluids.CRYSTALLINE_FLOWING,
            Fluids.CRYSTALLINE_SOURCE
    ).bucket(Items.CRYSTALLINE_FLUID_BUCKET)
    .block(Blocks.CRYSTALLINE_FLUID_BLOCK);

    protected CrystallineFluid(Properties p) {
        super(p);
    }

    @Override
    public Fluid getFlowing() {
        return Fluids.CRYSTALLINE_FLOWING.get();
    }

    @Override
    public Fluid getSource() {
        return Fluids.CRYSTALLINE_SOURCE.get();
    }

    @Override
    public Item getBucket() {
        return Items.CRYSTALLINE_FLUID_BUCKET.get();
    }

    @SuppressWarnings("null")
    @Override
    protected boolean canConvertToSource(Level l) {
        return false;
    }

    public static class Flowing extends CrystallineFluid {
        public Flowing() {
            super(P);
        }

        @Override
        @SuppressWarnings("null")
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> b) {
            super.createFluidStateDefinition(b);
            b.add(LEVEL);
        }

        @Override
        @SuppressWarnings("null")
        public int getAmount(FluidState s) {
            return s.getValue(LEVEL);
        }

        @Override
        @SuppressWarnings("null")
        public boolean isSource(FluidState s) {
            return false;
        }
    }

    public static class Source extends CrystallineFluid {
        public Source() {
            super(P);
        }

        @Override
        @SuppressWarnings("null")
        public int getAmount(FluidState s) {
            return 8;
        }

        @Override
        @SuppressWarnings("null")
        public boolean isSource(FluidState s) {
            return true;
        }
    }
}
