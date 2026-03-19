package com.burhan.abstractfactory.factories;


import com.burhan.abstractfactory.plans.fuel.BasicFuelPlan;
import com.burhan.abstractfactory.plans.fuel.FuelPlan;
import com.burhan.abstractfactory.plans.insurance.BasicInsurance;
import com.burhan.abstractfactory.plans.insurance.Insurance;
import com.burhan.abstractfactory.plans.vehicle.EconomyCar;
import com.burhan.abstractfactory.plans.vehicle.Vehicle;

public class EconomyPackageFactory implements RentalFactory {
    public Vehicle createVehicle() {
        return new EconomyCar();
    }

    public Insurance createInsurance() {
        return new BasicInsurance();
    }

    public FuelPlan createFuelPlan() {
        return new BasicFuelPlan();
    }
}
