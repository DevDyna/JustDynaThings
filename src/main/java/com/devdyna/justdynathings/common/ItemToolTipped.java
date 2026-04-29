package com.devdyna.justdynathings.common;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.init.builder.AdvancedTimeWand;
import com.devdyna.justdynathings.init.builder.GooUpgrader;
import com.devdyna.justdynathings.init.builder.PickerWand;
import com.devdyna.justdynathings.init.builder.StupefyWand;
import com.devdyna.justdynathings.init.builder.SwapperWand;
import com.devdyna.justdynathings.init.builder.ticker.TickerBlock;
import com.devdyna.justdynathings.init.types.zComponents;
import com.direwolf20.justdirethings.common.items.datacomponents.JustDireDataComponents;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

public class ItemToolTipped {
        private static final int OVER_THE_REGISTRY_ID = 1;

        @SubscribeEvent
        public static void main(ItemTooltipEvent event) {

                var item = event.getItemStack();
                var tip = event.getToolTip();

                if (item.getItem() instanceof GooUpgrader)
                        tip.add(OVER_THE_REGISTRY_ID,
                                        Component.translatable(MODULE_ID + "." + Constants.GooUpgraders.base));

                if (item.getItem() instanceof StupefyWand)
                        tip.add(OVER_THE_REGISTRY_ID,
                                        Component.translatable(MODULE_ID + "." + Constants.Wands.Stupefy));

                if (item.getItem() instanceof SwapperWand) {

                        tip.add(Component.translatable(MODULE_ID + "." + Constants.Wands.Swapper));

                        if (item.get(JustDireDataComponents.BOUND_GLOBAL_POS) != null) {
                                tip.add(Component.translatable(MODULE_ID + ".wand.dimension")
                                                .append(Component
                                                                .translatable(
                                                                                item.get(JustDireDataComponents.BOUND_GLOBAL_POS)
                                                                                                .dimension()
                                                                                                .identifier()
                                                                                                .getPath())
                                                                .withStyle(ChatFormatting.GREEN)));
                                tip.add(Component.translatable(MODULE_ID + ".wand.pos")

                                                .append(Component
                                                                .literal("" + item.get(
                                                                                JustDireDataComponents.BOUND_GLOBAL_POS)
                                                                                .pos().getX())
                                                                .withStyle(ChatFormatting.AQUA))

                                                .append(Component
                                                                .literal(" " + item.get(
                                                                                JustDireDataComponents.BOUND_GLOBAL_POS)
                                                                                .pos().getY())
                                                                .withStyle(ChatFormatting.AQUA))

                                                .append(Component
                                                                .literal(" " + item.get(
                                                                                JustDireDataComponents.BOUND_GLOBAL_POS)
                                                                                .pos().getZ())
                                                                .withStyle(ChatFormatting.AQUA)));
                        }
                }

                if (item.getItem() instanceof BlockItem bi && bi.getBlock() instanceof TickerBlock)
                        tip.add(Component.translatable(MODULE_ID + "." + Constants.Blocks.Ticker));

                if (item.getItem() instanceof AdvancedTimeWand) {
                        tip.add(Component.translatable(MODULE_ID + "." + Constants.Wands.AdvancedTime));
                        if (item.get(zComponents.MODE) != null) {
                                var value = AdvancedTimeWand.MODES.list.indexOf(item.get(zComponents.MODE));

                                var normal = Component
                                                .translatable(MODULE_ID + "." + Constants.Wands.AdvancedTime
                                                                + ".mode.normal")
                                                .withStyle((value == 0 ? ChatFormatting.GREEN : ChatFormatting.GRAY));

                                var x2 = Component
                                                .translatable(MODULE_ID + "." + Constants.Wands.AdvancedTime
                                                                + ".mode.x2")
                                                .withStyle((value == 1 ? ChatFormatting.GREEN : ChatFormatting.GRAY));

                                var x4 = Component
                                                .translatable(MODULE_ID + "." + Constants.Wands.AdvancedTime
                                                                + ".mode.x4")
                                                .withStyle((value == 2 ? ChatFormatting.GREEN : ChatFormatting.GRAY));

                                var max = Component
                                                .translatable(MODULE_ID + "." + Constants.Wands.AdvancedTime
                                                                + ".mode.max")
                                                .withStyle((value == 3 ? ChatFormatting.GREEN : ChatFormatting.GRAY));

                                var start = Component.literal("[ ").withStyle(ChatFormatting.GRAY);
                                var mid = Component.literal(" | ").withStyle(ChatFormatting.GRAY);
                                var end = Component.literal(" ]").withStyle(ChatFormatting.GRAY);

                                tip.add(start
                                                .append(normal).append(mid)
                                                .append(x2).append(mid)
                                                .append(x4).append(mid)
                                                .append(max).append(end));

                        }
                }

                if (item.getItem() instanceof PickerWand) {
                        tip.add(Component.translatable(MODULE_ID + "." + Constants.Wands.Picker));

                        if (item.get(zComponents.STATE) != null) {
                                tip.add(Component.translatable(MODULE_ID + ".wand.blockstate")
                                                .append(Component
                                                                .literal(item.get(zComponents.STATE).getBlock()
                                                                                .getName().getString())
                                                                .withStyle(ChatFormatting.GREEN)));
                        }
                }

        }
}