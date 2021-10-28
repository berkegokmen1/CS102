package shapes.interfaces;

public interface Selectable {
  public boolean getSelected();

  public boolean getHit();

  public void setSelected(boolean selected);

  public void setHit(boolean hit);

  public boolean contains(int x, int y);
}
