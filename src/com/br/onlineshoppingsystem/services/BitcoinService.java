
package com.br.onlineshoppingsystem.services;

import com.br.onlineshoppingsystem.interfaces.PaymentService;
import com.br.onlineshoppingsystem.interfaces.Validatable;

public class BitcoinService implements PaymentService, Validatable {

    @Override
    public void pay(Double cost) {

        System.out.println("\n--- BITCOIN ---\n");

        // 03/10/2023 in Reais (Brazil currency)
        int bitcoinValue = 142099;
        double valueToPay = cost / bitcoinValue;

        System.out.println("Bitcoin value: " + bitcoinValue);
        System.out.println("Value to pay: " + String.format("%.2f", cost));
        System.out.println("Bitcoins to pay: " + String.format("%.5f", valueToPay));

        System.out.print("Your wallet: ");
        Long wallet = getScanner().nextLong();
        if (!validWallet(wallet, valueToPay)) throw new RuntimeException("No money in the wallet!");

    }
}
