package com.watchthewatch.catalogservice.infrastructure.mapper;

import com.watchthewatch.catalogservice.infrastructure.model.Watch;

import java.math.BigDecimal;

public class EntityToDomain {

    public com.watchthewatch.catalogservice.domain.model.Watch entityWatchToDomainWatch(
            Watch watch, int discountQuantity,
            BigDecimal totalPriceForDiscountQuantity
    ) {
        if (watch == null) {
            return null;
        }

        return new com.watchthewatch.catalogservice.domain.model.Watch(
                watch.getWatchId(),
                watch.getWatchName(),
                watch.getUnitPrice(),
                discountQuantity,
                totalPriceForDiscountQuantity
                );
    }
}
