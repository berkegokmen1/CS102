package shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import shapes.interfaces.Drawable;
import shapes.interfaces.Selectable;

public class ShapeContainer implements Drawable {

  final List<Shape> shapes = new ArrayList<Shape>();

  protected List<Shape> getShapes() {
    return shapes;
  }

  public void add(Shape s) {
    shapes.add(s);
  }

  public double getArea() {
    double total = 0;

    for (Shape s : shapes) {
      total += s.getArea();
    }

    return total;
  }

  @Override
  public String toString() {
    String result = "";

    for (Shape s : shapes) {
      result += s + "\n";
    }

    return result;
  }

  public Shape findFirstContains(int x, int y) {
    removeSelected();

    Shape result = null;
    boolean found = false;

    for (int i = 0; i < shapes.size() && !found; i++) {
      Shape s = shapes.get(i);

      if (s.contains(x, y)) {
        result = s;
        found = true;
      }
    }

    return result;
  }

  public int size() {
    return shapes.size();
  }

  public int removeSelected() {
    int removedCount = 0;

    for (int i = 0; i < shapes.size(); i++) {
      Shape s = shapes.get(i);
      boolean checkSelected = ((Selectable) s).getSelected();

      if (checkSelected) {
        shapes.remove(s);
        boolean checkHit = ((Selectable) s).getHit();
        if (checkHit) {
          removedCount += 1;
        }
      }
    }

    return removedCount;
  }

  public int selectAllAt(int x, int y) {
    int res = 0;
    for (int i = 0; i < shapes.size(); i++) {
      Selectable s = (Selectable) shapes.get(i);
      if (s.contains(x, y)) {
        s.setSelected(true);
        s.setHit(true);

        res += 1;
      }
    }

    return res;
  }

  @Override
  public void draw(Graphics g) {
    for (int i = 0; i < shapes.size(); i++) {
      ((Circle) shapes.get(i)).draw(g);
    }
  }
}
