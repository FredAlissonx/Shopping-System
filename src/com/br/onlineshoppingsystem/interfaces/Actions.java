package com.br.onlineshoppingsystem.interfaces;

import com.br.onlineshoppingsystem.domain.customer.Customer;

public interface Actions {
    void browseProducts();
    void addToCart(Customer customer);
    void viewCart(Customer customer);
    void removePurchaseFromCart(Customer customer);
    void checkout(Customer customer);
    void exit();

}
