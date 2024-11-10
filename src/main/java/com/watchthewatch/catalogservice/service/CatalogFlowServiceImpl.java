package com.watchthewatch.catalogservice.service;

import com.watchthewatch.catalogservice.domain.service.CatalogService;
import com.watchthewatch.catalogservice.infrastructure.mapper.EntityToDomain;
import com.watchthewatch.catalogservice.infrastructure.model.Watch;
import com.watchthewatch.catalogservice.infrastructure.repository.WatchRepository;
import com.watchthewatch.catalogservice.util.DiscountParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CatalogFlowServiceImpl implements CatalogFlowService {

    private final WatchRepository watchRepository;
    private final CatalogService catalogService;

    @Autowired
    public CatalogFlowServiceImpl(WatchRepository watchRepository, CatalogService catalogService) {
        this.watchRepository = watchRepository;
        this.catalogService = catalogService;
    }

    public BigDecimal calculateDiscountedTotalSum(List<String> watchIds) {
        List<Watch> watches = watchRepository.findByWatchIdIn(watchIds);

        if (watches.size() != watchIds.size()) {
            return BigDecimal.ZERO;
        }

        EntityToDomain entityToDomain = new EntityToDomain();

        List<com.watchthewatch.catalogservice.domain.model.Watch> domainWatches = watches.stream().map(w -> {
            DiscountParser.Discount discount = DiscountParser.parseDiscount(w.getDiscount());

            return entityToDomain.entityWatchToDomainWatch(w, discount.getQuantity(), discount.getTotalPriceForQuantity());
        }).toList();

        return catalogService.calculateDiscountedTotalSum(domainWatches, watchIds);
    }
}
