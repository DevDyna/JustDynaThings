// package com.devdyna.justdynathings.datagen.client;

// import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

// import java.util.concurrent.CompletableFuture;

// import com.devdyna.justdynathings.init.types.zBlocks;
// import com.devdyna.justdynathings.init.types.zItemTags;
// import com.devdyna.justdynathings.init.types.zItems;

// import net.minecraft.client.data.models.BlockModelGenerators;
// import net.minecraft.client.data.models.ItemModelGenerators;
// import net.minecraft.client.data.models.ModelProvider;
// import net.minecraft.client.data.models.MultiVariant;
// import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
// import net.minecraft.client.data.models.model.ModelLocationUtils;
// import net.minecraft.client.data.models.model.ModelTemplates;
// import net.minecraft.client.data.models.model.TextureMapping;
// import net.minecraft.client.data.models.model.TextureSlot;
// import net.minecraft.client.resources.model.sprite.Material;
// import net.minecraft.data.CachedOutput;
// import net.minecraft.data.PackOutput;
// import net.minecraft.resources.Identifier;
// import net.minecraft.world.level.block.Block;
// import net.minecraft.world.level.block.Blocks;
// import net.minecraft.world.level.block.state.properties.BlockStateProperties;

// public class DataModel extends ModelProvider {

//     public DataModel(PackOutput output) {
//         super(output, MODULE_ID);
//     }

//     @Override
//     protected void registerModels(BlockModelGenerators block, ItemModelGenerators item) {

//         zItems.zItem.getEntries().forEach(d -> item.generateFlatItem(d.get(), ModelTemplates.FLAT_ITEM));
//         zItems.zWands.getEntries().forEach(d -> item.generateFlatItem(d.get(), ModelTemplates.FLAT_HANDHELD_ITEM));
//         zItems.zGooUpgraders.getEntries().forEach(d -> item.generateFlatItem(d.get(), ModelTemplates.FLAT_ITEM));

//         


        

//     }

// }
