package com.devdyna.justdynathings.init.builder;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;

import com.devdyna.cakesticklib.api.utils.x;
import com.devdyna.justdynathings.init.types.zItems;
import com.direwolf20.justdirethings.common.entities.ParadoxEntity;
import com.direwolf20.justdirethings.common.entities.TimeWandEntity;
import com.direwolf20.justdirethings.common.items.datacomponents.JustDireDataComponents;
import com.direwolf20.justdirethings.common.items.interfaces.Ability;
import com.direwolf20.justdirethings.common.items.interfaces.AbilityMethods;
import com.direwolf20.justdirethings.common.items.interfaces.AbilityParams;
import com.direwolf20.justdirethings.common.items.interfaces.BaseToggleableTool;
import com.direwolf20.justdirethings.common.items.interfaces.LeftClickableTool;
import com.direwolf20.justdirethings.setup.Config;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraft.world.phys.Vec3;

@SuppressWarnings("null")
public class StupefyWand extends BaseToggleableTool implements LeftClickableTool {

    protected final EnumSet<Ability> abilities = EnumSet.noneOf(Ability.class);
    protected final Map<Ability, AbilityParams> abilityParams = new EnumMap<>(Ability.class);

    public StupefyWand(Properties p) {
        super(p
                .attributes(
                        ItemAttributeModifiers.builder()
                                .add(Attributes.ENTITY_INTERACTION_RANGE,
                                        new AttributeModifier(
                                                x.mcLoc("entity_interaction_range"),
                                                4,
                                                Operation.ADD_VALUE),
                                        EquipmentSlotGroup.MAINHAND)
                                .build())
                .component(JustDireDataComponents.STUPEFY_TARGETS, new ArrayList<>())
                .stacksTo(1)
                .durability(2048));

        registerAbility(Ability.STUPEFY,
                new AbilityParams(1, 1, 1, 1, 20, 10));
    }

    @Override
    public void inventoryTick(
            ItemStack itemStack,
            ServerLevel level,
            Entity owner,
            @Nullable EquipmentSlot slot) {

        if ((!getCooldownAbilities().isEmpty())
                && owner instanceof Player player) {

            armorTick(level, player, itemStack);
        }
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide())
            return InteractionResult.SUCCESS;

        var from = player.getEyePosition();

        var to = from.add(
                player.calculateViewVector(
                        player.getXRot(),
                        player.getYRot())
                        .scale(player.blockInteractionRange()));

        var hitResult = level.clip(new ClipContext(
                from,
                to,
                ClipContext.Block.OUTLINE,
                ClipContext.Fluid.NONE,
                player));

        var center = hitResult.getType() != Type.MISS ? Vec3.atCenterOf(hitResult.getBlockPos()) : to;

        for (Entity entity : level.getEntities(player, new AABB(center, center).inflate(1))) {

            if (entity instanceof Player)
                continue;

            if (entity instanceof TimeWandEntity time) {
                time.setRemainingTime(0);
                return InteractionResult.SUCCESS;
            }

            if (entity instanceof ParadoxEntity paradox) {

                paradox.remove(RemovalReason.KILLED);

                ItemEntity itemEntity = new ItemEntity(
                        level,
                        paradox.getX(),
                        paradox.getY(),
                        paradox.getZ(),
                        x.item(zItems.ABSTRACT_PARADOX.get()));

                itemEntity.setNoGravity(true);
                itemEntity.setGlowingTag(true);
                itemEntity.setDeltaMovement(0,0,0);

                level.addFreshEntity(itemEntity);

                return InteractionResult.SUCCESS;
            }
        }

        if (player.isShiftKeyDown()) {
            openSettings(player);
            return InteractionResult.SUCCESS;
        }

        if (AbilityMethods.stupefy(level, player, player.getItemInHand(hand)))
            return InteractionResult.SUCCESS;

        return super.use(level, player, hand);
    }

    @Override
    public EnumSet<Ability> getAllAbilities() {
        return abilities;
    }

    @Override
    public EnumSet<Ability> getAbilities() {
        return abilities.stream()
                .filter(ability -> Config.AVAILABLE_ABILITY_MAP.get(ability).get())
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(Ability.class)));
    }

    @Override
    public Map<Ability, AbilityParams> getAbilityParamsMap() {
        return abilityParams;
    }
}