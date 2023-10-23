
package com.br.onlineshoppingsystem.domain.customer;

import com.br.onlineshoppingsystem.domain.shopping.Cart;

public class Customer {

    private String name;
    private String email;
    private long adress;
    private Cart cart;

    public Customer(String name, String email, long adress, Cart cart) {
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Cart getCart() {
        return cart;
    }

    public long getAdress() {return adress;}
}
