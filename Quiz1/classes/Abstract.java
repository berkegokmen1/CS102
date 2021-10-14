public abstract class Abstract implements Interface1, Interface2 {

  private String abstractProperty;

  public Abstract(String m) {
    abstractProperty = "abstractProperty + message: " + m;
  }

  public String getAbstractProperty() {
    return abstractProperty;
  }
}
