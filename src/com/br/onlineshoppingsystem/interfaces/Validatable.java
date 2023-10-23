package com.br.onlineshoppingsystem.interfaces;

import java.time.Instant;
import java.util.Date;

public interface Validatable {
    default boolean validName(String name) {
        return name.length() > 2;
    }

    default boolean validEmail(String email) {
        return email.endsWith("@gmail.com") && email.length() > 10;
    }

    default boolean validAdress(Long adress) {
        return String.valueOf(adress).length() == 8;
    }

    default boolean validChoice(int choice, int total) {
        return choice > 0 && choice <= total;
    }

    default boolean validQuantity(int quantity, int purchaseQuantity) {
        return (quantity > 0) && (quantity <= purchaseQuantity);
    }

    default boolean validCvv(int cvv) {
        return String.valueOf(cvv).length() == 3;
    }

    default boolean validCardNumber(long cardNumber) {
        return String.valueOf(cardNumber).length() > 16 || String.valueOf(cardNumber).length() < 14;
    }

    default boolean validDueDate(String dueDateString) {
        Date dueDate = new Date(dueDateString);
        return !dueDate.equals("00/0000") && dueDate.before(Date.from(Instant.now()));
    }

    default boolean validWallet(Long wallet, double cost) {
        return wallet >= cost;
    }
}
