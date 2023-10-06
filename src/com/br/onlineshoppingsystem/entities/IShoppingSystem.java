package com.br.onlineshoppingsystem.entities;

import com.br.onlineshoppingsystem.entities.categories.Books;
import com.br.onlineshoppingsystem.entities.categories.Clothing;
import com.br.onlineshoppingsystem.entities.categories.Eletronics;
import com.br.onlineshoppingsystem.domain.Customer;

public interface IShoppingSystem {
    void run();
    void browseProducts(Eletronics eletronics, Books book, Clothing clothing);
    void addToCart(Eletronics eletronics, Books book, Clothing clothing, Customer customer);
    void viewCart(Customer customer);
    void removeItemFromCart(Eletronics eletronics, Books book, Clothing clothing, Customer customer);
    void checkout(Customer customer);
    void exit();
    void menuDisplay();
    boolean isEmailAndNameValidPersonalized(String name, String email);
}
