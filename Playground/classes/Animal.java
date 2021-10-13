public class Animal extends Creature {

  private int age;

  public Animal(String name, int age) {
    super(name);
    this.age = age;
  }

  public String getAbilities() {
    return "Normal animal abilities";
  }

  public int getAge() {
    return this.age;
  }

  public String method() {
    return "method from super class (Animal)";
  }

  public String toString() {
    return (
      ("name and age: " + this.getName() + " " + this.getAge() + "\n") +
      ("this.getClass(): " + this.getClass() + "\n") +
      ("super.getClass(): " + super.getClass())
    );
  }
}
