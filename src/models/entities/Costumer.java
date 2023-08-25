package models.entities;

public class Costumer {
    private String name;
    private String email;
    private String shippingAddress;
    private ShoppingCart shoppingCart;

    public Costumer(){
    }

    public Costumer(String name, String email, String shippingAddress, ShoppingCart shoppingCart) {
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

    public String getShippingAddress() {
        return shippingAddress;
    }
    public Products addToShoppingCart(Products product){
        return product;
    }
    public Products removeFromShoppingCart(Products product){
        return product;
    }
    public void checkout(){

    }
}
