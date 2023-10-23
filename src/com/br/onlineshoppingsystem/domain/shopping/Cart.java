package com.br.onlineshoppingsystem.domain.shopping;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Purchase> purchases = new ArrayList<>();

    public Cart() {
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public boolean removePurchase(Purchase p) {
        return purchases.remove(p);
    }

    public boolean addPurchase(Purchase purchase) {
        return purchases.add(purchase);
    }

}
