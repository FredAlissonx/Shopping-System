package models.entities;

public class ShoppingCarItems {
    private Products product;
    private int quantity;

    public ShoppingCarItems(Products product, int quantity) {
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
}
