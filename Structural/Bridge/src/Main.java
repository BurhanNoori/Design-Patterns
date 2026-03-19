/**
 * Main class to demonstrate the Bridge design pattern.
 * The Bridge pattern is used to separate the abstraction from its implementation
 * so that the two can vary independently. It is mostly used where we have m x n combinations
 * of classes. Instead of implementing all the possible classes, we can bridge the
 * abstraction and implementation using composition.
 * This example shows a simple implementation of the Bridge pattern.
 * The main method creates instances of the abstraction and implementation
 * and demonstrates their interaction.
 */

// Implementor
interface Color {
    void applyColor();
}

// Concrete Implementations
class Red implements Color {
    public void applyColor() { System.out.println("Red color"); }
}

class Blue implements Color {
    public void applyColor() { System.out.println("Blue color"); }
}

// Abstraction
abstract class Shape {
    protected Color color;  // Bridge

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

// Refined Abstractions
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }
    @Override
    void draw() {
        System.out.print("Drawing Circle in ");
        color.applyColor();
    }
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }
    @Override
    void draw() {
        System.out.print("Drawing Square in ");
        color.applyColor();
    }
}


public class Main {

    // Client
    public static void main(String[] args) {

        Shape redCircle = new Circle(new Red());
        Shape blueSquare = new Square(new Blue());

        redCircle.draw();   // Drawing Circle in Red color
        blueSquare.draw();  // Drawing Square in Blue color
    }


/*
Now notice:

If you add a new Shape (e.g., Triangle), you don’t touch the Color classes.

If you add a new Color (e.g., Green), you don’t touch the Shape classes.

They grow independently.

This is the decoupling that Bridge achieves.
 */

}