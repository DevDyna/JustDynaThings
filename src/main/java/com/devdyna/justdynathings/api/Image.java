package com.devdyna.justdynathings.api;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;

//TODO port to api
public class Image {

    private int x;
    private int y;
    private String rl;
    private String modid = MODULE_ID;
    private int xo = 0;
    private int yo = 0;
    private int tx = x;
    private int ty = y;

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

    public Image sizeTexture(int tx, int ty) {
        this.tx = tx;
        this.ty = ty;
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

    public Image rl(Identifier rl) {
        this.modid = rl.getNamespace();
        this.rl = rl.getPath();
        return this;
    }

    public void render(GuiGraphicsExtractor g) {

        g.blit(
                RenderPipelines.GUI_TEXTURED,
                com.devdyna.cakesticklib.api.utils.x.rl(modid, rl),
                xo - 1,
                yo - 1,
                u, v,
                x, y,
                tx, ty);

    }

}