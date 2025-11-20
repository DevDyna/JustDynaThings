package com.devdyna.justdynathings.compat.geore;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.devdyna.justdynathings.compat.geore.builder.blockentities.*;
import com.devdyna.justdynathings.compat.geore.builder.blocks.*;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.EchoingBuddingType;
import com.shynieke.geore.registry.GeOreRegistry;

import net.neoforged.bus.api.IEventBus;

public class initGeOre {
        public static void register(IEventBus bus) {
        }

        public static EchoingBuddingType<CoalBlock, CoalBE> COAL = EchoingBuddingType.of(
                        GeOreRegistry.COAL_GEORE.getName(),
                        CoalBlock::new,
                        CoalBE::new);

        public static EchoingBuddingType<CopperBlock, CopperBE> COPPER = EchoingBuddingType.of(
                        GeOreRegistry.COPPER_GEORE.getName(),
                        CopperBlock::new,
                        CopperBE::new);

        public static EchoingBuddingType<DiamondBlock, DiamondBE> DIAMOND = EchoingBuddingType.of(
                        GeOreRegistry.DIAMOND_GEORE.getName(),
                        DiamondBlock::new,
                        DiamondBE::new);

        public static EchoingBuddingType<EmeraldBlock, EmeraldBE> EMERALD = EchoingBuddingType.of(
                        GeOreRegistry.EMERALD_GEORE.getName(),
                        EmeraldBlock::new,
                        EmeraldBE::new);

        public static EchoingBuddingType<GoldBlock, GoldBE> GOLD = EchoingBuddingType.of(
                        GeOreRegistry.GOLD_GEORE.getName(),
                        GoldBlock::new,
                        GoldBE::new);

        public static EchoingBuddingType<IronBlock, IronBE> IRON = EchoingBuddingType.of(
                        GeOreRegistry.IRON_GEORE.getName(),
                        IronBlock::new,
                        IronBE::new);

        public static EchoingBuddingType<LapisBlock, LapisBE> LAPIS = EchoingBuddingType.of(
                        GeOreRegistry.LAPIS_GEORE.getName(),
                        LapisBlock::new,
                        LapisBE::new);

        public static EchoingBuddingType<QuartzBlock, QuartzBE> QUARTZ = EchoingBuddingType.of(
                        GeOreRegistry.QUARTZ_GEORE.getName(),
                        QuartzBlock::new,
                        QuartzBE::new);

        public static EchoingBuddingType<RedstoneBlock, RedstoneBE> REDSTONE = EchoingBuddingType.of(
                        GeOreRegistry.REDSTONE_GEORE.getName(),
                        RedstoneBlock::new,
                        RedstoneBE::new);

        public static EchoingBuddingType<AncientDebrisBlock, AncientDebrisBE> ANCIENT_DEBRIS = EchoingBuddingType.of(
                        GeOreRegistry.ANCIENT_DEBRIS_GEORE.getName(),
                        AncientDebrisBlock::new,
                        AncientDebrisBE::new);

        public static EchoingBuddingType<RubyBlock, RubyBE> RUBY = EchoingBuddingType.of(
                        GeOreRegistry.RUBY_GEORE.getName(),
                        RubyBlock::new,
                        RubyBE::new);

        public static EchoingBuddingType<SapphireBlock, SapphireBE> SAPPHIRE = EchoingBuddingType.of(
                        GeOreRegistry.SAPPHIRE_GEORE.getName(),
                        SapphireBlock::new,
                        SapphireBE::new);

        public static EchoingBuddingType<TopazBlock, TopazBE> TOPAZ = EchoingBuddingType.of(
                        GeOreRegistry.TOPAZ_GEORE.getName(),
                        TopazBlock::new,
                        TopazBE::new);

        public static EchoingBuddingType<ZincBlock, ZincBE> ZINC = EchoingBuddingType.of(
                        GeOreRegistry.ZINC_GEORE.getName(),
                        ZincBlock::new,
                        ZincBE::new);

        public static EchoingBuddingType<UraniniteBlock, UraniniteBE> URANINITE = EchoingBuddingType.of(
                        GeOreRegistry.URANINITE_GEORE.getName(),
                        UraniniteBlock::new,
                        UraniniteBE::new);

        public static EchoingBuddingType<BlackQuartzBlock, BlackQuartzBE> BLACK_QUARTZ = EchoingBuddingType.of(
                        GeOreRegistry.BLACK_QUARTZ_GEORE.getName(),
                        BlackQuartzBlock::new,
                        BlackQuartzBE::new);

        public static EchoingBuddingType<MonaziteBlock, MonaziteBE> MONAZITE = EchoingBuddingType.of(
                        GeOreRegistry.MONAZITE_GEORE.getName(),
                        MonaziteBlock::new,
                        MonaziteBE::new);

        public static EchoingBuddingType<AluminumBlock, AluminumBE> ALUMINUM = EchoingBuddingType.of(
                        GeOreRegistry.ALUMINUM_GEORE.getName(),
                        AluminumBlock::new,
                        AluminumBE::new);

        public static EchoingBuddingType<LeadBlock, LeadBE> LEAD = EchoingBuddingType.of(
                        GeOreRegistry.LEAD_GEORE.getName(),
                        LeadBlock::new,
                        LeadBE::new);

        public static EchoingBuddingType<NickelBlock, NickelBE> NICKEL = EchoingBuddingType.of(
                        GeOreRegistry.NICKEL_GEORE.getName(),
                        NickelBlock::new,
                        NickelBE::new);

        public static EchoingBuddingType<OsmiumBlock, OsmiumBE> OSMIUM = EchoingBuddingType.of(
                        GeOreRegistry.OSMIUM_GEORE.getName(),
                        OsmiumBlock::new,
                        OsmiumBE::new);

        public static EchoingBuddingType<PlatinumBlock, PlatinumBE> PLATINUM = EchoingBuddingType.of(
                        GeOreRegistry.PLATINUM_GEORE.getName(),
                        PlatinumBlock::new,
                        PlatinumBE::new);

        public static EchoingBuddingType<SilverBlock, SilverBE> SILVER = EchoingBuddingType.of(
                        GeOreRegistry.SILVER_GEORE.getName(),
                        SilverBlock::new,
                        SilverBE::new);

        public static EchoingBuddingType<TinBlock, TinBE> TIN = EchoingBuddingType.of(
                        GeOreRegistry.TIN_GEORE.getName(),
                        TinBlock::new,
                        TinBE::new);

        public static EchoingBuddingType<TungstenBlock, TungstenBE> TUNGSTEN = EchoingBuddingType.of(
                        GeOreRegistry.TUNGSTEN_GEORE.getName(),
                        TungstenBlock::new,
                        TungstenBE::new);

        public static EchoingBuddingType<UraniumBlock, UraniumBE> URANIUM = EchoingBuddingType.of(
                        GeOreRegistry.URANIUM_GEORE.getName(),
                        UraniumBlock::new,
                        UraniumBE::new);

        public static EchoingBuddingType<AllthemodiumBlock, AllthemodiumBE> ALLTHEMODIUM = EchoingBuddingType.of(
                        GeOreRegistry.ALLTHEMODIUM_GEORE.getName(),
                        AllthemodiumBlock::new,
                        AllthemodiumBE::new);

        public static EchoingBuddingType<VibraniumBlock, VibraniumBE> VIBRANIUM = EchoingBuddingType.of(
                        GeOreRegistry.VIBRANIUM_GEORE.getName(),
                        VibraniumBlock::new,
                        VibraniumBE::new);

        public static EchoingBuddingType<UnobtainiumBlock, UnobtainiumBE> UNOBTAINIUM = EchoingBuddingType.of(
                        GeOreRegistry.UNOBTAINIUM_GEORE.getName(),
                        UnobtainiumBlock::new,
                        UnobtainiumBE::new);

        public static List<EchoingBuddingType<?, ?>> values() {
                List<EchoingBuddingType<?, ?>> list = new ArrayList<>();

                for (Field field : initGeOre.class.getDeclaredFields()) {
                        if (EchoingBuddingType.class.isAssignableFrom(field.getType())) {
                                try {
                                        EchoingBuddingType<?, ?> type = (EchoingBuddingType<?, ?>) field.get(null);
                                        if (type != null) {
                                                list.add(type);
                                        }
                                } catch (IllegalAccessException ignored) {
                                }
                        }
                }

                return list;
        }

}
