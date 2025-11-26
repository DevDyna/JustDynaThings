package com.devdyna.justdynathings.compat.chisel.builder.base;

import java.util.List;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.stream.Collectors;

import com.direwolf20.justdirethings.common.items.interfaces.ToggleableTool;
import com.direwolf20.justdirethings.setup.Registration;
import com.direwolf20.justdirethings.common.items.interfaces.Ability;
import com.direwolf20.justdirethings.common.items.interfaces.AbilityParams;
import com.direwolf20.justdirethings.setup.Config;
import com.direwolf20.justdirethings.util.TooltipHelpers;

import com.leclowndu93150.chisel.item.ItemChisel;

import net.minecraft.world.item.*;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseAbilityChisel extends ItemChisel implements ToggleableTool {

    protected int index;
    protected final EnumSet<Ability> abilities = EnumSet.noneOf(Ability.class);
    protected final Map<Ability, AbilityParams> abilityParams = new EnumMap(Ability.class);

    public BaseAbilityChisel(ChiselType t, Properties p, int index) {
        super(t, p.stacksTo(1));
        this.index = index;
    }

    public BaseAbilityChisel(ChiselType t, Properties p) {
        this(t, p, -1);
    }

    private List<Item> repairItems = List.of(Registration.FerricoreIngot.get(), Registration.BlazegoldIngot.get());

    @Override
    public boolean isValidRepairItem(ItemStack damagedItem, ItemStack repairMaterial) {

        return index == -1
                ? false
                : (repairItems.contains(repairMaterial.getItem())
                        ? repairItems.indexOf(repairMaterial.getItem()) == index
                        : super.isValidRepairItem(damagedItem, repairMaterial));
    }

    public EnumSet<Ability> getAllAbilities() {
        return this.abilities;
    }

    public EnumSet<Ability> getAbilities() {
        return (EnumSet) this.abilities.stream()
                .filter(a -> Config.AVAILABLE_ABILITY_MAP.get(a).get())
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(Ability.class)));
    }

    public Map<Ability, AbilityParams> getAbilityParamsMap() {
        return this.abilityParams;
    }

    public void appendHoverText(ItemStack s, TooltipContext c, List<Component> t, TooltipFlag f) {
        super.appendHoverText(s, c, t, f);
        if (c.level() != null) {
            TooltipHelpers.appendToolEnabled(s, t);
            if (Screen.hasShiftDown())
                TooltipHelpers.appendAbilityList(s, t);
            else
                TooltipHelpers.appendShiftForInfo(s, t);

        }
    }

}
