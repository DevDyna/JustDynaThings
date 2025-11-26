package com.devdyna.justdynathings.compat.chisel;

import com.devdyna.justdynathings.compat.zCompat;
import com.devdyna.justdynathings.compat.chisel.builder.BlazeGoldChisel;
import com.devdyna.justdynathings.compat.chisel.builder.CelestiGemChisel;
import com.devdyna.justdynathings.compat.chisel.builder.EclipseAlloyChisel;
import com.devdyna.justdynathings.compat.chisel.builder.FerricoreChisel;
import com.leclowndu93150.chisel.item.ItemChisel;
import net.minecraft.world.item.Item.Properties;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;

public class initChisel {
        public static void register(IEventBus bus) {
        }

        public static DeferredItem<ItemChisel> FERRICORE_CHISEL = zCompat.extraItems
                        .register("ferricore_chisel",
                                        () -> new FerricoreChisel(new Properties()));

        public static DeferredItem<ItemChisel> BLAZEGOLD_CHISEL = zCompat.extraItems
                        .register("blazegold_chisel",
                                        () -> new BlazeGoldChisel(new Properties()));

        public static DeferredItem<ItemChisel> CELESTIGEM_CHISEL = zCompat.extraItems
                        .register("celestigem_chisel",
                                        () -> new CelestiGemChisel(new Properties()));

        public static DeferredItem<ItemChisel> ECLIPSE_ALLOY_CHISEL = zCompat.extraItems
                        .register("eclipse_alloy_chisel",
                                        () -> new EclipseAlloyChisel(new Properties()));

        

}