package com.devdyna.justdynathings.compat;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.compat.ae2.initApp;
import com.devdyna.justdynathings.compat.extendedae.initExtend;
import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.compat.phasorite.initPhaso;
import com.devdyna.justdynathings.utils.LogUtil;

import guideme.Guide;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zCompat {

        public static void core(IEventBus bus) {
                setup(bus);
                LogUtil.decor(20);
                LogUtil.info("JustDynaThings Compatibility Checker started");
                LogUtil.decor(20);
                LogUtil.info("AppliedEnergistics2"
                                + (Constants.ModAddonCheck.AppliedEnergistics2 ? " found " : " not found "));
                LogUtil.info("ExtendedAE"
                                + (Constants.ModAddonCheck.ExtendedAE ? " found " : " not found "));
                LogUtil.info("PhasoriteNetworks"
                                + (Constants.ModAddonCheck.PhasoriteNetworks ? " found " : " not found "));
                LogUtil.info("GeOre"
                                + (Constants.ModAddonCheck.GeOre ? " found " : " not found "));
                createGuide();
                LogUtil.decor(20);
        }

        private static void createGuide() {
                LogUtil.info("GuideMe"
                                + (Constants.ModAddonCheck.GuideMe ? " found" : " not found"));
                if (Constants.ModAddonCheck.GuideMe)
                        Guide.builder(ResourceLocation.parse(Main.ID + ":guide")).build();

        }

        private static void setup(IEventBus bus) {
                extraItems.register(bus);
                extraBlocks.register(bus);
                extraBE.register(bus);

                if (Constants.ModAddonCheck.AppliedEnergistics2)
                        initApp.register(bus);
                if (Constants.ModAddonCheck.ExtendedAE)
                        initExtend.register(bus);
                if (Constants.ModAddonCheck.GeOre)
                        initGeOre.register(bus);
                if (Constants.ModAddonCheck.PhasoriteNetworks)
                        initPhaso.register(bus);
        }

        public static final DeferredRegister.Blocks extraBlocks = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Items extraItems = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister<BlockEntityType<?>> extraBE = DeferredRegister
                        .create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Main.ID);
}
