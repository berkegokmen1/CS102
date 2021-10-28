package gui.shapes;

import gui.BalloonsGamePanel;
import shapes.Circle;

public class Balloon extends Circle {

  public static final int GROW_AMOUNT = 1;
  private static final int RADIUS = 100;
  private static final int MAX_RADIUS = 200;

  public Balloon(int x, int y) {
    super(x, y, BalloonsGamePanel.R.nextInt(RADIUS));
  }

  public void grow() {
    int r = this.getRadius();

    if (r >= MAX_RADIUS) {
      this.setSelected(true);
      this.setRadius(0);
    } else {
      this.setRadius(r + GROW_AMOUNT);
    }
  }
}
