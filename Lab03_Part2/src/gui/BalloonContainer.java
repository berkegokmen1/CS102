package gui;

import gui.shapes.Balloon;
import shapes.ShapeContainer;

public class BalloonContainer extends ShapeContainer {

  public void grow() {
    this.getShapes()
      .forEach(s -> {
        ((Balloon) s).grow();

        // To make the balloon grow from the center
        int x = s.getX() - Balloon.GROW_AMOUNT * 2;
        int y = s.getY() - Balloon.GROW_AMOUNT * 2;

        s.setLocation(x, y);
      });
  }
}
