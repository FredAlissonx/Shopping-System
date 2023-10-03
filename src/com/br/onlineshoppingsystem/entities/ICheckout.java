package com.br.onlineshoppingsystem.entities;

import java.util.Scanner;

public interface ICheckout {
    Scanner sc = new Scanner(System.in);
    default void creditCard(){

        System.out.println("\n--- Credit cart ---");
        long cardNumber;
        while (true){
            System.out.print("\nCard number: ");

            String numberInput = sc.next();


            try {
                System.out.print("\nCard number: ");

                cardNumber = Long.parseLong(numberInput);
                break;

            }catch (NumberFormatException e){
                System.out.println("Please a valid credit card!");
            }
        }
    }
}
