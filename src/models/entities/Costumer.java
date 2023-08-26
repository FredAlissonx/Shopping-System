package models.entities;

public class Costumer {
    private String name;
    private String email;
    private String shippingAddress;
    private ShoppingCar shoppingCar;

    public Costumer(){
    }

    public Costumer(String name, String email, String shippingAddress, ShoppingCar shoppingCar) {
        this.name = name;
        this.email = email;
        this.shippingAddress = shippingAddress;
        this.shoppingCar = shoppingCar;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public ShoppingCar getShoppingCar() {
        return shoppingCar;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }
    public void addToShoppingCar(Products product, int quantity){
        shoppingCar.addItem(product, quantity);
    }
    public void removeFromShoppingCar(Products product, int quantity){
        shoppingCar.removeItem(product, quantity);
    }
    public void checkout(){

    }
}
