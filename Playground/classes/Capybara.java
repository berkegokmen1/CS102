public class Capybara extends Animal {

  private int chewPower;

  public Capybara(String name, int age, int chewPower) {
    super(name, age);
    this.chewPower = chewPower;
  }

  public String getAbilities() {
    return this.getName() + ", Capybara can chew";
  }

  public String getNameTest() {
    return (
      ("super.getName(): " + super.getName()) +
      ("this.getName(): " + this.getName()) +
      ("getName(): " + getName())
    );
  }

  @Override
  public String method() {
    return super.method() + "\nmethod from child class (Capybara)";
  }

  public int getChewPower() {
    return chewPower;
  }
}
