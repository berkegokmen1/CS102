import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

  public static void main(String[] args) throws Exception {
    // Cannot instantiate type Creature (abstract class)
    // Creature c = new Creature();

    // Animal animal = new Animal("normal animal", 18);
    // Animal animalBird = new Bird("animalBird", 9, true);
    // Animal animalCapybara = new Capybara("animalCapy", 31, 300);
    // Animal animalCow = new Cow("animalCow", 1, 200);

    // Animal a1, a2, a3;

    // a1 = new Bird("a", 1, true);
    // a2 = new Capybara("name", 22, 39843);
    // a3 = new Cow("name", 1, 232);

    // Animal[] arr = { a1, a2, a3 };

    // for (Animal a : arr) {
    //   System.out.println(a);
    // }
    // Bird bird = new Bird("birdBird", 22, false);
    // Capybara capybara = new Capybara("capyCapy", 11, 123);
    // Cow cow = new Cow("cowCow", 36, 100);
    // System.out.println(animal.method());
    // System.out.println("animal instanceof Creature: " + (animal instanceof Creature));
    // System.out.println("bird instanceof Creature: " + (bird instanceof Creature));

    // System.out.println(animalBird + "\n" + ((Bird) animalBird).getNameTest() + "\n");
    // System.out.println("animalBird.getClassName() " + animalBird.getClassName() + "\n");
    // System.out.println(bird + "\n" + bird.getNameTest() + "\n");
    // System.out.println("bird.getClassName() " + bird.getClassName() + "\n");

    // Holiday xmas = new Christmas("1 feb", 1);
    // Holiday hol = new Holiday("12 april");
    // Christmas realXmas = new Christmas("1 feb", 5);

    // realXmas.getTree();
    // ((Christmas) xmas).getTree();

    // xmas.celebrate();
    // hol.celebrate();

    InterfaceTest it1 = new InterfaceTest(1);
    InterfaceTest it2 = new InterfaceTest(2);
    InterfaceTest it3 = new InterfaceTest(3);
    InterfaceTest it4 = new InterfaceTest(4);

    List<InterfaceTest> arr = new ArrayList<InterfaceTest>(4);

    arr.add(it4);
    arr.add(it1);
    arr.add(it3);
    arr.add(it2);

    Collections.sort(arr);

    System.out.println(arr);
  }
}
