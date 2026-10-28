package com.devdyna.justdynathings.compat.chisel.api;

import java.util.List;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.jspecify.annotations.NonNull;

import com.direwolf20.justdirethings.common.items.interfaces.ToggleableTool;
import com.devdyna.cakesticklib.api.utils.ClientUtils;
import com.direwolf20.justdirethings.common.items.interfaces.Ability;
import com.direwolf20.justdirethings.common.items.interfaces.AbilityParams;
import com.direwolf20.justdirethings.common.items.interfaces.PoweredItem;
import com.direwolf20.justdirethings.setup.Config;
import com.direwolf20.justdirethings.util.TooltipHelpers;
import io.github.chiselteam.chisel.item.ChiselItem;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.network.chat.Component;

public abstract class BaseAbilityChisel extends ChiselItem implements ToggleableTool {

   protected final EnumSet<Ability> abilities = EnumSet.noneOf(Ability.class);
   protected final Map<Ability, AbilityParams> abilityParams = new EnumMap<>(Ability.class);

   public BaseAbilityChisel(Properties p) {
      super(p.stacksTo(1));
   }

   @Override
   public EnumSet<Ability> getAllAbilities() {
      return this.abilities;
   }

   @Override
   public EnumSet<Ability> getAbilities() {
      return this.abilities.stream()
            .filter(a -> Config.AVAILABLE_ABILITY_MAP.get(a).get())
            .collect(Collectors.toCollection(() -> EnumSet.noneOf(Ability.class)));
   }

   @Override
   public Map<Ability, AbilityParams> getAbilityParamsMap() {
      return this.abilityParams;
   }

   @Override
   public void appendHoverText(@NonNull ItemStack s, Item.@NonNull TooltipContext c, @NonNull TooltipDisplay t,
         @NonNull Consumer<Component> b, @NonNull TooltipFlag f) {
      super.appendHoverText(s, c, t, b, f);

      if (c.level() == null)
         return;
      List<Component> l = new ArrayList<>();

      if (s.getItem() instanceof PoweredItem)
         TooltipHelpers.appendFEText(s, l);

      TooltipHelpers.appendToolEnabled(s, l);
      if (ClientUtils.hasShiftDown())
         TooltipHelpers.appendAbilityList(s, l);
      else
         TooltipHelpers.appendShiftForInfo(s, l);
      l.forEach(b);
   }

}
