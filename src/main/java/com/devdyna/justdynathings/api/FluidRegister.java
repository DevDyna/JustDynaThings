package com.devdyna.justdynathings.api;

import javax.annotation.Nullable;
import java.awt.Color;

import com.devdyna.cakesticklib.api.utils.ColorUtils;
import com.devdyna.justdynathings.init.types.zBlocks;
import com.devdyna.justdynathings.init.types.zFluids;
import com.devdyna.justdynathings.init.types.zItems;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.InsideBlockEffectType;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;

//TODO HEAVILY REWORK
/**
 * Utility class to create fluids
 */
public class FluidRegister {

    private String id;

    private DeferredHolder<Fluid, BaseFlowingFluid.Source> fluidsource;
    private DeferredHolder<Fluid, FlowingFluid> fluidflowing;
    private DeferredHolder<Item, BucketItem> itemBucket;
    private DeferredHolder<Block, LiquidBlock> block;
    private BaseFlowingFluid.Properties prop;
    private DeferredHolder<FluidType, ?> type;

    private int color;

    public FluidRegister(String id, int color, boolean ignite, int lightLevel) {

        this.id = id;
        this.color = color;

        this.type = zFluids.zFluidTypes.register(
                id + "_type",
                p -> new FluidType(FluidType.Properties.create()
                        .lightLevel(lightLevel)
                        .viscosity(1000)
                        .canDrown(true)
                        .isWaterLike(true)
                        .canPushEntity(true)
                        .canConvertToSource(false)
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                        .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY))

        );

        this.prop = new BaseFlowingFluid.Properties(this.type, null, null);

        this.fluidsource = zFluids.zFluids.register(id, p -> new BaseFlowingFluid.Source(this.prop));

        this.fluidflowing = zFluids.zFluids.register(id + "_flowing",
                p -> new BaseFlowingFluid.Flowing(this.prop) {

                    protected void entityInside(Level level, BlockPos pos, Entity entity,
                            InsideBlockEffectApplier effectApplier) {
                        if (ignite) {
                            effectApplier.apply(InsideBlockEffectType.CLEAR_FREEZE);
                            effectApplier.apply(InsideBlockEffectType.LAVA_IGNITE);
                            effectApplier.runAfter(InsideBlockEffectType.LAVA_IGNITE, Entity::lavaHurt);
                        }

                        super.entityInside(level, pos, entity, effectApplier);
                    };

                });

        this.itemBucket = zItems.zBucketItems.registerItem(id + "_bucket",
                p -> new BucketItem(this.fluidsource.get(),
                        p.craftRemainder(Items.BUCKET).stacksTo(1)));

        this.block = zBlocks.zBlockFluids.registerBlock(
                id,
                pr -> new LiquidBlock(this.fluidsource.value(),
                        pr.mapColor(MapColor.WATER).replaceable().noCollision()
                                .strength(100.0F).pushReaction(PushReaction.DESTROY).noLootTable().liquid()
                                .sound(SoundType.EMPTY)
                                .liquid()
                                .lightLevel(_ -> lightLevel)) {

                    protected void entityInside(BlockState state, Level level, BlockPos pos,
                            Entity entity,
                            InsideBlockEffectApplier effectApplier, boolean isPrecise) {

                        if (ignite) {
                            effectApplier.apply(InsideBlockEffectType.CLEAR_FREEZE);
                            effectApplier.apply(InsideBlockEffectType.LAVA_IGNITE);
                            effectApplier.runAfter(InsideBlockEffectType.LAVA_IGNITE, Entity::lavaHurt);
                        }

                        super.entityInside(state, level, pos, entity, effectApplier, isPrecise);
                    };

                });

        var sampleProp = new BaseFlowingFluid.Properties(
                this.type,
                this.fluidsource,
                this.fluidflowing).block(this.block);

        sampleProp = sampleProp
                .bucket(this.itemBucket);

        this.prop = sampleProp;
    }

    public DeferredHolder<Block, LiquidBlock> getBlock() {
        return block;
    }

    public DeferredHolder<Fluid, FlowingFluid> getFlowing() {
        return fluidflowing;
    }

    public DeferredHolder<Fluid, BaseFlowingFluid.Source> getSource() {
        return fluidsource;
    }

    public @Nullable DeferredHolder<Item, BucketItem> getItemBucket() {
        return itemBucket;
    }

    public DeferredHolder<FluidType, ?> getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public int getColor() {
        return color;
    }

    public Fluid getFluid() {
        return getSource().get();
    }

    public static FluidRegister simple(String id, int color) {
        return new FluidRegister(id, color, false, 0);
    }

    public static FluidRegister simple(String id, Color color) {
        return simple(id, ColorUtils.argb(color));
    }

    public static FluidRegister heavy(String id, int color) {
        return new FluidRegister(id, color, false, 0);
    }

    public static FluidRegister heavy(String id, Color color) {
        return heavy(id, ColorUtils.argb(color));
    }

    public static FluidRegister molten(String id, int color) {
        return new FluidRegister(id, color, true, 5);
    }

    public static FluidRegister molten(String id, Color color) {
        return molten(id, ColorUtils.argb(color));
    }

}