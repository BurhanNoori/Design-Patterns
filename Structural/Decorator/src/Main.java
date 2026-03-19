/*
* This code demonstrates the Decorator Design Pattern by modeling a pizza ordering system.
* The base pizza can be decorated with various toppings, both vegetarian and non-vegetarian.
* The key conpect or ingredient of the Decorator pattern is that it allows behavior to be added
* dynamically to an object without affecting the behavior of other objects from the same class.
*
* We create a base pizza and then wrap it with different topping decorators.
* We keep on creating new object of the pizza by wrapping it with different toppings.
* Each topping decorator adds its own behavior (topping name and price) while delegating
* the core functionality to the base pizza or previously decorated pizza.
*
* The decorator abstract class implements the same interface as the base pizza, as well as it makes has a relationship
* with the pizza interface. This allows us to treat decorated pizzas and base pizzas uniformly.
*
* Additionally, we have added a new method `isVeg()` to determine if the pizza is vegetarian or not to mimic
* dominos india business logic.
*
* */

// Component
public interface Pizza {
    String getToppings();
    double getPrice();
    boolean isVeg(); // NEW
}

// Base Pizzas
class BasePizza implements Pizza {
    private final boolean veg;

    public BasePizza(boolean veg) {
        this.veg = veg;
    }

    @Override
    public String getToppings() {
        return "cheese, tomato sauce";
    }

    @Override
    public double getPrice() {
        return 50.0;
    }

    @Override
    public boolean isVeg() {
        return veg;
    }
}

// Decorator
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;
    public PizzaDecorator(Pizza pizza) { this.pizza = pizza; }

    @Override
    public String getToppings() { return pizza.getToppings(); }

    @Override
    public double getPrice() { return pizza.getPrice(); }

    @Override
    public boolean isVeg() { return pizza.isVeg(); }
}

// Veg Toppings
class MushroomTopping extends PizzaDecorator {
    public MushroomTopping(Pizza pizza) { super(pizza); }

    @Override
    public String getToppings() { return pizza.getToppings() + ", mushrooms"; }

    @Override
    public double getPrice() { return pizza.getPrice() + 10.0; }

    @Override
    public boolean isVeg() { return true && pizza.isVeg(); } // still veg
}

class PaneerTopping extends PizzaDecorator {
    public PaneerTopping(Pizza pizza) { super(pizza); }

    @Override
    public String getToppings() { return pizza.getToppings() + ", paneer"; }

    @Override
    public double getPrice() { return pizza.getPrice() + 15.0; }

    @Override
    public boolean isVeg() { return true && pizza.isVeg(); }
}

// Non-Veg Topping
class ChickenTopping extends PizzaDecorator {
    public ChickenTopping(Pizza pizza) {
        super(pizza);
        if (pizza.isVeg()) {
            throw new IllegalArgumentException("Cannot add non-veg topping on a veg pizza!");
        }
    }

    @Override
    public String getToppings() { return pizza.getToppings() + ", chicken"; }

    @Override
    public double getPrice() { return pizza.getPrice() + 20.0; }

    @Override
    public boolean isVeg() { return false; }
}

// Client
public class Main {
    public static void main(String[] args) {
        // Veg pizza
        Pizza margherita = new BasePizza(true);
        margherita = new MushroomTopping(margherita);
        margherita = new PaneerTopping(margherita);

        System.out.println("Margherita Toppings: " + margherita.getToppings());
        System.out.println("Price: " + margherita.getPrice());
        System.out.println("Is Veg? " + margherita.isVeg());

        // Non-Veg pizza
        Pizza farmhouse = new BasePizza(false);
        farmhouse = new ChickenTopping(farmhouse);
        farmhouse = new MushroomTopping(farmhouse);

        System.out.println("Farmhouse Toppings: " + farmhouse.getToppings());
        System.out.println("Price: " + farmhouse.getPrice());
        System.out.println("Is Veg? " + farmhouse.isVeg());

        // ❌ This will throw exception
        Pizza wrongPizza = new BasePizza(true);
        wrongPizza = new ChickenTopping(wrongPizza);
    }
}
