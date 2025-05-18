package com.devdyna.justdynathings.utils;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.datagen.client.DataBlockModelState;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

public class DataGenUtil {

    public static final ResourceLocation CUTOUT = ResourceLocation.withDefaultNamespace("cutout");

    private static String mc = "minecraft:";
    public static String TOOL = mc + "item/handheld";
    public static String ITEM = mc + "item/generated";
    private static String mod = Main.ID + ":";

    public static String CUBE_ALL = "block/cube_all";

    public static Block getBlock(String id) {
        return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(Main.ID, id));
    }

    public static String getPath(Block b) {
        return BuiltInRegistries.BLOCK.getKey(b).getPath();
    }

    public static String getPath(Item i) {
        return BuiltInRegistries.ITEM.getKey(i).getPath();
    }

    /**
     * NOT ADDONS
     */
    public static ResourceLocation getResource(String s, String modid) {
        return ResourceLocation.fromNamespaceAndPath(modid, s);
    }

    public static ResourceLocation getResource(Block b, String modid) {
        return ResourceLocation.fromNamespaceAndPath(modid, getPath(b));
    }

    public static ResourceLocation getResource(Item i, String modid) {
        return ResourceLocation.fromNamespaceAndPath(modid, getPath(i));
    }

    /**
     * @Deprecated
     *             intend use modLoc
     */
    public static ResourceLocation getResource(String s) {
        return getResource(s, ID);
    }

    public static ResourceLocation getResource(Block b) {
        return getResource(b, ID);
    }

    public static ResourceLocation getResource(Item i) {
        return getResource(i, ID);
    }

    public static ItemModelBuilder itemTool(Item item, ItemModelProvider b) {
        return b.withExistingParent(getPath(item), TOOL).texture("layer0",
                getResource("item/" + getPath(item)));
    }

    public static ItemModelBuilder itemModel(Item item, ItemModelProvider b) {
        return b.withExistingParent(getPath(item), ITEM).texture("layer0",
                getResource("item/" + getPath(item)));
    }

    public static ItemModelBuilder itemBlock(Block block, ItemModelProvider b) {
        return b.withExistingParent(getPath(block), mod + "block/" + getPath(block));
    }

    public static ItemModelBuilder itemBlockwithParent(Block block, ItemModelProvider b, String parent) {
        return b.withExistingParent(getPath(block), parent);
    }

    public static ItemModelBuilder itemBlockwithParent(Block block, ItemModelProvider b, String parent, String keyname,
            String texture) {
        return itemBlockwithParent(block, b, parent).texture(keyname, texture);
    }

    /**
     * @deprecated intend use .texture(key,texture)
     * @param block
     * @param b       this
     * @param parent  Main.ID + ":block/..."
     * @param keyname "all"
     * @param texture "minecraft:block/cobblestone" NOT ADDONS
     * @return blockmodel
     */
    public static BlockModelBuilder BlockwithParent(Block block, BlockStateProvider b,
            String parent, String keyname, String texture) {
        return b.models().withExistingParent(getPath(block), parent)
                .texture(keyname, texture);
    }

    /**
     * @param block
     * @param b
     * @param parent
     * @return blockmodel
     */
    public static BlockModelBuilder BlockwithParent(Block block, BlockStateProvider b,
            String parent) {
        return b.models().withExistingParent(getPath(block), parent);
    }

    /**
     * @return blockstate and model
     */
    public static void MonoStateBlock(DataBlockModelState d, Block b, String parent) {
        d.simpleBlock(b, BlockwithParent(b, d, parent));
    }

    /**
     * @deprecated intend use .texture(key,texture)
     */
    public static void MonoStateBlock(DataBlockModelState d, Block b, String parent, String keyname,
            String texture) {
        d.simpleBlock(b, BlockwithParent(b, d, parent).texture(keyname, texture));
    }

    public static String getName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    public static void BiStateBlock(DataBlockModelState t, Block b, BooleanProperty p, ResourceLocation on,
            ResourceLocation off) {
        t.getVariantBuilder(b).partialState().with(p, true).modelForState()
                .modelFile(t.models().getExistingFile(on))
                .addModel().partialState().with(p, false).modelForState()
                .modelFile(t.models().getExistingFile(off))
                .addModel();
    }

    public static void BiStateBlock(DataBlockModelState t, Block b, BooleanProperty p, ModelFile on,
            ModelFile off) {
        t.getVariantBuilder(b).partialState().with(p, true).modelForState()
                .modelFile(on)
                .addModel().partialState().with(p, false).modelForState()
                .modelFile(off)
                .addModel();
    }

    public static void BiStateBlock(DataBlockModelState t, Block b, BooleanProperty p, ModelFile on,
            ResourceLocation off) {
        t.getVariantBuilder(b).partialState().with(p, true).modelForState()
                .modelFile(on)
                .addModel().partialState().with(p, false).modelForState()
                .modelFile(t.models().getExistingFile(off))
                .addModel();
    }

    public static void BiStateBlock(DataBlockModelState t, Block b, BooleanProperty p, ResourceLocation on,
            ModelFile off) {
        t.getVariantBuilder(b).partialState().with(p, true).modelForState()
                .modelFile(t.models().getExistingFile(on))
                .addModel().partialState().with(p, false).modelForState()
                .modelFile(off)
                .addModel();
    }

    public static void SimpleBlock(Block block, String modid, DataBlockModelState t) {
        t.simpleBlock(block, t.models().getExistingFile(DataGenUtil.getResource(
                "block/" + DataGenUtil.getName(block), modid)));
    }

    public static void SimpleBlock(Block block, DataBlockModelState t) {
        SimpleBlock(block, ID, t);
    }

    public static BlockModelBuilder cutOut(BlockModelBuilder b) {
        return b.renderType(CUTOUT);
    }

    public static BlockModelBuilder NamewithParent(String name, BlockStateProvider b,
            String parent) {
        return b.models().withExistingParent(name, parent);
    }

    /**
     * @deprecated intend use .texture(key,texture)
     */
    public static BlockModelBuilder NamewithParent(String name, BlockStateProvider b,
            String parent, String keyname, String texture) {
        return b.models().withExistingParent(name, parent)
                .texture(keyname, texture);
    }

    public static BlockModelBuilder CubeAll(String name, BlockStateProvider b,
            String texture) {
        return b.models().withExistingParent(name, CUBE_ALL)
                .texture("all", texture);
    }

    public static ICondition[] isModLoaded(String modid) {
        return new ICondition[] { new ModLoadedCondition(modid) };
    }

}
