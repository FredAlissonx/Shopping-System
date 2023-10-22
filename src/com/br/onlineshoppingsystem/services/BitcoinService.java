package com.br.onlineshoppingsystem.services;

import com.br.onlineshoppingsystem.interfaces.PaymentService;

import java.util.InputMismatchException;

public class BitcoinService implements PaymentService {

    @Override
    public void pay(Double orderCost) {
        System.out.println("\n--- BITCOIN ---\n");

        // 03/10/2023 in Reais (Brazil currency)
        int bitCoinValue = 142099;
        double valueToPayInBitcoins = orderCost / bitCoinValue;

        while (true) {
            try {
                System.out.println("Bitcoin value: " + bitCoinValue);
                System.out.println("Value to pay: " + String.format("%.2f", orderCost));
                System.out.println("Bitcoins to pay: " + String.format("%.5f", valueToPayInBitcoins));
                System.out.print("Your wallet: ");
                Long wallet = getScanner().nextLong();

                System.out.print("Payment made ([y] yes), ([n] no) or ([m] to go to menu)? ");
                char paymentMade = getScanner().next().charAt(0);

                if (paymentMade == 'm') return;

                if (paymentMade == 'y') {
                    System.out.println("\nPayment successfully!");
                    break;
                } else System.out.println("\nPlease make payment!");

            } catch (InputMismatchException e) {
                System.out.println("\nPlease a valid information!");
                getScanner().nextLine();
            }
        }
    }
}
