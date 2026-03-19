/*
 * A composite pattern example where a Zoo contains multiple Animals.
 * Animal is an interface implemented by both individual animals (like Lion, Tiger) and the composite (Zoo).
 * In composite pattern, a group of objects is treated the same way as a single instance of an object.
 * The intent of a composite is to "compose" objects into tree structures to represent part-whole hierarchies.
 * This allows clients to treat individual objects and compositions of objects uniformly.
 * Here, the Zoo class can contain multiple Animal objects, and when the walk method is called on the Zoo,
 * it delegates the call to each Animal it contains.
 * So clients can interact with a Zoo just like they would with a single Animal.
 */

import com.structural.design.pattern.composite.Lion;
import com.structural.design.pattern.composite.Tiger;
import com.structural.design.pattern.composite.Zoo;

public class Main {
    public static void main(String[] args) {

        Tiger tiger = new Tiger();
        Lion lion = new Lion();
        Zoo zoo = new Zoo("Bannerghatta National Park");
        zoo.addAnimal(tiger);
        zoo.addAnimal(lion);

        zoo.walk();
    }
}