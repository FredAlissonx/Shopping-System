package models.entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ShoppingCartItems> items = new ArrayList<>();
    public ShoppingCart(){
    }

    public ShoppingCart(List<ShoppingCartItems> items) {
        this.items = items;
    }

    public List<ShoppingCartItems> getItems() {
        return items;
    }

    public void addItem(Products products, int quantity){
        // for to verify if some item in Shopping car has the same name, if it is true
        // it will increment the quantity
        for (ShoppingCartItems carItem : items){
            if(carItem.getProduct().getName().equals(products.getName())){
                carItem.incrementQuantity(quantity);
                return;
            }
        }
        // if it is false so just add an item
        items.add(new ShoppingCartItems(products, quantity));
    }
    public void removeItem(Products products, int quantity){
        for (ShoppingCartItems carItem : items){
            if(carItem.getProduct().getName().equals(products.getName())){
                carItem.decrementQuantity(quantity);
                return;
            }
        }
        items.remove(new ShoppingCartItems(products, quantity));
    }
    public void removeEntireProduct(ShoppingCartItems shoppingCartItem){
        getItems().remove(shoppingCartItem);
    }
    public double totalCost(){
        double total = 0;
        for (ShoppingCartItems carItems : items){
            total += carItems.getQuantity() * carItems.getProduct().getPrice();
        }
        return total;
    }
}
