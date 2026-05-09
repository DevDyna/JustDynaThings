package com.devdyna.justdynathings.api;

import java.util.function.ToIntFunction;

import com.devdyna.cakesticklib.api.utils.x;
import com.devdyna.justdynathings.init.types.zBlocks;
import com.devdyna.justdynathings.init.types.zFluids;
import com.devdyna.justdynathings.init.types.zItems;

import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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

//TODO rework to remove not anymore used stuff

/**
 * Utility class to create fluids
 */
@SuppressWarnings("null")
public class FluidRegister {

    // private int color;
    private String id;

    private DeferredHolder<Fluid, BaseFlowingFluid.Source> fluidsource;
    private DeferredHolder<Fluid, FlowingFluid> fluidflowing;
    private DeferredHolder<Item, BucketItem> itemBucket;
    private DeferredHolder<Block, LiquidBlock> block;
    private BaseFlowingFluid.Properties prop;
    private DeferredHolder<FluidType, ?> type;

    private Identifier still;
    // private Identifier flowing;
    // private Identifier overlay;

    private int lightLevel;
    private ToIntFunction<BlockState> dynLightLevel;
    private int viscosity;
    private boolean canDrown;
    private boolean canSwim;
    private boolean canPushEntity;
    private boolean canConvertToSource;

    public FluidRegister(String id) {
        // this.color = color;
        this.id = id;

        this.still = x.rl("minecraft", "block/water_still");
        // this.flowing = x.rl("minecraft", "block/water_flow");
        // this.overlay = x.rl("minecraft", "block/water_overlay");
        this.viscosity = 1000;// approx water
        this.lightLevel = 0;
        this.dynLightLevel = a -> lightLevel;
        this.canDrown = false;
        this.canSwim = false;
        this.canPushEntity = false;
        this.canConvertToSource = false;

        this.type = zFluids.zFluidTypes.register(
                id + "_type",
                p -> new FluidType(FluidType.Properties.create()
                        .lightLevel(lightLevel)
                        .viscosity(viscosity)
                        .canDrown(canDrown)
                        .canSwim(canSwim)
                        .canPushEntity(canPushEntity)
                        .canConvertToSource(canConvertToSource)
                        .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                        .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY))

        );

        this.prop = new BaseFlowingFluid.Properties(this.type, null, null);

        this.fluidsource = zFluids.zFluids.register(id + "_source",
                p -> new BaseFlowingFluid.Source(this.prop));

        this.fluidflowing = zFluids.zFluids.register(id + "_flowing",
                p -> new BaseFlowingFluid.Flowing(this.prop));

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
                                .lightLevel(dynLightLevel)
                                .emissiveRendering((s, g, p) -> lightLevel > 0 || dynLightLevel.applyAsInt(s) > 0)));

        this.prop = new BaseFlowingFluid.Properties(
                this.type,
                this.fluidsource,
                this.fluidflowing)
                .bucket(this.itemBucket)
                .block(this.block);
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

    public DeferredHolder<Item, BucketItem> getItemBucket() {
        return itemBucket;
    }

    public Identifier getStill() {
        return still;
    }

    public DeferredHolder<FluidType, ?> getType() {
        return type;
    }

    public FluidRegister setTextures(Identifier still) {
        this.still = still;
        return this;
    }

    // public FluidRegister setTextures(Identifier still, Identifier flowing) {
    // this.flowing = flowing;
    // return setTextures(still);
    // }

    // public FluidRegister setTextures(Identifier still, Identifier flowing,
    // Identifier overlay) {
    // this.overlay = overlay;
    // return setTextures(still, flowing);
    // }

    public FluidRegister setStillTexture(Identifier rl) {
        this.still = rl;
        return this;
    }

    /**
     * dont work
     */
    public FluidRegister setLight(int l) {
        this.lightLevel = l;
        return this;
    }

    public FluidRegister setLight(ToIntFunction<BlockState> l) {
        this.dynLightLevel = l;
        return this;
    }

    // public FluidRegister setFlowingTexture(Identifier rl) {
    // this.flowing = rl;
    // return this;
    // }

    // public FluidRegister setOverlayTexture(Identifier rl) {
    // this.overlay = rl;
    // return this;
    // }

    public FluidRegister swim() {
        this.canSwim = true;
        return this;
    }

    public FluidRegister convertToSource() {
        this.canConvertToSource = true;
        return this;
    }

    public FluidRegister drown() {
        this.canDrown = true;
        return this;
    }

    public FluidRegister pushEntity() {
        this.canPushEntity = true;
        return this;
    }

    /**
     * Default value: 1000
     */
    public FluidRegister setViscosity(int v) {
        this.viscosity = v;
        return this;
    }

    // public int getColor() {
    // return color;
    // }

    public String getId() {
        return id;
    }

    // public static FluidRegister create(String id, int color) {
    // return new FluidRegister(id, color);
    // }

    // public static FluidRegister create(String id, Color color) {
    // return new FluidRegister(id, color.getRGB());
    // }

    public static FluidRegister create(String id) {
        return new FluidRegister(id);
    }

    @Deprecated
    public static int rgba(float r, float g, float b, float a) {
        return ((int) (a * 255) << 24)
                | ((int) (b * 255) << 16)
                | ((int) (g * 255) << 8)
                | ((int) (r * 255));
    }

    public Fluid getFluid() {
        return getSource().get();
    }

}