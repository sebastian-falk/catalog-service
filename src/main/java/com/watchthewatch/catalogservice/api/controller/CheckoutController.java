package com.watchthewatch.catalogservice.api.controller;

import com.watchthewatch.catalogservice.service.CatalogFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CheckoutController {
    private final CatalogFlowService catalogFlowService;

    @Autowired
    public CheckoutController(CatalogFlowService catalogFlowService) {
        this.catalogFlowService = catalogFlowService;
    }

    // The reason why this is a duplicate is because it wasn't supposed to be a checkout path in this service but
    // it should instead be existing in checkout-service rather than this catalog-service
    @PostMapping("/checkout")
    public ResponseEntity<BigDecimal> checkout(@RequestBody List<String> watchIds) {
        BigDecimal calculatedDiscountedTotalSum = catalogFlowService.calculateDiscountedTotalSum(watchIds);

        if (calculatedDiscountedTotalSum == null || calculatedDiscountedTotalSum.compareTo(BigDecimal.ZERO) <= 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(calculatedDiscountedTotalSum);
    }
}
