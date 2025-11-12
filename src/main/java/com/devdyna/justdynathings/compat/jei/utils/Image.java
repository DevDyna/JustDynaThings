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

  public Image offset(int xo, int yo) {
    this.xo = xo;
    this.yo = yo;
    return this;
  }

  public Image rl(String image) {
    this.rl = image;
    return this;
  }

  public Image rl(String modid,String image) {
    this.modid = modid;
    this.rl = image;
    return this;
  }


  public void render(IGuiHelper h, GuiGraphics g) {
    h.drawableBuilder(DataGenUtil.getResource(rl,modid), 0, 0, x, y).setTextureSize(x, y).build()
        .draw(g, xo, yo);
  }

}
