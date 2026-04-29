package com.devdyna.justdynathings.init.builder;

import java.util.List;
import java.util.Optional;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.JustDynaThings;
import com.devdyna.justdynathings.init.types.zComponents;
import com.direwolf20.justdirethings.common.entities.TimeWandEntity;
import com.direwolf20.justdirethings.common.items.TimeWand;
import com.direwolf20.justdirethings.common.items.interfaces.FluidContainingItem;
import com.direwolf20.justdirethings.common.items.interfaces.PoweredItem;
import com.direwolf20.justdirethings.util.MiscTools;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult.Type;
import net.neoforged.neoforge.common.util.FakePlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level;

public class AdvancedTimeWand extends TimeWand {

    public AdvancedTimeWand(Properties p) {
        super(p);
    }

    @Override
    public int getMaxEnergy() {
        return Config.ADVANCED_TIME_WAND_FE_CAPACITY.get();
    }

    @Override
    public int getMaxMB() {
        return Config.ADVANCED_TIME_WAND_MB_CAPACITY.get();
    }


    public class MODES {
        public static String NORMAL = "normal"; // 2 > 4 > ... > 256
        public static String X2 = "x2"; // 4 > 16 > 64 > 256
        public static String X4 = "x4"; // 16 > 256
        public static String MAX = "max";// 256
        public static List<String> list = List.of(NORMAL, X2, X4, MAX);
        public static List<Integer> values = List.of(
                Config.ADVANCED_TIME_WAND_NORMAL_MODE.get(),
                Config.ADVANCED_TIME_WAND_X2_MODE.get(),
                Config.ADVANCED_TIME_WAND_X4_MODE.get(),
                Config.ADVANCED_TIME_WAND_MAX_MODE.get());
    }

    

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        var item = player.getItemInHand(hand);
        var hitResult = getPlayerPOVHitResult(level, player, Fluid.NONE);

        if (!Config.ADVANCED_TIME_WAND_FAKE_PLAYER_ALLOWED.get() && player instanceof FakePlayer)
            return InteractionResult.FAIL;

        if (!item.has(zComponents.MODE))
            resetComponent(level, player, hand);

        if (!MODES.list.contains(item.get(zComponents.MODE)))
            resetComponent(level, player, hand);

        switch (hitResult.getType()) {
            case Type.MISS:
                if (changeMode(level, player, hand, item))
                    return InteractionResult.SUCCESS;

            case Type.BLOCK:
                if (this.spawnEntity(level, player, hitResult.getBlockPos(), item))
                    return InteractionResult.SUCCESS;

            case Type.ENTITY:
            default:
                return super.use(level, player, hand);
        }

    }

    protected boolean changeMode(Level level, Player player, InteractionHand hand, ItemStack item) {

        if (!player.isCrouching())
            return false;

        var mode = item.get(zComponents.MODE);

        player.swing(hand);

        String resultMode = mode;

        if (mode.equals(MODES.MAX))
            resultMode = MODES.NORMAL;
        else
            resultMode = MODES.list.get(MODES.list.indexOf(resultMode) + 1);

        item.set(zComponents.MODE, resultMode);
        message(player, "tip." + resultMode);

        return true;
    }

    public boolean spawnEntity(Level level, Player player, BlockPos pos, ItemStack item) {

        if (level.isClientSide())
            return false;

        if (!MiscTools.isValidTickAccelBlock((ServerLevel) level, level.getBlockState(pos),
                level.getBlockEntity(pos)))
            return false;

        var max = com.direwolf20.justdirethings.setup.Config.logBase2(Config.ADVANCED_TIME_WAND_MAX_MULTIPLIER.get());

        int power = MODES.values.get(MODES.list.indexOf(item.get(zComponents.MODE)));

        if (power > max) {
            message(player, "mode.disabled");
            return false;
        }

        int setRate = power;
        Optional<TimeWandEntity> entity = level.getEntitiesOfClass(TimeWandEntity.class, new AABB(pos))
                .stream().findFirst();

        if (entity.isPresent()) {
            TimeWandEntity timeWandEntity = entity.get();

            int speed = timeWandEntity.getTickSpeed();
            if (speed >= max)
                return false;

            setRate = Math.min(speed + power, max);

            int accelRate = (int) TimeWandEntity.calculateAccelRate(setRate);
            int mb = calculateFluidCost(player, accelRate);
            int fe = calculateFECost(player, accelRate);
            if (hasResources(player, item, fe, mb)) {
                timeWandEntity.setTickSpeed(setRate);
                timeWandEntity.addTime((timeWandEntity.getTotalTime() - timeWandEntity.getRemainingTime()) / 2);
                clickSuccess(player, item, mb, fe, level, pos, setRate);
                return true;
            }
        } else {
            int accelRate = (int) TimeWandEntity.calculateAccelRate(setRate);

            if (accelRate > Config.ADVANCED_TIME_WAND_MAX_MULTIPLIER.get()) {
                message(player, "mode.disabled");
                return false;
            }

            int mb = calculateFluidCost(player, accelRate);
            int fe = calculateFECost(player, accelRate);
            if (hasResources(player, item, fe, mb)) {
                var timeWandEntity = new TimeWandEntity(level, pos);
                timeWandEntity.setTickSpeed(setRate);
                level.addFreshEntity(timeWandEntity);
                clickSuccess(player, item, mb, fe, level, pos, setRate);
                return true;
            }
        }
        return false;
    }

    protected void message(Player player, String type) {
        player.sendOverlayMessage(
                Component.translatable(JustDynaThings.MODULE_ID + "." + Constants.Wands.AdvancedTime
                        + "." + type));
    }

    public static void playTimeWandSound(Level serverLevel, BlockPos pos, int setRate) {
        float pitch = switch (setRate) {
            case 1 -> 0.707107F;
            case 2 -> 0.793701F;
            case 3 -> 0.890899F;
            case 4 -> 0.943874F;
            case 5 -> 1.059463F;
            case 6 -> 1.189207F;
            case 7 -> 1.334840F;
            case 8 -> 1.414214F;
            case 9 -> 1.587401F;
            case 10 -> 1.781797F;
            case 11 -> 1.887749F;
            default -> 1.0F;
        };
        serverLevel.playSound(null, pos, SoundEvents.NOTE_BLOCK_IRON_XYLOPHONE.value(), SoundSource.PLAYERS, 1.0F,
                pitch);
    }

    protected void resetComponent(Level level, Player player, InteractionHand hand) {
        var item = player.getItemInHand(hand);
        player.swing(hand);
        item.set(zComponents.MODE, MODES.NORMAL);

        level.playSound(null, player.getOnPos(),
                SoundEvents.AMETHYST_BLOCK_CHIME,
                SoundSource.BLOCKS, (level.getRandom().nextInt(10) + 1) * 0.01F,
                level.getRandom().nextInt(50) + 1 * 0.01F);

        message(player, "mode.reset");

    }

    protected void clickSuccess(Player p, ItemStack item, int mb, int fe, Level level, BlockPos pos, int rate) {
        FluidContainingItem.consumeFluid(p, item, mb);
        PoweredItem.consumeEnergy(p, item, fe);
        playTimeWandSound(level, pos, rate); // Play sound based on the click count
    }

}
