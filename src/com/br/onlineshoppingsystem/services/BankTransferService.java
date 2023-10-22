package com.br.onlineshoppingsystem.services;

import com.br.onlineshoppingsystem.interfaces.PaymentService;

public class BankTransferService implements PaymentService {
    @Override
    public void pay(Double orderCost) {

        System.out.println("\n--- Bank Transfer ---");

        // Agency
        System.out.print("\nAgency: ");
        long agencyInput = getScanner().nextLong();

        System.out.println("Value to pay: " + String.format("%.2f", orderCost));
        System.out.println("Payment successfull!");


    }
}

