package com.structural.design.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Zoo implements Animal {
    private String name;
    private List<Animal> animals;

    public Zoo(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public void walk() {
        System.out.println("Zoo: " + name + " is walking");
        for (Animal animal : animals) {
            animal.walk();
        }
    }
}
