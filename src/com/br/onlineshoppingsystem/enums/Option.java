package com.br.onlineshoppingsystem.enums;

import java.util.Arrays;
import java.util.List;

public enum Option {
    BROWSE_PRODUCTS,
    ADD_TO_CART,
    VIEW_CART,
    REMOVE_FROM_CART,
    CHECKOUT,
    EXIT;

    public static List<Option> getOptions() {
        return Arrays.asList(Option.values());
    }
}
