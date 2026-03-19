package com.burhan.design.pattern.creational.factory;

public class CreditCardProcessor implements PaymentProcessor {
    public void doPayment(double amount) {
        System.out.println("Processing $" + amount + " via Credit Card");
    }
}