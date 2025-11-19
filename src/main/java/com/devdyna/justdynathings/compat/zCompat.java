package com.devdyna.justdynathings.compat;

import java.util.List;

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

        public final static List<String> getEchoingBuddingTypes = List.of(
                        "echoing_budding_certus",
                        "echoing_budding_entro",
                        "echoing_budding_phasorite",
                        "echoing_budding_allthemodium",
                        "echoing_budding_aluminum",
                        "echoing_budding_ancient_debris",
                        "echoing_budding_black_quartz",
                        "echoing_budding_coal",
                        "echoing_budding_copper",
                        "echoing_budding_diamond",
                        "echoing_budding_emerald",
                        "echoing_budding_gold",
                        "echoing_budding_iron",
                        "echoing_budding_lapis",
                        "echoing_budding_lead",
                        "echoing_budding_monazite",
                        "echoing_budding_nickel",
                        "echoing_budding_osmium",
                        "echoing_budding_platinum",
                        "echoing_budding_quartz",
                        "echoing_budding_redstone",
                        "echoing_budding_ruby",
                        "echoing_budding_sapphire",
                        "echoing_budding_silver",
                        "echoing_budding_tin",
                        "echoing_budding_topaz",
                        "echoing_budding_tungsten",
                        "echoing_budding_unobtainium",
                        "echoing_budding_uraninite",
                        "echoing_budding_uranium",
                        "echoing_budding_vibranium",
                        "echoing_budding_zinc");

        public static List<String> getMissingItems() {
                List<String> list = getEchoingBuddingTypes;

                if (Constants.ModAddonCheck.AppliedEnergistics2)
                        list.remove("echoing_budding_certus");

                if (Constants.ModAddonCheck.ExtendedAE)
                        list.remove("echoing_budding_entro");

                if (Constants.ModAddonCheck.PhasoriteNetworks)
                        list.remove("echoing_budding_phasorite");

                if (Constants.ModAddonCheck.GeOre)
                        list.removeAll(List.of(
                                        "echoing_budding_allthemodium",
                                        "echoing_budding_aluminum",
                                        "echoing_budding_ancient_debris",
                                        "echoing_budding_black_quartz",
                                        "echoing_budding_coal",
                                        "echoing_budding_copper",
                                        "echoing_budding_diamond",
                                        "echoing_budding_emerald",
                                        "echoing_budding_gold",
                                        "echoing_budding_iron",
                                        "echoing_budding_lapis",
                                        "echoing_budding_lead",
                                        "echoing_budding_monazite",
                                        "echoing_budding_nickel",
                                        "echoing_budding_osmium",
                                        "echoing_budding_platinum",
                                        "echoing_budding_quartz",
                                        "echoing_budding_redstone",
                                        "echoing_budding_ruby",
                                        "echoing_budding_sapphire",
                                        "echoing_budding_silver",
                                        "echoing_budding_tin",
                                        "echoing_budding_topaz",
                                        "echoing_budding_tungsten",
                                        "echoing_budding_unobtainium",
                                        "echoing_budding_uraninite",
                                        "echoing_budding_uranium",
                                        "echoing_budding_vibranium",
                                        "echoing_budding_zinc"));

                return list;
        }

}
