public class Cow extends Animal {

  private int milkQuality;

  public Cow(String name, int age, int milkQuality) {
    super(name, age);
    this.milkQuality = milkQuality;
  }

  public String getNameTest() {
    return (
      ("super.getName(): " + super.getName() + "\n") +
      ("this.getName(): " + this.getName() + "\n") +
      ("getName(): " + getName())
    );
  }

  public int getMilkQuality() {
    return milkQuality;
  }
}
