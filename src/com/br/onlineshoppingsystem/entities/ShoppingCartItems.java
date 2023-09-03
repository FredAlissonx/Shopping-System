package com.br.onlineshoppingsystem.entities;

public class ShoppingCartItems {
    private Products product;
    private int quantity;

    public ShoppingCartItems(Products product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Products getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void incrementQuantity(int amount){
        quantity += amount;
    }
    public void decrementQuantity(int amount){
        quantity -= amount;
    }
}
