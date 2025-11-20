package com.devdyna.justdynathings.compat.jei.utils;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.utils.DataGenUtil;

import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.client.gui.GuiGraphics;

public class Image {

  private int x;
  private int y;
  private String rl;
  private String modid = ID;
  private int xo = 0;
  private int yo = 0;

  private int u = 0;
  private int v = 0;

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

  public Image rl(String image) {
    this.rl = image;
    return this;
  }

  public Image rl(String modid, String image) {
    this.modid = modid;
    this.rl = image;
    return this;
  }

  /**
   * JEI usage
   */
  public void render(IGuiHelper h, GuiGraphics g) {
    h.drawableBuilder(DataGenUtil.getResource(rl, modid), u, v, x, y).setTextureSize(x, y).build()
        .draw(g, xo, yo);
  }

  /**
   * not JEI usage!
   */
  public void render(GuiGraphics g) {

    g.blit(
        DataGenUtil.getResource(rl, modid),
        xo - 1,
        yo - 1,
        u, v,
        x, y,
        x, y);

  }

}
