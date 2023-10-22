package com.br.onlineshoppingsystem.domain.shopping;

public class Purchase {
    private Product product;
    private int quantity;

    public Purchase(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void incrementQuantity(int quantity){
        this.quantity += quantity;
    }
    public void decrementQuantity(int quantity){
        this.quantity -= quantity;
    }
}
