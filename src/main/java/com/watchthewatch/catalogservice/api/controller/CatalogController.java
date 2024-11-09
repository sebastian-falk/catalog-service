package com.watchthewatch.catalogservice.api.controller;

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

    @PostMapping("/calculate-total-sum")
    public ResponseEntity<BigDecimal> calculateDiscountedTotalSum(@RequestBody List<String> watchIds) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
