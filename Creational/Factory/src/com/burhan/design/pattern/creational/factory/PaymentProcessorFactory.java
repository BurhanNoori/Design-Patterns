package com.burhan.design.pattern.creational.factory;

public class PaymentProcessorFactory {
    public static PaymentProcessor getProcessor(String type) {
        switch (type.toLowerCase()) {
            case "credit":
                return new CreditCardProcessor();
            case "upi":
                return new UPIPaymentProcessor();
            default:
                throw new IllegalArgumentException("Unknown payment type");
        }
    }
}