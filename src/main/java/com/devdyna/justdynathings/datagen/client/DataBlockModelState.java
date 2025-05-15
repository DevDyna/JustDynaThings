package com.devdyna.justdynathings.datagen.client;

import static com.devdyna.justdynathings.Main.ID;

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
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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
                PhaseBox(zBlocks.PHASEBOX.get());
                DataGenUtil.SimpleBlock(zBlocks.BLACKHOLE.get(), this);
                DataGenUtil.SimpleBlock(zBlocks.SOLARGEN.get(), this);
                inversDirectionalBlocks(zBlocks.THERMOGEN.get());

                BaseBuddings(zBlocks.BUDDING_AMETHYST.get(), mcLoc("block/budding_amethyst"),
                                CubeAllCheap(ID + ":block/budding/amethyst", this));

                BaseBuddings(zBlocks.BUDDING_TIME.get(),
                                modLoc("block/budding/time/alive"),
                                modLoc("block/budding/time/dead"));

                BaseBuddings(AE2_POWERED.get(),
                                modLoc("block/budding/certus/alive"),
                                CubeAllCheap(ID + ":block/budding/certus", this));

                BaseBuddings(EXTENDED_POWERED.get(),
                                modLoc("block/budding/entro/alive"),
                                CubeAllCheap(ID + ":block/budding/entro", this));

                BaseBuddings(PHASORITE_POWERED.get(),
                                modLoc("block/budding/phasorite/alive"),
                                CubeAllCheap(ID + ":block/budding/phasorite", this));

                AnvilStateModel(zBlocks.METALLIC_ANVIL.get(),
                                "justdirethings:block/blockswappert1_top",
                                "justdirethings:block/generatort1_bottom",
                                "justdirethings:block/ferricore_block");
                AnvilStateModel(zBlocks.MAGMATIC_ANVIL.get(),
                                "justdirethings:block/blockplacert1_top",
                                "justdirethings:block/blockswappert1_bottom",
                                "justdirethings:block/blazegold_block");
                AnvilStateModel(zBlocks.POWERED_ANVIL.get(),
                                "justdirethings:block/blockplacert2_top",
                                "justdirethings:block/blockbreakert2_bottom",
                                "justdirethings:block/celestigem_block");
                AnvilStateModel(zBlocks.TIME_ANVIL.get(),
                                "justdirethings:block/paradoxmachine_bottom",
                                "justdirethings:block/blockswappert2_bottom",
                                "justdirethings:block/eclipsealloy_block");

        }

        private void AnvilStateModel(Block b, String plate, String pedestal, String block) {
                getVariantBuilder(b).forAllStates(state -> ConfiguredModel.builder()
                                .modelFile(DataGenUtil
                                                .NamewithParent("justdynathings:block/anvils/"
                                                                + DataGenUtil.getName(b).replace("_anvil", ""), this,
                                                                "justdynathings:block/anvils/template_anvil")
                                                .texture("plate", plate)
                                                .texture("pedestal", pedestal)
                                                .texture("block", block))
                                .rotationY(state.getValue(AnvilBlock.FACING) == Direction.EAST
                                                || state.getValue(AnvilBlock.FACING) == Direction.WEST ? 90 : 0)
                                .build());
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
                                DataGenUtil.NamewithParent("justdynathings:block/phase_box/true", this,
                                                "block/cube_all").texture("all", "justdynathings:block/phase/true"),
                                DataGenUtil.NamewithParent("justdynathings:block/phase_box/false", this,
                                                "block/cube_all").texture("all", "justdynathings:block/phase/false")
                                                .renderType(DataGenUtil.CUTOUT));
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

        private void BaseBuddings(Block b, ResourceLocation on, ResourceLocation off) {
                String blockname = DataGenUtil.getName(b).replace("budding_", "");
                DataGenUtil.BiStateBlock(this, b, zProperties.GOO_ALIVE, models().getExistingFile(on),
                                models().getExistingFile(off));
        }

        private void BaseBuddings(Block b, ModelFile on, ResourceLocation off) {
                String blockname = DataGenUtil.getName(b).replace("budding_", "");
                DataGenUtil.BiStateBlock(this, b, zProperties.GOO_ALIVE, on,
                                models().getExistingFile(off));
        }

        private void BaseBuddings(Block b, ResourceLocation on, ModelFile off) {
                String blockname = DataGenUtil.getName(b).replace("budding_", "");
                DataGenUtil.BiStateBlock(this, b, zProperties.GOO_ALIVE, models().getExistingFile(on),
                                off);

        }

        public static BlockModelBuilder CubeAllCheap(String nameTexture, BlockStateProvider b) {
                return DataGenUtil.CubeAll(nameTexture + "/dead", b, nameTexture);
        }

}
