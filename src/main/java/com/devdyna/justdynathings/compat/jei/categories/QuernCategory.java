// package com.devdyna.justdynathings.compat.jei.categories;

// import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

// import com.devdyna.cakesticklib.api.compat.jei.BaseRecipeCategory;
// import com.devdyna.cakesticklib.api.primitive.Size;
// import com.devdyna.cakesticklib.api.utils.x;
// import com.devdyna.justdynathings.init.types.zBlocks;
// import com.devdyna.justdynathings.init.types.zRecipeTypes;

// import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
// import mezz.jei.api.helpers.IGuiHelper;
// import mezz.jei.api.recipe.IFocusGroup;
// import mezz.jei.api.recipe.RecipeIngredientRole;
// import mezz.jei.api.recipe.types.IRecipeType;
// import net.minecraft.resources.Identifier;
// import net.minecraft.world.item.crafting.RecipeHolder;
// import net.minecraft.world.level.ItemLike;

// public class QuernCategory extends BaseRecipeCategory<MillingRecipe> {

//     public QuernCategory(IGuiHelper helper) {
//         super(helper);
//     }

//     public static final IRecipeType<RecipeHolder<MillingRecipe>> TYPE = IRecipeType
//             .create(zRecipeTypes.QUERN.getType());

//     @Override
//     public IRecipeType<RecipeHolder<MillingRecipe>> getRecipeType() {
//         return TYPE;
//     }

//     @Override
//     public String getTraslationKey() {
//         return MODULE_ID + ".jei.quern";
//     }

//     @Override
//     public ItemLike getIconItem() {
//         return zBlocks.QUERN.get();
//     }

//     @Override
//     public Size setXY() {
//         return Size.of(75, 20);
//     }

//     @Override
//     public Identifier setBackGround() {
//         return x.rl(MODULE_ID, "textures/gui/jei/simple.png");
//     }

//     @Override
//     public void setRecipe(IRecipeLayoutBuilder builder, MillingRecipe recipe, IFocusGroup focuses) {

//         builder.addSlot(RecipeIngredientRole.INPUT, 2, 2)
//                 .add(recipe.getInput());

//         builder.addSlot(RecipeIngredientRole.OUTPUT, 57, 2)
//                 .add(recipe.getOutput().create());
//     }

//     @Override
//     public boolean enableTimerRender() {
//         return true;
//     }

//     @Override
//     public int tickValue(MillingRecipe recipe) {
//         return recipe.getTime();
//     }

// }