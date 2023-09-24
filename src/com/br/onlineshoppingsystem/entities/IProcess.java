package com.br.onlineshoppingsystem.entities;

import com.br.onlineshoppingsystem.categories.Books;
import com.br.onlineshoppingsystem.categories.Clothing;
import com.br.onlineshoppingsystem.categories.Eletronics;
import com.br.onlineshoppingsystem.domain.Costumer;
import com.br.onlineshoppingsystem.exceptions.DomainException;

public interface IProcess {
    void run();
    void viewProducts(Eletronics eletronics, Books book, Clothing clothing);
    void addToCart(Eletronics eletronics, Books book, Clothing clothing, Costumer costumer);
    void viewCart(Costumer costumer);
    void removeItemFromCart(Eletronics eletronics, Books book, Clothing clothing, Costumer costumer);
    void checkout(Costumer costumer);
    void exit();
    void menuDisplay();
    boolean isEmailAndNameValidPersonalized(String name, String email);
}
