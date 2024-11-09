package com.watchthewatch.catalogservice.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    public BigDecimal calculateDiscountedTotalSum(List<String> watchIds) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
