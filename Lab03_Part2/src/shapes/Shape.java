package shapes;

import shapes.interfaces.Drawable;
import shapes.interfaces.Locatable;

public abstract class Shape implements Locatable, Drawable {

  protected int x;
  protected int y;

  protected boolean isSelected;
  protected boolean isHit;

  public Shape(int x, int y) {
    this.x = x;
    this.y = y;
    isSelected = false;
    isHit = false;
  }

  public abstract double getArea();

  public abstract boolean contains(int x, int y);

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public void setLocation(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
