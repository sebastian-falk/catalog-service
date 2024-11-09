package com.watchthewatch.catalogservice.service;

import java.math.BigDecimal;
import java.util.List;

public interface CatalogService {
    BigDecimal calculateDiscountedTotalSum(List<String> watchIds);
}
