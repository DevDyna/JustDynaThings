package com.devdyna.justdynathings.utils;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.common.registry.core.builders.clock.ClockBlock;
import com.devdyna.justdynathings.common.registry.types.BlockTags;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuConstructor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class Actions {

        public static void clockUpdate(BlockPos pos, Level level, BlockState state) {
                level.setBlockAndUpdate(pos,
                                state
                                                .setValue(ClockBlock.ACTIVE,
                                                                !state.getValue(ClockBlock.ACTIVE))
                                                .setValue(DirectionUtil.face[0],
                                                                state.getValue(DirectionUtil.face[0]))
                                                .setValue(DirectionUtil.face[1],
                                                                state.getValue(DirectionUtil.face[1]))
                                                .setValue(DirectionUtil.face[2],
                                                                state.getValue(DirectionUtil.face[2]))
                                                .setValue(DirectionUtil.face[3],
                                                                state.getValue(DirectionUtil.face[3]))
                                                .setValue(DirectionUtil.face[4],
                                                                state.getValue(DirectionUtil.face[4]))
                                                .setValue(DirectionUtil.face[5],
                                                                state.getValue(DirectionUtil.face[5])));
        }

        public static void consumeItem(ItemStack item, Level level) {
                if (LevelUtil.chance(Config.REFORGER_CHANCE.get(), level))
                        item.shrink(1);
        }

        public static void consumeItem(ItemStack item, Level level, int chance) {
                if (LevelUtil.chance(chance, level))
                        item.shrink(1);
        }

        public static void consumeItem(ItemStack item, Level level, int chance, int itemcount) {
                if (LevelUtil.chance(chance, level))
                        item.shrink(itemcount);
        }

        public static void reforgerReplaceBlock(BlockPos pos, Level level) {
                level.setBlockAndUpdate(pos,
                                LevelUtil
                                                .ResourceByTag(BlockTags.REFORGER_RESULT,
                                                                LevelUtil.getRandomValue(
                                                                                LevelUtil.getSizeTag(
                                                                                        BlockTags.REFORGER_RESULT),
                                                                                level))
                                                .defaultBlockState());
        }

        public static boolean checkItemBlock(Level level, BlockPos pos, TagKey<Block> b,
                        ItemStack item, TagKey<Item> i) {
                return level.getBlockState(pos).is(b)
                                && item.is(i);
        }

        public static boolean checkItemBlock(Level level, BlockPos pos, TagKey<Block> b,
                        ItemStack item, TagKey<Item> i, boolean itemInvert) {
                return level.getBlockState(pos).is(b)
                                && item.is(i) == itemInvert;
        }

        public static boolean checkItemBlock(Level level, BlockPos pos, TagKey<Block> b, boolean blockInvert,
                        ItemStack item, TagKey<Item> i) {
                return level.getBlockState(pos).is(b) == blockInvert
                                && item.is(i);
        }

        public static boolean checkItemBlock(Level level, BlockPos pos, TagKey<Block> b, boolean blockInvert,
                        ItemStack item, TagKey<Item> i, boolean itemInvert) {
                return level.getBlockState(pos).is(b) == blockInvert
                                && item.is(i) == itemInvert;
        }

        public static void repairItem(ItemStack i) {
                i.setDamageValue(i.getDamageValue() - 1);
        }

        public static void tickWhenRandom(BlockPos pos, Level level) {
                if (level.getBlockState(pos).isRandomlyTicking())
                        level.getBlockState(pos).randomTick((ServerLevel) level, pos, level.random);
        }

        public static void openMenu(Player p, MenuConstructor c, BlockPos pos) {
                p.openMenu(new SimpleMenuProvider(c,
                                Component.translatable("")), (buf -> {
                                        buf.writeBlockPos(pos);
                                }));
        }

        @SuppressWarnings({ "unchecked", "null" })
        public static void tickWhenBE(Level level, BlockPos pos) {

                if(level.getBlockEntity(pos) != null)
{                BlockEntityTicker<BlockEntity> ticker = level.getBlockEntity(pos).getBlockState().getTicker(
                                (ServerLevel) level,
                                (BlockEntityType<BlockEntity>) level.getBlockEntity(pos).getType());
                if (ticker != null) {
                        ticker.tick((ServerLevel) level, pos, level.getBlockEntity(pos).getBlockState(),
                                        level.getBlockEntity(pos));
                }}
        }

}
