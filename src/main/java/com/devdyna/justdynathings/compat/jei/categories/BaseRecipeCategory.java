package com.devdyna.justdynathings.compat.jei.categories;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import org.jetbrains.annotations.Nullable;

import com.devdyna.cakesticklib.api.compat.jei.ImageJei;
import com.devdyna.cakesticklib.api.primitive.Size;
import com.devdyna.justdynathings.api.Image;

import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.ItemLike;

public abstract class BaseRecipeCategory<T> implements IRecipeCategory<T> {

    protected IGuiHelper helper;

    public final Font font = Minecraft.getInstance().font;

    public BaseRecipeCategory(IGuiHelper h) {
        this.helper = h;
    }

    public abstract String getTitleKey();

    public abstract ItemLike getIconItem();

    /**
     * Set Size of all category
     * <br/>
     * <br/>
     * If the background image doesn't fit , you need to override
     * <code>background(GuiGraphics)</code>
     */
    public abstract Size setXY();

    public abstract String setBackGround();

    @Override
    public Component getTitle() {
        return Component.translatable(MODULE_ID + ".jei.category." + getTitleKey());
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return helper.createDrawableItemLike(getIconItem());
    }

    @Override
    public int getWidth() {
        return setXY().getX();
    }

    @Override
    public int getHeight() {
        return setXY().getY();
    }

    public void background(GuiGraphicsExtractor graphics) {
        ImageJei.of()
                .rl(MODULE_ID,this.setBackGround())
                .size(this.getWidth(), this.getHeight())
                .render(helper, graphics);
    }

    @SuppressWarnings("null")
    @Override
    public void draw(T recipe, IRecipeSlotsView recipeSlotsView, GuiGraphicsExtractor guiGraphics, double mouseX,
            double mouseY) {
        background(guiGraphics);
    }

}