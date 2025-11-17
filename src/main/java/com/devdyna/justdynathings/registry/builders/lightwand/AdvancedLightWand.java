package com.devdyna.justdynathings.registry.builders.lightwand;

import com.devdyna.justdynathings.registry.types.zBlocks;
import com.direwolf20.justdirethings.common.items.interfaces.BasePoweredItem;
import com.direwolf20.justdirethings.common.items.interfaces.PoweredItem;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.LightBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluids;

@SuppressWarnings("null")
public class AdvancedLightWand extends BasePoweredItem implements PoweredItem {

    public AdvancedLightWand() {
        super(new Item.Properties()
                .stacksTo(1));
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity entity,
            InteractionHand hand) {
        // TODO config disable
        // TODO config Fakeplayers
        if (PoweredItem.hasEnoughEnergy(itemStack, getFECostAtUse()))
            if (!entity.hasEffect(MobEffects.GLOWING)) {
                entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 400));

                player.level().playSound(player, player.getOnPos(), SoundEvents.ALLAY_ITEM_GIVEN, SoundSource.PLAYERS,
                        0.25F, 1F);

                PoweredItem.consumeEnergy(itemStack, getFECostAtUse());

                return InteractionResult.SUCCESS;
            }
        return super.interactLivingEntity(itemStack, player, entity, hand);
    }

    @Override
    public InteractionResult useOn(UseOnContext c) {
        var level = c.getLevel();
        var pos = c.getClickedPos();
        var dir = c.getClickedFace();
        var player = c.getPlayer();
        var item = c.getItemInHand();
        var offset = pos.relative(dir);
        var hand = c.getHand();
        // TODO config disable
        // TODO config Fakeplayers
        if (PoweredItem.hasEnoughEnergy(item, getFECostAtUse()))
            if (player.isCrouching() && level.getBlockState(pos).is(zBlocks.LIGHT_WAND_BLOCK.get())) {
                level.setBlock(pos,
                        level.getBlockState(pos).setValue(LightBlock.LEVEL,
                                level.getBlockState(pos).getValue(LightBlock.LEVEL) == 0 ? 15
                                        : level.getBlockState(pos).getValue(LightBlock.LEVEL) - 1),
                        2);
                player.swing(hand);
            } else if (level.getBlockState(offset).canBeReplaced()
                    && !level.getBlockState(offset).is(zBlocks.LIGHT_WAND_BLOCK.get())) {
                if (!player.isCreative()) {
                    PoweredItem.consumeEnergy(item, getFECostAtUse());
                }

                var fluid = level.getFluidState(offset);
                level.setBlockAndUpdate(offset, zBlocks.LIGHT_WAND_BLOCK.get().defaultBlockState()
                        .setValue(BlockStateProperties.WATERLOGGED,
                                !fluid.isEmpty() && fluid.isSource() && fluid.is(Fluids.WATER)));

                return InteractionResult.SUCCESS;
            }

        return super.useOn(c);

    }

    public static int getFECostAtUse() {
        return 100;// TODO config
    }

}
