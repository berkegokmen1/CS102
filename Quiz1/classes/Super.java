public class Super extends Abstract {

  protected String superProperty1;
  private String superProperty2;
  private int num;

  public Super(String m, int s) {
    super(m);
    num = s;
    superProperty1 = "superProperty1";
    superProperty2 = "superProperty2";
  }

  public String getPropertyI1() {
    return superProperty1;
  }

  public String getPropertyI2() {
    return superProperty2;
  }

  public void setPropertyI1(String p) {
    superProperty1 = p;
  }

  public void setPropertyI2(String p) {
    superProperty2 = p;
  }

  public String overrideMe() {
    return "not overriden from super";
  }

  public String toString() {
    return "toString() from super";
  }
}
