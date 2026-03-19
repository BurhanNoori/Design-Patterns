import com.burhan.design.pattern.creational.builder.Order;
import com.burhan.design.pattern.creational.builder.OrderBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Order order1 = new OrderBuilder(Arrays.asList("Chicken Mughalai", "3 Butter Garlic Naan"))
                .addDrinks(Arrays.asList("Coke", "Water"))
                .addDesserts(Arrays.asList("Gulab Jamun", "Ice Cream"))
                .setPackage(true)
                .build();

        System.out.println("Order 1:");
        System.out.println(order1);

        // Example 2: Using List constructor
        List<String> mainCourses = Arrays.asList("Biryani", "Raita");
        Order order2 = new OrderBuilder(mainCourses)
                .addSoups(Arrays.asList("Tomato Soup", "Sweet Corn Soup"))
                .addInstructions(Arrays.asList("Make it spicy", "Extra gravy"))
                .build();
        System.out.println("\nOrder 2:");
        System.out.println(order2);
    }
}