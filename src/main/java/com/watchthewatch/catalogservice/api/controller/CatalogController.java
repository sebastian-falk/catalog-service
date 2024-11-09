package com.watchthewatch.catalogservice.api.controller;

import com.watchthewatch.catalogservice.service.CatalogFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/catalog-items/")
public class CatalogController {

    private final CatalogFlowService catalogService;

    @Autowired
    public CatalogController(CatalogFlowService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/calculate-total-sum")
    public ResponseEntity<BigDecimal> calculateDiscountedTotalSum(@RequestBody List<String> watchIds) {
        BigDecimal calculatedDiscountedTotalSum = catalogService.calculateDiscountedTotalSum(watchIds);

        if (calculatedDiscountedTotalSum == null || calculatedDiscountedTotalSum.compareTo(BigDecimal.ZERO) <= 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(calculatedDiscountedTotalSum);
    }

}
