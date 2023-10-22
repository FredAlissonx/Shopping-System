package com.br.onlineshoppingsystem.enums;

import java.util.Arrays;
import java.util.List;

public enum Category {
    BOOKS, CLOTHINGS,
    ELETRONICS;
    public static List<Category> getCategories() {
        return Arrays.asList(Category.values());
    }
}
