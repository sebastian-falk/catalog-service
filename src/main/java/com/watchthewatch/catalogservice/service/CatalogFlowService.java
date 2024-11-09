package com.watchthewatch.catalogservice.service;

import java.math.BigDecimal;
import java.util.List;

public interface CatalogFlowService {
    BigDecimal calculateDiscountedTotalSum(List<String> watchIds);
}
