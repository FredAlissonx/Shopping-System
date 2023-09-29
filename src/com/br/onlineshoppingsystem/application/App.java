package com.br.onlineshoppingsystem.application;

import com.br.onlineshoppingsystem.entities.ShoppingSystem;

import java.util.Locale;


public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        ShoppingSystem shoppingSystem = new ShoppingSystem();
        shoppingSystem.run();

    }
}
