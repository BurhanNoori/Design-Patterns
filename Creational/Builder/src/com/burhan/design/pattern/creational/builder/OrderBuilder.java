package com.burhan.design.pattern.creational.builder;

import java.util.List;

public class OrderBuilder {

    List<String> mainCourses;
    List<String> desserts;
    List<String> soups;
    List<String> drinks;
    List<String> specialInstructions;
    boolean isPackaged;

    public OrderBuilder(List<String> mainCourses) {
        this.mainCourses = mainCourses;
    }

    public OrderBuilder addDesserts(List<String> desserts) {
        this.desserts = desserts;
        return this;
    }

    public OrderBuilder addSoups(List<String> soups) {
        this.soups = soups;
        return this;
    }

    public OrderBuilder addDrinks(List<String> drinks) {
        this.drinks = drinks;
        return this;
    }

    public OrderBuilder addInstructions(List<String> instructions) {
        this.specialInstructions = instructions;
        return this;
    }

    public OrderBuilder setPackage(boolean isPackaged) {
        this.isPackaged = isPackaged;
        return this;
    }

    public Order build() {
        return new Order(this);
    }
}
