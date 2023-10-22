package com.br.onlineshoppingsystem.domain.shopping;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Purchase> purchases;
    public Cart(){
        this.purchases = new ArrayList<>();
    }
    public List<Purchase> getPurchases() {
        return purchases;
    }
    public boolean removePurchase (Purchase p){
        return purchases.remove(p);
    }
    public boolean addPurchase (Product p, int quantity){
        return purchases.add(new Purchase(p, quantity));
    }


}
