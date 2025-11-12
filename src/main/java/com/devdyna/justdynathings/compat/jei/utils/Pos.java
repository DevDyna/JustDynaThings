package com.devdyna.justdynathings.compat.jei.utils;

public class Pos {

    private int x0;
    private int y0;
    private int x1 = 0;
    private int y1 = 0;

    public Pos(int x, int y) {
        this.x0 = x;
        this.y0 = y;
    }

    public Pos setSize(int x, int y) {
        this.x1 = x0 + x;
        this.y1 = y0 + y;
        return this;
    }

    public int getX0() {
        return x0;
    }

    public int getX1() {
        return x1;
    }

    public int getY0() {
        return y0;
    }

    public int getY1() {
        return y1;
    }

    public boolean test(int x, int y) {
        return x0 <= x && x < x1 && y0 <= y && y < y1;
    }

    public boolean test(double x, double y) {
        x = (int) x;
        y = (int) y;
        return x0 <= x && x < x1 && y0 <= y && y < y1;
    }

    public static Pos of(int x0, int y0, int x1, int y1) {
        return new Pos(x0, y0).setSize(x1, y1);
    }

    public static Pos of(int x, int y) {
        return new Pos(x, y);
    }

}