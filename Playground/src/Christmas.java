public class Christmas extends Holiday {

  public int treeSize;

  public Christmas(String n, int treeSize) {
    super(n);
  }

  public void celebrate() {
    System.out.println("Happy xmas!");
  }

  public void getTree() {
    System.out.println("*\n* *\n* * *\n* * * *\n* * * * *");
  }
}
