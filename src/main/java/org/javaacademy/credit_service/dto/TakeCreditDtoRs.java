package org.javaacademy.credit_service.dto;

import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class TakeCreditDtoRs {
    private String currencyName;
    private BigDecimal percent;
    private BigDecimal amount;
}
