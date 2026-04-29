package com.devdyna.justdynathings.init.builder.solar_panels.ferricore;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.api.Actions;
import com.devdyna.justdynathings.api.solar_panels.SolarBlockBase;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FerricoreSolarBlock extends SolarBlockBase {

        public FerricoreSolarBlock(Properties p) {
                super(p);
        }

        @Nullable
        @Override
        public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
                return new FerricoreSolarBE(pos, state);
        }

        @Override
        public boolean isValidBE(BlockEntity be) {
                return be instanceof FerricoreSolarBE;
        }

        @Override
        public void openMenu(Player p, BlockPos b) {
                Actions.openMenu(p, (w, i, e) -> new FerricoreSolarPanelGUI(w, i, b), b);
        }

        // @Override
        // public void appendHoverText(ItemStack s, TooltipContext c, List<Component> t,
        //                 TooltipFlag f) {
        //         super.appendHoverText(s, c, t, f);
        //         if (Screen.hasShiftDown()) {
        //                 t.add(Component.translatable(Main.ID + "." + Constants.SolarPanelType + ".ferate")
        //                                 .append(Component.literal("" + CommonConfig.SOLARPANEL_FERRICORE_FE_RATE.get())));
        //         } else
        //                 t.add(Component.translatable("justdirethings.shiftmoreinfo").withStyle(ChatFormatting.GRAY));
        // }
}
