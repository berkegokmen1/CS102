package shapes;

public class Square extends Rectangle {

  public Square(int x, int y, int length) {
    super(x, y, length, length);
  }

  @Override
  public String toString() {
    return (
      "Square" +
      ("[length=" + this.getWidth()) +
      (", selected=" + isSelected) +
      "]"
    );
  }
}
