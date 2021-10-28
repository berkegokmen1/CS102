package shapes;

import java.awt.Graphics;
import shapes.interfaces.Selectable;

public class Circle extends Shape implements Selectable {

  private int radius;

  public Circle(int x, int y, int radius) {
    super(x, y);
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public String toString() {
    return (
      "Circle" +
      ("[radius=" + radius) +
      (", selected=" + isSelected) +
      (", hit=" + isHit) +
      "]"
    );
  }

  @Override
  public boolean contains(int x, int y) {
    int centerX = getX() + 2 * getRadius();
    int centerY = getY() + 2 * getRadius();

    double a = Math.abs(x - centerX);
    double b = Math.abs(y - centerY);
    double c = Math.sqrt(a * a + b * b);

    return c < radius;
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
  public boolean getHit() {
    return this.isHit;
  }

  @Override
  public void setHit(boolean hit) {
    this.isHit = hit;
  }

  @Override
  public void draw(Graphics g) {
    g.drawOval(x + radius, y + radius, 2 * radius, 2 * radius);
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }
}
