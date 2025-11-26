package com.devdyna.justdynathings.registry.builders.solar.blazegold;

import java.util.List;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.ConfigCommon;
import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.client.type.solarGen.blazegold.BlazegoldSolarPanelGUI;
import com.devdyna.justdynathings.registry.builders.solar.SolarBlockBase;
import com.devdyna.justdynathings.utils.Actions;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlazeGoldSolarBlock extends SolarBlockBase {

        public BlazeGoldSolarBlock() {
                super();
        }

        @Nullable
        @Override
        public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
                return new BlazeGoldSolarBE(pos, state);
        }

        @Override
        public boolean isValidBE(BlockEntity be) {
                return be instanceof BlazeGoldSolarBE;
        }

        @Override
        public void openMenu(Player p, BlockPos b) {
                Actions.openMenu(p, (w, i, e) -> new BlazegoldSolarPanelGUI(w, i, b), b);
        }

        @Override
        public void appendHoverText(ItemStack s, TooltipContext c, List<Component> t,
                        TooltipFlag f) {
                super.appendHoverText(s, c, t, f);
                if (Screen.hasShiftDown()) {
                        t.add(Component.translatable(Main.ID + "." + Constants.SolarPanelType + ".ferate")
                                        .append(Component.literal("" + ConfigCommon.SOLARPANEL_BLAZEGOLD_FE_RATE.get())));
                } else
                        t.add(Component.translatable("justdirethings.shiftmoreinfo").withStyle(ChatFormatting.GRAY));
        }
}
