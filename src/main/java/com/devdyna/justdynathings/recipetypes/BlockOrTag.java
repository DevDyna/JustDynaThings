package com.devdyna.justdynathings.recipetypes;

import java.util.Optional;

import com.devdyna.justdynathings.utils.DataGenUtil;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public sealed interface BlockOrTag permits BlockOrTag.block, BlockOrTag.tag {

        Codec<BlockOrTag> CODEC = Codec.STRING.flatXmap(
                        string -> {
                                if (string.startsWith("#"))
                                        return DataResult.success(new tag(TagKey.create(Registries.BLOCK,
                                                        ResourceLocation.parse(string.substring(1)))));

                                return DataResult.success(
                                                new block(BuiltInRegistries.BLOCK.get(ResourceLocation.parse(string))));
                        },
                        value -> switch (value) {
                                case block block ->
                                        DataResult.success(ResourceLocation
                                                        .fromNamespaceAndPath(DataGenUtil.getMod(block.block()),
                                                                        DataGenUtil.getPath(block.block()))
                                                        .toString());
                                case tag tag -> DataResult.success("#" + tag.tag().location());
                        });

        StreamCodec<RegistryFriendlyByteBuf, BlockOrTag> STREAM_CODEC = new StreamCodec<>() {

                @Override
                public BlockOrTag decode(RegistryFriendlyByteBuf buf) {
                        if (buf.readBoolean())
                                return new tag(TagKey.create(Registries.BLOCK,
                                                ResourceLocation.STREAM_CODEC.decode(buf)));
                        return new block(ByteBufCodecs.registry(Registries.BLOCK).decode(buf));
                }

                @Override
                public void encode(RegistryFriendlyByteBuf buf, BlockOrTag value) {
                        switch (value) {
                                case block block -> {
                                        buf.writeBoolean(false);
                                        ByteBufCodecs.registry(Registries.BLOCK).encode(buf, block.block());
                                }
                                case tag tag -> {
                                        buf.writeBoolean(true);
                                        ResourceLocation.STREAM_CODEC.encode(buf, tag.tag().location());
                                }
                        }
                }
        };

        default Ingredient getAsIngredient(Level level) {
                return switch (this) {
                        case block b -> {
                                var item = b.block().asItem();

                                if (item == Items.AIR)
                                        yield Ingredient.EMPTY;

                                yield Ingredient.of(item);
                        }

                        case tag t -> {
                                var items = level.registryAccess()
                                                .lookupOrThrow(Registries.BLOCK)
                                                .getOrThrow(t.tag())
                                                .stream()
                                                .map(holder -> holder.value().asItem())
                                                .filter(item -> item != Items.AIR)
                                                .toArray(ItemLike[]::new);

                                yield Ingredient.of(items);
                        }
                };
        }

        default Optional<Block> getBlock() {
                return switch (this) {
                        case block b -> Optional.of(b.block());
                        case tag t -> Optional.empty();
                };
        }

        default Optional<TagKey<Block>> getTag() {
                return switch (this) {
                        case block b -> Optional.empty();
                        case tag t -> Optional.of(t.tag());
                };
        }

        // boolean test(Block block);

        default boolean test(BlockState state) {
                if (state == null || state.isAir())
                        return false;
                return switch (this) {
                        case block b -> state.is(b.block());
                        case tag t -> state.is(t.tag());
                };
        }

        default boolean test(Block block) {
                return test(block.defaultBlockState());
        }

        record block(Block block) implements BlockOrTag {

                // @Override
                // public boolean test(Block block) {
                // return block.defaultBlockState().is(this.block);
                // }
        }

        record tag(TagKey<Block> tag) implements BlockOrTag {

                // @Override
                // public boolean test(Block block) {
                // return block.defaultBlockState().is(tag);
                // }
        }

        static BlockOrTag add(Block block) {
                return new block(block);
        }

        static BlockOrTag add(TagKey<Block> tag) {
                return new tag(tag);
        }
}