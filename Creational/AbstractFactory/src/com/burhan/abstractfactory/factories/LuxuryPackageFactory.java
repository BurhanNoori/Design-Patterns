package com.burhan.abstractfactory.factories;

import com.burhan.abstractfactory.plans.fuel.FuelPlan;
import com.burhan.abstractfactory.plans.fuel.PremiumFuelPlan;
import com.burhan.abstractfactory.plans.insurance.Insurance;
import com.burhan.abstractfactory.plans.insurance.PremiumInsurance;
import com.burhan.abstractfactory.plans.vehicle.LuxuryCar;
import com.burhan.abstractfactory.plans.vehicle.Vehicle;

public class LuxuryPackageFactory implements RentalFactory {
    public Vehicle createVehicle() {
        return new LuxuryCar();
    }

    public Insurance createInsurance() {
        return new PremiumInsurance();
    }

    public FuelPlan createFuelPlan() {
        return new PremiumFuelPlan();
    }
}