package com.br.onlineshoppingsystem.domain;

import com.br.onlineshoppingsystem.entities.Products;
import com.br.onlineshoppingsystem.entities.ShoppingCart;

public class Costumer {
    private String name;
    private String email;
    private Long shippingAddress;
    private ShoppingCart shoppingCart;

    public Costumer(){
    }

    public Costumer(String name, String email, Long shippingAddress, ShoppingCart shoppingCart) {
        this.name = name;
        this.email = email;
        this.shippingAddress = shippingAddress;
        this.shoppingCart = shoppingCart;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public long getShippingAddress() {
        return shippingAddress;
    }
    public void addToShoppingCart(Products product, int quantity){
        shoppingCart.addItem(product, quantity);
    }
}
