package com.devdyna.justdynathings.registry.builders.budding;

import java.util.function.Function;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.compat.zCompat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;

@SuppressWarnings("null")
public class EchoingBuddingType<BLOCK extends Block, BE extends BlockEntity> {

    private final String id;

    private final DeferredHolder<Block, BLOCK> block;
    private final DeferredHolder<BlockEntityType<?>, BlockEntityType<BE>> be;
    private final DeferredHolder<?, ?> item;

    public EchoingBuddingType(
            String id,
            Function<BlockBehaviour.Properties, BLOCK> blockFactory,
            BlockEntitySupplier<BE> beFactory) {

        this.id = Constants.BuddingType + "_" + id;

        this.block = zCompat.extraBlocks.registerBlock(this.id, blockFactory);

        this.be = zCompat.extraBE.register(
                this.id,
                () -> BlockEntityType.Builder.of(beFactory, this.block.get()).build(null));

        this.item = zCompat.extraItems.registerSimpleBlockItem(this.block);

    }

    public DeferredHolder<Block, BLOCK> block() {
        return block;
    }

    public DeferredHolder<BlockEntityType<?>, BlockEntityType<BE>> blockentity() {
        return be;
    }

    public DeferredHolder<?, ?> item() {
        return item;
    }

    public String id() {
        return id;
    }

    public static <BLOCK extends Block, BE extends BlockEntity> EchoingBuddingType<BLOCK, BE> of(String id,
            Function<BlockBehaviour.Properties, BLOCK> blockFactory,
            BlockEntitySupplier<BE> beFactory) {
        return new EchoingBuddingType<>(id, blockFactory, beFactory);
    }

}