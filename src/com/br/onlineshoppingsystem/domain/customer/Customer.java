
package com.br.onlineshoppingsystem.domain.customer;

import com.br.onlineshoppingsystem.domain.shopping.Cart;

public class Customer {
    private String name;
    private String email;
    private Long shippingAddress;
    private Cart cart;

    public Customer(String name, String email, Long shippingAddress, Cart cart) {
        this.name = name;
        this.email = email;
        this.shippingAddress = shippingAddress;
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

    public long getShippingAddress() {
        return shippingAddress;
    }

    //Add comment with bad practice in Customer: no service class for business rule
}
