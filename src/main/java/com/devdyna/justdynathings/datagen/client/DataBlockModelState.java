package com.devdyna.justdynathings.datagen.client;

import static com.devdyna.justdynathings.Main.ID;
import static net.minecraft.world.level.block.Blocks.ANVIL;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.DataGenUtil;
import com.direwolf20.justdirethings.JustDireThings;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import static com.devdyna.justdynathings.compat.ae2.init.AE2_POWERED;
import static com.devdyna.justdynathings.compat.extendedae.init.EXTENDED_POWERED;
import static com.devdyna.justdynathings.compat.phasorite.init.PHASORITE_POWERED;

@SuppressWarnings("unused")
public class DataBlockModelState extends BlockStateProvider {

        public DataBlockModelState(PackOutput o, ExistingFileHelper f) {
                super(o, Main.ID, f);
        }

        @Override
        protected void registerStatesAndModels() {

                BaseGooStateModel(zBlocks.CREATIVE_GOO.get());
                BaseGooStateModel(zBlocks.ENERGIZED_GOO.get());
                BaseGooStateModel(zBlocks.T1_GOO.get());
                BaseGooStateModel(zBlocks.T2_GOO.get());
                BaseGooStateModel(zBlocks.T3_GOO.get());
                BaseGooStateModel(zBlocks.T4_GOO.get());
                AnvilStateModel(zBlocks.BLAZING_ANVIL.get());
                PhaseBox(zBlocks.PHASEBOX.get());
                DataGenUtil.SimpleBlock(zBlocks.BLACKHOLE.get(), this);
                DataGenUtil.SimpleBlock(zBlocks.SOLARGEN.get(), this);
                inversDirectionalBlocks(zBlocks.THERMOGEN.get());

                BaseBuddings(zBlocks.BUDDING_AMETHYST.get(), "minecraft:block/budding_amethyst",
                                ID + ":block/budding/" + DataGenUtil.getName(zBlocks.BUDDING_AMETHYST.get()));
                BaseBuddings(zBlocks.BUDDING_TIME.get(), "justdirethings:block/time_crystal_budding_block",
                                ID + ":block/budding/" + DataGenUtil.getName(zBlocks.BUDDING_TIME.get()));
                BaseBuddings(AE2_POWERED.get(), "ae2:block/flawless_budding_quartz",
                                ID + ":block/budding/" + DataGenUtil.getName(AE2_POWERED.get()));
                BaseBuddings(EXTENDED_POWERED.get(), "extendedae:block/entro_budding_fully",
                                ID + ":block/budding/" + DataGenUtil.getName(EXTENDED_POWERED.get()));
                BaseBuddings(PHASORITE_POWERED.get(), "phasoritenetworks:block/budding_phasorite",
                                ID + ":block/budding/" + DataGenUtil.getName(PHASORITE_POWERED.get()));

        }

        private void AnvilStateModel(Block b) {
                getVariantBuilder(b)
                                .forAllStates(state -> {
                                        Direction dir = state.getValue(AnvilBlock.FACING);
                                        return ConfiguredModel.builder()
                                                        .modelFile(models()
                                                                        .getExistingFile(DataGenUtil.getResource(
                                                                                        "block/" + DataGenUtil
                                                                                                        .getName(b))))
                                                        .rotationY(dir == Direction.EAST || dir == Direction.WEST ? 90
                                                                        : 0)
                                                        .build();
                                });
        }

        private void BaseGooStateModel(Block b, String modname) {
                DataGenUtil.BiStateBlock(this, b, GooBlock_Base.ALIVE,
                                DataGenUtil.getResource("block/goo/" + DataGenUtil.getName(b) + "/alive",
                                                modname),
                                DataGenUtil.getResource("block/goo/" + DataGenUtil.getName(b) + "/dead",
                                                modname));

        }

        private void BaseGooStateModel(Block b) {
                BaseGooStateModel(b, ID);
        }

        private void PhaseBox(Block b) {
                DataGenUtil.BiStateBlock(this, b, zProperties.SOLID,
                                DataGenUtil.BlockwithParent(b, this, "block/cube_all", "all",
                                                "justdynathings:block/phase/true"),
                                DataGenUtil.cutOut(DataGenUtil.BlockwithParent(b, this, "block/cube_all", "all",
                                                "justdynathings:block/phase/false")));
        }

        private void inversDirectionalBlocks(Block block) {
                var model = models().getExistingFile(DataGenUtil.getResource(
                                "block/" + DataGenUtil.getName(block)));
                getVariantBuilder(block)
                                .forAllStates(state -> {
                                        Direction dir = state.getValue(BlockStateProperties.FACING);
                                        return ConfiguredModel.builder()
                                                        .modelFile(model)
                                                        .rotationX(dir == Direction.UP ? 180
                                                                        : dir.getAxis().isHorizontal() ? 90 : 0)
                                                        .rotationY(dir.getAxis().isVertical() ? 0
                                                                        : (int) dir.toYRot() % 360)
                                                        .build();
                                });

        }

        private void BaseBuddings(Block b, String on, String off) {
                DataGenUtil.BiStateBlock(this, b, zProperties.ACTIVE,
                                DataGenUtil.BlockwithParent(b, this, "block/cube_all", "all",
                                                on),
                                DataGenUtil.BlockwithParent(b, this, "block/cube_all", "all",
                                                off));

        }

}
