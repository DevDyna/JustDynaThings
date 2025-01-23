package com.devdyna.justdynathings.utils;



import com.devdyna.justdynathings.Main;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class PlayerUtil {
        public static void messageActionBar(String name, Player player) {
                player.displayClientMessage(Component.literal(name),
                                true);
        }

        public static void traslableActionMessage(String traslationkey, Player player) {
                player.displayClientMessage(Component.translatable(Main.ID + "." + traslationkey),
                                true);
        }
}
