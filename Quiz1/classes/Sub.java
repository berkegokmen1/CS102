public class Sub extends Super {

  protected int random;

  public Sub(String m, int n, int r) {
    super(m, n);
    random = r;
  }

  @Override
  public String overrideMe() {
    return super.overrideMe() + "\noverriden from sub class";
  }

  @Override
  public String toString() {
    return "toString() from sub";
  }
}
