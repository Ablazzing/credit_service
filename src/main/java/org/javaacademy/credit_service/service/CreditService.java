package org.javaacademy.credit_service.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.credit_service.dto.CurrencyDtoRq;
import org.javaacademy.credit_service.dto.CurrencyDtoRs;
import org.javaacademy.credit_service.dto.TakeCreditDtoRq;
import org.javaacademy.credit_service.dto.TakeCreditDtoRs;
import org.javaacademy.credit_service.enums.Currency;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.javaacademy.credit_service.enums.Currency.RUB;
import static org.javaacademy.credit_service.enums.Currency.USD;

@Service
@RequiredArgsConstructor
public class CreditService {
    private static final BigDecimal CREDIT_RUB_PERCENT = BigDecimal.TEN;
    private static final BigDecimal CREDIT_USD_PERCENT = BigDecimal.valueOf(1);
    private final RestTemplate restTemplate;

    public TakeCreditDtoRs takeCredit(TakeCreditDtoRq req) {
        Currency currency = Currency.getCurrencyByName(req.getCurrencyName());
        if (currency == RUB) {
            return new TakeCreditDtoRs(currency.getName(), CREDIT_RUB_PERCENT, req.getAmountRub());
        } else if (currency == USD) {
            CurrencyDtoRs currencyDtoRs = convertCurrency(req.getAmountRub(), currency);
            return new TakeCreditDtoRs(currency.getName(), CREDIT_USD_PERCENT, currencyDtoRs.getAmount());
        }
        throw new RuntimeException("Валюта не поддерживается");
    }

    private CurrencyDtoRs convertCurrency(BigDecimal amountRub, Currency currency) {
        String url = "http://localhost:8003/currency/transfer";
        RequestEntity<CurrencyDtoRq> request = RequestEntity
                .post(url)
                .body(new CurrencyDtoRq(currency.name(), amountRub));
        ResponseEntity<CurrencyDtoRs> response =  restTemplate.exchange(request, CurrencyDtoRs.class);
        return response.getBody();
    }
}
