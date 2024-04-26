package org.javaacademy.credit_service.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.credit_service.service.CreditService;
import org.javaacademy.credit_service.dto.TakeCreditDtoRq;
import org.javaacademy.credit_service.dto.TakeCreditDtoRs;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/credit")
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;

    @PostMapping("/take")
    public TakeCreditDtoRs takeCredit(@RequestBody TakeCreditDtoRq req) {
        return creditService.takeCredit(req);
    }
}
