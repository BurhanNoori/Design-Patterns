package com.burhan.abstractfactory.demo;

import com.burhan.abstractfactory.factories.EconomyPackageFactory;
import com.burhan.abstractfactory.factories.LuxuryPackageFactory;
import com.burhan.abstractfactory.service.RentalService;

class RentalDemo {
    public static void main(String[] args) {
        RentalService rentalService = new RentalService();

        // Create Economy Package
        System.out.println("Creating Economy Package:");
        rentalService.createRentalPackage(new EconomyPackageFactory());
        rentalService.displayPackageDetails();
        rentalService.startRental();

        // Create Luxury Package
        System.out.println("\nCreating Luxury Package:");
        rentalService.createRentalPackage(new LuxuryPackageFactory());
        rentalService.displayPackageDetails();
        rentalService.startRental();
    }
}