package com.devdyna.justdynathings.datagen.client;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.DataGenUtil;
import com.direwolf20.justdirethings.JustDireThings;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;
import com.direwolf20.justdirethings.setup.Registration;

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

import com.devdyna.justdynathings.Constants;

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

                BaseSolarPanel(zBlocks.FERRICORE_SOLARGEN.get(), modLoc("block/solar_panel/ferricore"));
                BaseSolarPanel(zBlocks.BLAZEGOLD_SOLARGEN.get());
                BaseSolarPanel(zBlocks.CELESTIGEM_SOLARGEN.get());
                BaseSolarPanel(zBlocks.ECLIPSEALLOY_SOLARGEN.get());

                inversDirectionalBlocks(zBlocks.THERMOGEN.get());

                BaseBuddings(zBlocks.ECHOING_BUDDING_AMETHYST.get(), mcLoc("block/budding_amethyst"),
                                CubeAllCheap(ID + ":block/echoing_budding/amethyst", this));

                BaseBuddings(zBlocks.ECHOING_BUDDING_TIME.get(),
                                modLoc("block/echoing_budding/time/alive"),
                                modLoc("block/echoing_budding/time/dead"));

                BaseBuddings(AE2_POWERED.get(),
                                modLoc("block/echoing_budding/certus/alive"),
                                CubeAllCheap(ID + ":block/echoing_budding/certus", this));

                BaseBuddings(EXTENDED_POWERED.get(),
                                modLoc("block/echoing_budding/entro/alive"),
                                CubeAllCheap(ID + ":block/echoing_budding/entro", this));

                BaseBuddings(PHASORITE_POWERED.get(),
                                modLoc("block/echoing_budding/phasorite/alive"),
                                CubeAllCheap(ID + ":block/echoing_budding/phasorite", this));

                AnvilStateModel(zBlocks.FERRICORE_ANVIL.get());
                AnvilStateModel(zBlocks.BLAZEGOLD_ANVIL.get());
                AnvilStateModel(zBlocks.CELESTIGEM_ANVIL.get());
                AnvilStateModel(zBlocks.ECLIPSEALLOY_ANVIL.get());

        }

        private void AnvilStateModel(Block b) {
                getVariantBuilder(b).forAllStates(state -> ConfiguredModel.builder().modelFile(models()
                                .getExistingFile(DataGenUtil.getResource("block/anvils/"
                                                + DataGenUtil.getName(b).replace("_anvil", ""))))
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
                String blockname = DataGenUtil.getName(b).replace("echoing_budding_", "");
                DataGenUtil.BiStateBlock(this, b, zProperties.GOO_ALIVE, models().getExistingFile(on),
                                models().getExistingFile(off));
        }

        private void BaseBuddings(Block b, ModelFile on, ResourceLocation off) {
                String blockname = DataGenUtil.getName(b).replace("echoing_budding_", "");
                DataGenUtil.BiStateBlock(this, b, zProperties.GOO_ALIVE, on,
                                models().getExistingFile(off));
        }

        private void BaseBuddings(Block b, ResourceLocation on, ModelFile off) {
                String blockname = DataGenUtil.getName(b).replace("echoing_budding_", "");
                DataGenUtil.BiStateBlock(this, b, zProperties.GOO_ALIVE, models().getExistingFile(on),
                                off);

        }

        public static BlockModelBuilder CubeAllCheap(String nameTexture, BlockStateProvider b) {
                return DataGenUtil.CubeAll(nameTexture + "/dead", b, nameTexture);
        }

        private void BaseSolarPanel(Block b) {
                String blockname = DataGenUtil.getName(b).replace("_solar_panel", "");
                simpleBlock(b, DataGenUtil
                                .NamewithParent("justdynathings:block/solar_panel/" + blockname, this,
                                                "justdynathings:block/solar_panel/_template")
                                .texture("side", "justdynathings:block/generator/" + blockname + "/side")
                                .texture("bottom", "justdynathings:block/generator/" + blockname + "/bottom"));
        }

        private void BaseSolarPanel(Block b, ResourceLocation model) {
                simpleBlock(b, models().getExistingFile(model));
        }

        /**
         * //TODO gen block with id generatort < index >
         * 
         * NO T1 GENERATOR
         **/
        private void BaseGenerator(Block b) {
                //TODO check if it work again
                String tier = Constants.Tiers.materials
                                .get(Integer.getInteger(DataGenUtil.getName(b).replace("generatort", "")));
                simpleBlock(b,
                                DataGenUtil.NamewithParent("justdynathings:block/generator/" + tier, this,
                                                "justdynathings:block/generator/_template")
                                                .texture("side", "justdynathings:block/generator/" + tier
                                                                + "/side")
                                                .texture("top", "justdynathings:block/generator/" + tier + "/top")
                                                .texture("bottom", "justdynathings:block/generator/" + tier
                                                                + "/bottom"));
        }

}
