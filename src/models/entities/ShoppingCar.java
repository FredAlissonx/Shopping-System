package models.entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCar {
    private List<ShoppingCarItems> items = new ArrayList<>();
    public ShoppingCar(){
    }

    public ShoppingCar(List<ShoppingCarItems> items) {
        this.items = items;
    }

    public List<ShoppingCarItems> getItems() {
        return items;
    }

    public void addItem(Products products, int quantity){
        // for to verify if some item in Shopping car has the same name, if it is true
        // it will increment the quantity
        for (ShoppingCarItems carItem : items){
            if(carItem.getProduct().getName().equals(products.getName())){
                carItem.incrementQuantity(quantity);
                return;
            }
        }
        // if it is false so just add an item
        items.add(new ShoppingCarItems(products, quantity));
    }
    public void removeItem(Products products, int quantity){
        ShoppingCarItems itemToRemove = new ShoppingCarItems(products, quantity);
        items.remove(itemToRemove);
    }
    public double totalCost(){
        double total = 0;
        for (ShoppingCarItems carItems : items){
            total += carItems.getQuantity() * carItems.getProduct().getPrice();
        }
        return total;
    }
}
