package com.burhan.abstractfactory.plans.insurance;

import com.burhan.abstractfactory.plans.fuel.FuelPlan;

public class BasicInsurance implements Insurance {
    public double getCoverageAmount() {
        return 50000.0;
    }

    public String getCoverageType() {
        return "Third Party Only";
    }

    public double getDailyPremium() {
        return 5.0;
    }

}