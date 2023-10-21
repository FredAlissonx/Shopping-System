package com.br.onlineshoppingsystem.application;

import com.br.onlineshoppingsystem.services.ShoppingSystemService;

public class App {
    public static void main(String[] args) {
        try {
            new ShoppingSystemService().run();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
