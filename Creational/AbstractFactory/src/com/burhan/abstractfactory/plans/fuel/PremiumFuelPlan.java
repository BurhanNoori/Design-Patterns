package com.burhan.abstractfactory.plans.fuel;

public class PremiumFuelPlan implements FuelPlan {
    public double getFuelLimit() {
        return 80.0; // 80 liters
    }

    public double getCostPerLiter() {
        return 1.2; // Discounted rate
    }

    public String getFuelType() {
        return "Premium";
    }
}