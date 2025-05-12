package com.devdyna.justdynathings.datagen.client;

import static com.devdyna.justdynathings.Main.ID;
import static net.minecraft.world.level.block.Blocks.ANVIL;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.DataGenUtil;
import com.direwolf20.justdirethings.JustDireThings;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

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
                simpleBlock(zBlocks.BLACKHOLE.get());
                simpleBlock(zBlocks.SOLARGEN.get());
                DirectionalBlocks(zBlocks.THERMOGEN.get());
                

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
                getVariantBuilder(b).partialState().with(GooBlock_Base.ALIVE, true).modelForState()
                                .modelFile(models().getExistingFile(DataGenUtil.getResource("block/goo/"
                                                + b.getDescriptionId().replace("block." + modname + ".", "") + "/alive",
                                                modname)))
                                .addModel().partialState().with(GooBlock_Base.ALIVE, false).modelForState()
                                .modelFile(models().getExistingFile(DataGenUtil.getResource("block/goo/"
                                                + b.getDescriptionId().replace("block." + modname + ".", "") + "/dead",
                                                modname)))
                                .addModel();
        }

        private void BaseGooStateModel(Block b) {
                BaseGooStateModel(b, ID);
        }

        private void PhaseBox(Block b) {
                getVariantBuilder(b).partialState().with(zProperties.SOLID, true).modelForState()
                                .modelFile(models().getExistingFile(DataGenUtil.getResource("block/"
                                                + b.getDescriptionId().replace("block." + ID + ".", "") + "/" + true)))
                                .addModel().partialState().with(zProperties.SOLID, false).modelForState()
                                .modelFile(models().getExistingFile(DataGenUtil.getResource(
                                                "block/" + b.getDescriptionId().replace("block." + ID + ".", "")
                                                                + "/" + false)))
                                .addModel();
        }

        private void DirectionalBlocks(Block block) {
                directionalBlock(block, models().getExistingFile(DataGenUtil.getResource(
                                "block/" + block.getDescriptionId().replace("block." + ID + ".", ""))));
        }

}
