package com.burhan.design.pattern.creational.builder;

import java.util.List;

public class Order {
    private List<String> mainCourses;
    private List<String> desserts;
    private List<String> soups;
    private List<String> drinks;
    private List<String> specialInstructions;
    private boolean isPackaged;

    Order (OrderBuilder builder) {
        this.mainCourses = builder.mainCourses;
        this.desserts = builder.desserts;
        this.drinks = builder.drinks;
        this.soups = builder.soups;
        this.specialInstructions = builder.specialInstructions;
        this.isPackaged = builder.isPackaged;
    }

    @Override
    public String toString() {
        return "Order {\n" +
                "mainCourses=" + mainCourses + ",\n" +
                ", desserts=" + desserts + ",\n" +
                ", soups=" + soups + ",\n" +
                ", drinks=" + drinks + ",\n" +
                ", specialInstructions=" + specialInstructions + ",\n" +
                ", isPackaged=" + isPackaged + ",\n" +
                '}';
    }
}
