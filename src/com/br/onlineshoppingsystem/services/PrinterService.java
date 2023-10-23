package com.br.onlineshoppingsystem.services;

import com.br.onlineshoppingsystem.domain.shopping.Product;
import com.br.onlineshoppingsystem.domain.shopping.Purchase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrinterService {

    //To print a menu more separately
    public static void printMenu() {
        System.out.println();
        System.out.println("    ╔═══════════════════════════════╗");
        System.out.println("    ║                               ║");
        System.out.println("    ║   WELCOME TO SHOPPING SYSTEM  ║");
        System.out.println("    ║                               ║");
        System.out.println("    ╚═══════════════════════════════╝");

        System.out.println("\n-- To create a personalized cart for you, we need you sign up --\n");
    }


    //To print actions options
    public static <T extends Enum<T>> void print(T[] enums) {
        Arrays.stream(enums).forEach(e -> System.out.println((Arrays.stream(enums)
                .collect(Collectors.toList())
                .indexOf(e) + 1) + "." + e));
    }

    //Print title with statement corresponding
    public static void printTitle(String title, String statement) {
        System.out.println(title);
        System.out.println(statement);
    }

    public static void printProducts(List<Product> products) {
        System.out.println("\n -------------- -------------------");
        ;
        products.forEach(p -> System.out.println((products.indexOf(p) + 1) + ". " + p.getName() + " - " + p.getDescription() + " $" + p.getPrice()));
    }

    public static void printPurchases(List<Purchase> purchases) {
        purchases.forEach(p -> System.out.println((purchases.indexOf(p) + 1) +
                ". " + p.getProduct().getName() + " (Qty: " + p.getQuantity() + ")"));
        System.out.println((purchases.size() + 1) + ". Back to menu");
    }

}
