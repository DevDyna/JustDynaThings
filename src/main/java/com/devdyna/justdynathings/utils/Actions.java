package com.devdyna.justdynathings.utils;

import java.util.Map;

import com.devdyna.justdynathings.config.common;
import com.devdyna.justdynathings.registry.interfaces.be.EnergyMachine;
import com.devdyna.justdynathings.registry.types.zBlockTags;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.neoforged.neoforge.capabilities.BlockCapabilityCache;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;

@SuppressWarnings("null")
public class Actions {

        /**
         * ONLY REFORGER
         */
        public static void consumeItem(ItemStack item, Level level) {
                if (LevelUtil.chance(common.REFORGER_CHANCE.get(), level))
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
                                                .ResourceByTag(zBlockTags.REFORGER_RESULT,
                                                                LevelUtil.getRandomValue(
                                                                                LevelUtil.getSizeTag(
                                                                                                zBlockTags.REFORGER_RESULT),
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
                repairItem(i, 1);
        }

        public static void repairItem(ItemStack i, int damage) {
                i.setDamageValue(i.getDamageValue() - damage);
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

        @SuppressWarnings({ "unchecked" })
        public static void tickWhenBE(Level level, BlockPos pos) {

                if (level.getBlockEntity(pos) != null) {
                        BlockEntityTicker<BlockEntity> ticker = level.getBlockEntity(pos).getBlockState().getTicker(
                                        (ServerLevel) level,
                                        (BlockEntityType<BlockEntity>) level.getBlockEntity(pos).getType());
                        if (ticker != null) {
                                ticker.tick((ServerLevel) level, pos, level.getBlockEntity(pos).getBlockState(),
                                                level.getBlockEntity(pos));
                        }
                }
        }

        /**
         * Provide power at adjacent be blocks
         * 
         * @param level
         * @param pos generator blockpos
         * @param map cache map to store capabilities
         * @param fe rate
         */
        public static void providePowerAdjacent(Level level, BlockPos pos,
                        Map<Direction, BlockCapabilityCache<IEnergyStorage, Direction>> map, int fe) {

                var be = level.getBlockEntity(pos);

                if (be == null)
                        return;

                if (((EnergyMachine) be).canExtractFE())
                        for (Direction dir : Direction.values()) {

                                var cache = map.get(dir);
                                if (cache == null)
                                        cache = BlockCapabilityCache.create(
                                                        Capabilities.EnergyStorage.BLOCK,
                                                        (ServerLevel) level,
                                                        pos.relative(dir),
                                                        dir.getOpposite());
                                map.put(dir, cache);

                                IEnergyStorage cap = cache.getCapability();
                                if (cap == null)
                                        continue;
                                int simOn = cap.receiveEnergy(fe * 10, true);
                                if (simOn <= 0)
                                        continue;
                                cap.receiveEnergy(((PoweredMachineBE) be).extractEnergy(simOn, false), false);
                        }
        }

}
