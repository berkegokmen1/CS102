public class InterfaceTest implements Comparable<InterfaceTest> {

  private int value;

  public InterfaceTest(int v) {
    value = v;
  }

  @Override
  public int compareTo(InterfaceTest o) {
    if (value > o.value) {
      return 1;
    } else if (value < o.value) {
      return -1;
    }

    return 0;
  }

  public String toString() {
    return value + "";
  }
}
