package org.javaacademy.credit_service.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CurrencyDtoRq {
    String toCurrencyName; // rub
    BigDecimal amountRub; // 1_000_000
}
