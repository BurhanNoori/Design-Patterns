package com.burhan.abstractfactory.plans.vehicle;

public class LuxuryCar implements Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Luxury Car Start...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Luxury Car stop...");
    }

    @Override
    public int getCapacity() {
        return 2;
    }

    @Override
    public double getDailyRate() {
        return 10000;
    }
}
