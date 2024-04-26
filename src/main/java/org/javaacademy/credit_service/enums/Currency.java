package org.javaacademy.credit_service.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Currency {
    RUB("Рубль"), USD("Доллар");
    private final String name;

    public static Currency getCurrencyByName(String name) {
        return Arrays.stream(Currency.values()).filter(e -> e.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }

}
