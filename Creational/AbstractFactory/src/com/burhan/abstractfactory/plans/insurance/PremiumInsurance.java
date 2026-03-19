package com.burhan.abstractfactory.plans.insurance;

public class PremiumInsurance implements Insurance {
    public double getCoverageAmount() {
        return 200000.0;
    }

    public String getCoverageType() {
        return "Comprehensive Coverage";
    }

    public double getDailyPremium() {
        return 15.0;
    }
}