package org.javaacademy.credit_service.dto;

import lombok.Data;
import org.javaacademy.credit_service.enums.Currency;

import java.math.BigDecimal;

@Data
public class TakeCreditDtoRq {
    private String currencyName;
    private BigDecimal amountRub;
}
