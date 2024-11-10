package com.watchthewatch.catalogservice.domain.service;

import com.watchthewatch.catalogservice.domain.model.Watch;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CatalogServiceImpl implements CatalogService {

    /**
     * Calculates the total discounted sum for a list of watches based on the quantity specified in the checkout list.
     *
     * @param watches a distinct list of {@link Watch} objects, where each watch in the list should correspond
     *                to a unique watch ID in the {@code checkoutListWatchIds} parameter. Each unique watch in
     *                this list represents an item in the checkout list that may have multiple quantities.
     * @param checkoutListWatchIds a list of watch IDs, potentially containing duplicates, representing
     *                             the items selected for checkout. Each ID in this list should match one
     *                             of the unique watches in the {@code watches} list.
     * @return the total price of all watches specified in the {@code checkoutListWatchIds},
     *            accounting for applicable discounts based on each watch's discounted quantity
     *            and discounted price. If a watch does not have a discount, its price is calculated
     *            with the standard price.
     */
    public BigDecimal calculateDiscountedTotalSum(List<Watch> watches, List<String> checkoutListWatchIds) {
        Map<String, Integer> watchIdCountMap = new HashMap<>();

        for (String watchId : checkoutListWatchIds) {
            watchIdCountMap.put(watchId, watchIdCountMap.getOrDefault(watchId, 0) + 1);
        }

        BigDecimal totalSumWithDiscount = new BigDecimal(0);

        for (Watch watch : watches) {
            if (watchIdCountMap.containsKey(watch.getId())) {
                Integer count = watchIdCountMap.get(watch.getId());
                int countWithoutDiscount = count % watch.getDiscountedQuantity();
                int discountCount = count - countWithoutDiscount;

                BigDecimal priceWithoutDiscount = BigDecimal.valueOf(countWithoutDiscount).multiply(watch.getPrice());
                BigDecimal priceForDiscounted = BigDecimal.valueOf(discountCount / watch.getDiscountedQuantity())
                        .multiply(watch.getDiscountedPriceForQuantity());

                totalSumWithDiscount = totalSumWithDiscount.add(priceWithoutDiscount).add(priceForDiscounted);
            } else {
                throw new IllegalArgumentException("Watch ID " + watch.getId() + " not found in checkout list.");
            }
        }

        return totalSumWithDiscount;
    }

}
