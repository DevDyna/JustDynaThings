package com.devdyna.justdynathings.registry.builders;

import static com.devdyna.justdynathings.Main.ID;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.DataGenUtil;
import com.direwolf20.justdirethings.common.entities.TimeWandEntity;
import com.direwolf20.justdirethings.common.items.datacomponents.JustDireDataComponents;
import com.direwolf20.justdirethings.common.items.interfaces.Ability;
import com.direwolf20.justdirethings.common.items.interfaces.AbilityMethods;
import com.direwolf20.justdirethings.common.items.interfaces.AbilityParams;
import com.direwolf20.justdirethings.common.items.interfaces.BaseToggleableTool;
import com.direwolf20.justdirethings.common.items.interfaces.LeftClickableTool;
import com.direwolf20.justdirethings.setup.Config;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult.Type;

@SuppressWarnings("null")
public class StabilizerWand extends BaseToggleableTool implements LeftClickableTool {

    protected final EnumSet<Ability> abilities = EnumSet.noneOf(Ability.class);
    protected final Map<Ability, AbilityParams> abilityParams = new EnumMap<>(Ability.class);

    public StabilizerWand() {
        super(zProperties.iProp
                .attributes(

                        ItemAttributeModifiers.builder()
                                .add(Attributes.ENTITY_INTERACTION_RANGE,
                                        new AttributeModifier(DataGenUtil.getResource("entity_interaction_range"), 4,
                                                Operation.ADD_VALUE),
                                        EquipmentSlotGroup.MAINHAND)
                                .build())
                .component(JustDireDataComponents.STUPEFY_TARGETS, new ArrayList<>())
                .stacksTo(1).durability(2048));

        registerAbility(Ability.STUPEFY, new AbilityParams(1, 1, 1, 1, 200, 50));
    }

    @Override
    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int itemSlot,
            boolean isSelected) {
        if ((!getCooldownAbilities().isEmpty())
                && entity instanceof Player player) {
            armorTick(level, player, itemStack);
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        var hitResult = getPlayerPOVHitResult(level, player, Fluid.NONE);
        var pos = hitResult.getBlockPos();
        var item = player.getItemInHand(hand);

        if (player.isShiftKeyDown()) {
            openSettings(player);
            return InteractionResultHolder.success(item);
        }

        if (hitResult.getType() == Type.MISS) {

            if (!level.isClientSide && AbilityMethods.stupefy(level, player, item))
                return InteractionResultHolder.success(item);
        }

        if (hitResult.getType() == Type.BLOCK) {
            Optional<TimeWandEntity> entity = level.getEntitiesOfClass(TimeWandEntity.class, new AABB(pos))
                    .stream().findFirst();

            if (entity.isPresent()) {
                entity.get().setRemainingTime(0);
                return InteractionResultHolder.success(item);
            }

        }

        if (hitResult.getType() == Type.ENTITY) {
            // dont work apparently
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack i, TooltipContext c, List<Component> t,
            TooltipFlag f) {

        t.add(Component.translatable(ID + "." + Constants.Wands.Stabilizer));

        super.appendHoverText(i, c, t, f);

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
