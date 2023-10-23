package com.br.onlineshoppingsystem.interfaces;

import java.util.Scanner;

@FunctionalInterface
public interface PaymentService {
    void pay(Double orderCost);

    default Scanner getScanner() {
        return new Scanner(System.in);
    }

}
