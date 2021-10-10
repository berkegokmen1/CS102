public class Bird extends Animal {

  private boolean canFly;

  public Bird(String name, int age, boolean canFly) {
    super(name, age);
    this.canFly = canFly;
  }

  public String getAbilities() {
    return this.getName() + ", Bird can fly";
  }

  public String getNameTest() {
    return (
      ("super.getName(): " + super.getName() + "\n") +
      ("this.getName(): " + this.getName() + "\n") +
      ("getName(): " + getName())
    );
  }

  public boolean canFly() {
    return canFly;
  }
}
