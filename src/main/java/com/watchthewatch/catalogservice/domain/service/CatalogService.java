package com.watchthewatch.catalogservice.domain.service;

import com.watchthewatch.catalogservice.domain.model.Watch;

import java.math.BigDecimal;
import java.util.List;

public interface CatalogService {
    BigDecimal calculateDiscountedTotalSum(List<Watch> watches, List<String> checkoutListWatchIds);
}
