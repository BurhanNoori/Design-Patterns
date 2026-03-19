/*What is it?

The Flyweight pattern is all about memory optimization.
Imagine you’re making a game with 10,000 trees. Each tree has:

a type (oak, pine, mango, etc.),

color,

texture,

position (x, y).

If you create 10,000 full objects, memory explodes because each one carries the same texture/color data.

The Flyweight pattern solves this by:

Separating intrinsic state (shared, common across many objects → e.g., tree type, texture, color).

Separating extrinsic state (unique per object → e.g., x,y position).

So instead of 10,000 heavy objects, you store only a few “shared” objects, and pass in the unique data when needed.

Where is it used?

Game engines (trees, bullets, particles).

Text editors (characters share font/format but differ by position).

GUI libraries (buttons, icons reused).

What if it didn’t exist?

Programs needing thousands or millions of similar objects would waste huge amounts of memory.

Performance would degrade due to object duplication.
*/

import java.util.*;

// Flyweight object: stores intrinsic (shared) state
class TreeType {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing " + name + " tree at (" + x + "," + y + ")"
                + " with color " + color + " and texture " + texture);
    }
}

// Flyweight Factory: ensures reuse of shared objects
class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;
        treeTypes.putIfAbsent(key, new TreeType(name, color, texture));
        return treeTypes.get(key);
    }
}

// Context object: holds extrinsic state
class Tree {
    private int x, y;
    private TreeType type; // shared flyweight

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}

public class FlyweightDemo {
    public static void main(String[] args) {
        List<Tree> forest = new ArrayList<>();

        // Only 2 flyweights are created even for 5 trees
        forest.add(new Tree(10, 20, TreeFactory.getTreeType("Oak", "Green", "Rough")));
        forest.add(new Tree(15, 25, TreeFactory.getTreeType("Oak", "Green", "Rough")));
        forest.add(new Tree(20, 30, TreeFactory.getTreeType("Pine", "Dark Green", "Smooth")));
        forest.add(new Tree(25, 35, TreeFactory.getTreeType("Pine", "Dark Green", "Smooth")));
        forest.add(new Tree(30, 40, TreeFactory.getTreeType("Oak", "Green", "Rough")));

        for (Tree tree : forest) {
            tree.draw();
        }
    }
}
