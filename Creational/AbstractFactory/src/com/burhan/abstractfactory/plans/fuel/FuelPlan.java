package com.burhan.abstractfactory.plans.fuel;

public interface FuelPlan {
    double getFuelLimit();
    double getCostPerLiter();
    String getFuelType();
}
