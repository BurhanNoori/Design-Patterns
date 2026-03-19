package com.burhan.abstractfactory.plans.vehicle;

public class EconomyCar implements Vehicle {
    public void startEngine() {
        System.out.println("Economy Car Start...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Economy Car Stop...");
    }

    @Override
    public int getCapacity() {
        return 4;
    }

    @Override
    public double getDailyRate() {
        return 500;
    }

}
