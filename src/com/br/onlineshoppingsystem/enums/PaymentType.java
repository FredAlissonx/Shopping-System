package com.br.onlineshoppingsystem.enums;

import java.util.Arrays;
import java.util.List;

public enum PaymentType {

    CREDIT_CARD, BANK_TRANSFER, PIX, BITCOIN;

    public static List<PaymentType> getOptions() {
        return Arrays.asList(com.br.onlineshoppingsystem.enums.PaymentType.values());
    }

}
