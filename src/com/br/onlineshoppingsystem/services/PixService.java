package com.br.onlineshoppingsystem.services;

import com.br.onlineshoppingsystem.interfaces.PaymentService;

public class PixService implements PaymentService {

    @Override
    public void pay(Double orderCost) {

        System.out.println("\n--- PIX ---");

        // PIX key to get the payment done
        System.out.println("PIX key: 123456678");

        System.out.println("Value to pay: " + String.format("%.2f", orderCost));
        System.out.println("\nPayment successfully!");

    }
}
