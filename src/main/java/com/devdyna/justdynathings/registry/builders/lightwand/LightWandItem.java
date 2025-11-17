package com.devdyna.justdynathings.registry.builders.lightwand;

import com.devdyna.justdynathings.registry.types.zBlocks;

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

@SuppressWarnings("null")
public class LightWandItem extends Item {

    public LightWandItem() {
        super(new Item.Properties().durability(128).stacksTo(1));
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity entity,
            InteractionHand hand) {

        if (!entity.hasEffect(MobEffects.GLOWING)) {
            entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200));

            player.level().playSound(player, player.getOnPos(), SoundEvents.ALLAY_ITEM_GIVEN, SoundSource.PLAYERS,
                    0.25F, 1F);

            itemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            player.getCooldowns().addCooldown(this, 20);

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

        if (level.getBlockState(offset).canBeReplaced()) {
            if (!player.isCreative()) {
                if (item.getMaxDamage() - item.getDamageValue() == 1) {
                    item.shrink(1);
                    player.playSound(SoundEvents.ITEM_BREAK);
                } else
                    item.setDamageValue(item.getDamageValue() + 1);
            }

            level.setBlockAndUpdate(offset, zBlocks.LIGHT_WAND_BLOCK.get().defaultBlockState());

            return InteractionResult.SUCCESS;
        }

        return super.useOn(c);

    }

}
