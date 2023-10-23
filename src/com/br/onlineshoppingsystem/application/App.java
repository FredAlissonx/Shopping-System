
package com.br.onlineshoppingsystem.application;

import com.br.onlineshoppingsystem.services.ShoppingSystemService;

public class App {

    public static void main(String[] args) {
        try {
            //Calling the method directly, so as not create object instance in the method
            new ShoppingSystemService().run();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
