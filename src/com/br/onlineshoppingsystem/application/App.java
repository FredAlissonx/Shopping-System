package com.br.onlineshoppingsystem.application;

import com.br.onlineshoppingsystem.entities.Costumer;
import com.br.onlineshoppingsystem.entities.Process;
import com.br.onlineshoppingsystem.entities.ShoppingCart;
import com.br.onlineshoppingsystem.categories.Books;
import com.br.onlineshoppingsystem.categories.Clothing;
import com.br.onlineshoppingsystem.categories.Eletronics;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Process process = new Process();
        Books book = new Books();
        Clothing clothing = new Clothing();
        Eletronics eletronics = new Eletronics();
        Costumer costumer;
        System.out.println("To create a personalized cart for you, we need you sign up:");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        int address = 0;
        while (true) {
            try{
                System.out.print("Shipping address (CEP/ZIP code): ");
                address = sc.nextInt();
                break;
            }catch (InputMismatchException e){

                System.out.println("Please just numbers!");
                sc.nextLine();

            }
        }


        System.out.println("Welcome to the Online Shopping System!");

        costumer = new Costumer(name, email, address, new ShoppingCart());


        while (true) {

            process.menu();
            int choiceFromMenuOptions = sc.nextInt();
            sc.nextLine();

            if (choiceFromMenuOptions == 6) {
                process.exit();
                break;
            }

            switch (choiceFromMenuOptions) {
                case 1 -> process.viewProducts(eletronics, book, clothing);
                case 2 -> process.addToCart(eletronics, book, clothing, costumer);
                case 3 -> process.viewCart(costumer);
                case 4 -> process.removeItemFromCart(eletronics, book, clothing, costumer);
                case 5 -> process.checkout(costumer);
            }
        }
    }
}
