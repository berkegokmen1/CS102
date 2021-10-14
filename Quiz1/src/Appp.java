public class Appp {

  public static void main(String[] args) throws Exception {
    Super super1 = new Super("messageSuper", 31);

    Super sub1 = new Sub("messageSub", 52, 1);

    String prop = super1.superProperty1;
    System.out.println(".superProperty1: " + prop);

    System.out.println(sub1.getPropertyI1());
    System.out.println(sub1.getPropertyI2());

    sub1.setPropertyI1("p1");
    sub1.setPropertyI2("p2");

    // System.out.println(sub1.overrideMe());
    // System.out.println(super1.overrideMe());
    System.out.println(sub1);
    System.out.println(super1);
  }
}
