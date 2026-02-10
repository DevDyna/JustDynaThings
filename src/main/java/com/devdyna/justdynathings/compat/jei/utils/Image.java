package com.devdyna.justdynathings.compat.jei.utils;

import static com.devdyna.justdynathings.Main.ID;

import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

public class Image {

  private int x;
  private int y;
  private String rl;
  private String modid = ID;
  private int xo = 0;
  private int yo = 0;
  private int tx = x;
  private int ty = y;

  private int u = 0;
  private int v = 0;
  private int index = 0;

  public Image() {

  }

  public static Image of() {
    return new Image();
  }

  public Image size(int x, int y) {
    this.x = x;
    this.y = y;
    return this;
  }

  public Image sizeTexture(int textureWidth, int textureHeight) {
    this.tx = x;
    this.ty = y;
    return this;
  }

  public Image uv(int u, int v) {
    this.u = u;
    this.v = v;
    return this;
  }

  public Image offset(int xo, int yo) {
    this.xo = xo;
    this.yo = yo;
    return this;
  }

  public Image index(int i) {
    this.index = i;
    return this;
  }

  public Image rl(String image) {
    this.rl = image;
    return this;
  }

  public Image rl(String modid, String image) {
    this.modid = modid;
    this.rl = image;
    return this;
  }

  public Image rl(ResourceLocation rl) {
    this.modid = rl.getNamespace();
    this.rl = rl.getPath();
    return this;
  }

  /**
   * JEI usage
   */
  public void render(IGuiHelper h, GuiGraphics g) {
    h.drawableBuilder(ResourceLocation.fromNamespaceAndPath(modid, rl), u, v, x, y).setTextureSize(x, y).build()
        .draw(g, xo, yo);
  }

  /**
   * not JEI usage!
   */
  public void render(GuiGraphics g) {

    g.blit(
        ResourceLocation.fromNamespaceAndPath(modid, rl),
        xo - 1,
        yo - 1,
        index, u, v,
        x, y,
        tx, ty);

  }

}