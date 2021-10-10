public abstract class Creature {

  private String name;

  public Creature(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String getClassName() {
    return this.getClass().toString();
  }

  public String getSuperClassName() {
    return super.getClass().toString();
  }

  public abstract String getAbilities();
}
