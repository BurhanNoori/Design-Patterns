package com.burhan.abstractfactory.factories;


import com.burhan.abstractfactory.plans.fuel.FuelPlan;
import com.burhan.abstractfactory.plans.insurance.Insurance;
import com.burhan.abstractfactory.plans.vehicle.Vehicle;

public interface RentalFactory {
    Vehicle createVehicle();
    Insurance createInsurance();
    FuelPlan createFuelPlan();
}
