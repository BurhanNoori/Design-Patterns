package com.burhan.abstractfactory.plans.fuel;

public class BasicFuelPlan implements FuelPlan {
    public double getFuelLimit() {
        return 50.0; // 50 liters
    }

    public double getCostPerLiter() {
        return 1.5;
    }

    public String getFuelType() {
        return "Regular";
    }
}