package com.burhan.abstractfactory.service;

import com.burhan.abstractfactory.factories.RentalFactory;
import com.burhan.abstractfactory.plans.fuel.FuelPlan;
import com.burhan.abstractfactory.plans.insurance.Insurance;
import com.burhan.abstractfactory.plans.vehicle.Vehicle;

public class RentalService {
    private Vehicle vehicle;
    private Insurance insurance;
    private FuelPlan fuelPlan;

    public void createRentalPackage(RentalFactory factory) {
        vehicle = factory.createVehicle();
        insurance = factory.createInsurance();
        fuelPlan = factory.createFuelPlan();
    }

    public void displayPackageDetails() {
        System.out.println("\nRental Package Details:");
        System.out.println("com.burhan.abstractfactory.plans.BasicInsurance.Vehicle Daily Rate: $" + vehicle.getDailyRate());
        System.out.println("com.burhan.abstractfactory.plans.BasicInsurance.Vehicle Capacity: " + vehicle.getCapacity() + " persons");
        System.out.println("com.burhan.abstractfactory.plans.insurance.Insurance Coverage: $" + insurance.getCoverageAmount());
        System.out.println("com.burhan.abstractfactory.plans.insurance.Insurance Type: " + insurance.getCoverageType());
        System.out.println("com.burhan.abstractfactory.plans.insurance.Insurance Premium: $" + insurance.getDailyPremium() + " per day");
        System.out.println("Fuel Limit: " + fuelPlan.getFuelLimit() + " liters");
        System.out.println("Fuel Type: " + fuelPlan.getFuelType());
        System.out.println("Fuel Cost: $" + fuelPlan.getCostPerLiter() + " per liter");
    }

    public void startRental() {
        vehicle.startEngine();
    }
}