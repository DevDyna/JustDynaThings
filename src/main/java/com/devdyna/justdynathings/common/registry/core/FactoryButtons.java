package com.devdyna.justdynathings.common.registry.core;

import java.util.Arrays;
import java.util.List;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.utils.DirectionUtil;
import com.direwolf20.justdirethings.JustDireThings;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory.TextureLocalization;
import com.direwolf20.justdirethings.client.screens.widgets.ToggleButton;

import net.minecraft.client.gui.components.Button;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class FactoryButtons {



        /**
         * create a button based on direction
         * 
         * @param x
         * @param y
         * @param startingValue
         * @param dir
         * @param onPress       NOT YET IMPLEMENTED
         * @return
         */
        public static ToggleButton SIDE(int x, int y, boolean startingValue, Direction dir, Button.OnPress onPress) {

                return new ToggleButton(
                                x +
                                DirectionUtil.POS[Arrays.asList(DirectionUtil.ALL).indexOf(dir)][0],
                                y +
                                DirectionUtil.POS[Arrays.asList(DirectionUtil.ALL).indexOf(dir)][1],
                                16,
                                16,
                                List.of(new TextureLocalization(
                                                ResourceLocation.fromNamespaceAndPath(JustDireThings.MODID,
                                                                "textures/gui/buttons/direction-"
                                                                                + dir.name().toLowerCase()
                                                                                + ".png"),
                                                //Component.translatable(Main.ID +"."+ dir.name().toLowerCase())
                                                Component.translatable(Main.ID +".clock.wip")
                                                )),
                                startingValue, onPress);
        }

}
