package com.devdyna.justdynathings.utils;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.datagen.client.DataBlockModelState;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;

public class DataGenUtil {

    public static final ResourceLocation CUTOUT = ResourceLocation.withDefaultNamespace("cutout");

    private static String mc = "minecraft:";
    public static String TOOL = mc + "item/handheld";
    public static String ITEM = mc + "item/generated";
    private static String modparent = Main.ID + ":";

    public static Block getBlock(String id) {
        return BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(Main.ID, id));
    }

    public static String getPath(Block b) {
        return BuiltInRegistries.BLOCK.getKey(b).getPath();
    }

    public static String getPath(Item i) {
        return BuiltInRegistries.ITEM.getKey(i).getPath();
    }

    public static ResourceLocation getResource(String s) {
        return ResourceLocation.fromNamespaceAndPath(Main.ID, s);
    }

    public static ResourceLocation getResource(Block b) {
        return ResourceLocation.fromNamespaceAndPath(Main.ID, getPath(b));
    }

    public static ResourceLocation getResource(Item i) {
        return ResourceLocation.fromNamespaceAndPath(Main.ID, getPath(i));
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
        return b.withExistingParent(getPath(block), modparent + getPath(block));
    }

    public static ItemModelBuilder itemBlockwithParent(Block block, ItemModelProvider b, String parent) {
        return b.withExistingParent(getPath(block), parent);
    }

    public static ItemModelBuilder itemBlockwithParent(Block block, ItemModelProvider b, String parent, String keyname,
            String texture) {
        return b.withExistingParent(getPath(block), parent).texture(keyname, texture);
    }

    /**
     * @param block
     * @param b       this
     * @param parent  Main.ID + ":block/..."
     * @param keyname "all"
     * @param texture "minecraft:block/cobblestone"
     * @return blockmodel
     */
    public static BlockModelBuilder BlockwithParent(Block block, BlockStateProvider b,
            String parent, String keyname, String texture) {
        return b.models().withExistingParent(getPath(block), parent)
                .texture(keyname, texture);
    }

    /**
     * 
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
    public static void simpleBlockwithModel(DataBlockModelState d, Block b, String parent) {
        d.simpleBlock(b, BlockwithParent(b, d, parent));
    }

    /**
     * @return blockstate and model
     */
    public static void simpleBlockwithModel(DataBlockModelState d, Block b, String parent, String keyname,
            String texture) {
        d.simpleBlock(b, BlockwithParent(b, d, parent, keyname, texture));
    }

    public static String getName(Block block){
        return block.getDescriptionId().replace("block." + ID + ".", "");
    }



}
