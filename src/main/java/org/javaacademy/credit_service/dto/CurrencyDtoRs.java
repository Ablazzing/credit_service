package org.javaacademy.credit_service.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CurrencyDtoRs {
    String currencyName;
    BigDecimal amount;
    BigDecimal rate;
}
