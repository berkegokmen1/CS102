package shapes;

import java.awt.Graphics;
import shapes.interfaces.Selectable;

public class Rectangle extends Shape implements Selectable {

  private int width;
  private int height;

  // private int sides;

  public Rectangle(int x, int y, int width, int height) {
    super(x, y);
    this.width = width;
    this.height = height;
  }

  public double getArea() {
    return width * height;
  }

  @Override
  public String toString() {
    return (
      "Rectangle" +
      ("[height=" + height) +
      (", width=" + width) +
      (", selected=" + isSelected) +
      "]"
    );
  }

  @Override
  public boolean getSelected() {
    return this.isSelected;
  }

  @Override
  public void setSelected(boolean selected) {
    this.isSelected = selected;
  }

  @Override
  public boolean contains(int x, int y) {
    double cornerX = this.x;
    double cornerY = this.y;

    return (
      (x > cornerX && x < cornerX + width) &&
      (y > cornerY && y < cornerY + height)
    );
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public void draw(Graphics g) {}

  @Override
  public boolean getHit() {
    return false;
  }

  @Override
  public void setHit(boolean hit) {}
}
