package com.devdyna.justdynathings.api;

import java.util.Map;

import com.devdyna.justdynathings.api.be.EnergyMachine;
import com.mojang.logging.LogUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
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
import net.neoforged.neoforge.transfer.energy.EnergyHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.transaction.Transaction;

public class Actions {

        public static void consumeItem(ItemStack item, Level level, int chance) {
                consumeItem(item, level, chance, 1);
        }

        public static void consumeItem(ItemStack item, Level level, int chance, int itemcount) {
                if (RandomUtil.chance(level, chance))
                        item.shrink(itemcount);
        }

        @Deprecated
        public static boolean checkItemBlock(Level level, BlockPos pos, TagKey<Block> b,
                        ItemStack item, TagKey<Item> i) {
                return level.getBlockState(pos).is(b)
                                && item.is(i);
        }

        @Deprecated
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

        public static void repairItem(ItemStacksResourceHandler h, int slot, ItemResource i, int damage) {
                var stored = Mth.clamp(i.getOrDefault(DataComponents.DAMAGE, 0), 0,
                                i.getOrDefault(DataComponents.MAX_DAMAGE, 0));
                var item = new ItemStack(i.typeHolder(), h.getAmountAsInt(slot), i.getComponentsPatch());

                item.setDamageValue(stored - 1);

                h.set(slot, ItemResource.of(item), h.getAmountAsInt(slot));
        }

        /**
         * @deprecated
         *             use MiscTools.doExtraTicks(ServerLevel, BlockPos, double)
         */
        @Deprecated
        public static void tickWhenRandom(BlockPos pos, Level level) {
                if (level.getBlockState(pos).isRandomlyTicking())
                        level.getBlockState(pos).randomTick((ServerLevel) level, pos, level.getRandom());
        }

        public static void openMenu(Player p, MenuConstructor c, BlockPos pos) {
                try {
                        p.openMenu(new SimpleMenuProvider(c,
                                        Component.translatable("")), (buf -> {
                                                buf.writeBlockPos(pos);
                                        }));
                } catch (Exception e) {
                        LogUtils.getLogger().error("Menu provided at " + pos.toString() + " failed to open!");
                }

        }

        /**
         * @deprecated
         *             use MiscTools.doExtraTicks(ServerLevel, BlockPos, double)
         */
        @Deprecated
        public static void tickWhenBE(Level level, BlockPos pos) {
                var be = level.getBlockEntity(pos);

                if (be == null)
                        return;

                if (be.getType() == null)
                        return;

                BlockEntityTicker<BlockEntity> ticker = be.getBlockState().getTicker(
                                (ServerLevel) level,
                                (BlockEntityType<BlockEntity>) be.getType());

                if (ticker != null)
                        ticker.tick((ServerLevel) level, pos, be.getBlockState(),
                                        be);

        }

        /**
         * Provide power at adjacent be blocks
         * 
         * @param level
         * @param pos   generator blockpos
         * @param map   cache map to store capabilities
         * @param fe    rate
         */
        public static void providePowerAdjacent(Level level, BlockPos pos,
                        Map<Direction, BlockCapabilityCache<EnergyHandler, Direction>> map, int fe) {

                EnergyMachine be = (EnergyMachine) level.getBlockEntity(pos);

                if (be == null)
                        return;

                var invalid = false;

                if (((EnergyMachine) be).canExtractFE())
                        for (Direction dir : Direction.values()) {

                                var cache = map.get(dir);
                                if (cache == null)
                                        cache = BlockCapabilityCache.create(
                                                        Capabilities.Energy.BLOCK,
                                                        (ServerLevel) level,
                                                        pos.relative(dir),
                                                        dir.getOpposite());
                                map.put(dir, cache);

                                EnergyHandler cap = cache.getCapability();
                                if (cap == null)
                                        continue;

                                var extracted = be.extractEnergy(fe, true);

                                if (extracted <= 0 || cap.getAmountAsInt() >= cap.getCapacityAsInt()) {
                                        invalid = true;
                                }

                                if (!invalid) {
                                        var real = be.extractEnergy(fe, false);

                                        try (var tx = Transaction.openRoot()) {

                                                var insered = cap.insert(real, tx);

                                                if (insered <= 0) {
                                                        invalid = true;
                                                        tx.close();
                                                } else
                                                        tx.commit();
                                        }
                                }

                                if (invalid) {
                                        invalid = false;
                                        continue;
                                }
                        }
        }

}