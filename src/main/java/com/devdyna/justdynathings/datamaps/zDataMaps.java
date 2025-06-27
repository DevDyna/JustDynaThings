package com.devdyna.justdynathings.datamaps;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.datamaps.records.FerricoreRepair;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent;

public class zDataMaps {

    public static final DataMapType<Item, FerricoreRepair> FERRICORE_REPAIR = DataMapType.builder(
            ResourceLocation.fromNamespaceAndPath(ID, "anvils/ferricore_repair"),
            Registries.ITEM,
            FerricoreRepair.CODEC).build();

    @SubscribeEvent
    public static void register(RegisterDataMapTypesEvent event) {
        event.register(FERRICORE_REPAIR);
    }
}
