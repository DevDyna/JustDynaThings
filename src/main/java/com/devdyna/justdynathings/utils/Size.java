package com.devdyna.justdynathings.utils;

public class Size {

  private int x;
  private int y;

  public Size(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static Size of(int x, int y) {
    return new Size(x, y);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

}
