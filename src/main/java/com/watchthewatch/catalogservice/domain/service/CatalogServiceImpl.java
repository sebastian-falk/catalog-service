package com.watchthewatch.catalogservice.domain.service;

import com.watchthewatch.catalogservice.domain.model.Watch;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CatalogServiceImpl implements CatalogService {

    /**
     * Calculates the total discounted sum for a list of watches based on the quantity specified in the checkout list.
     *
     * @param watches a distinct list of {@link Watch} objects, where each watch in the list should correspond
     *                to a unique watch ID in the {@code checkoutListWatchIds} parameter. Each unique watch in
     *                this list represents an item in the checkout list that may have multiple quantities.
     * @param checkoutWatchIds a list of watch IDs, potentially containing duplicates, representing
     *                             the items selected for checkout. Each ID in this list should match one
     *                             of the unique watches in the {@code watches} list.
     * @return the total price of all watches specified in the {@code checkoutListWatchIds},
     *            accounting for applicable discounts based on each watch's discounted quantity
     *            and discounted price. If a watch does not have a discount, its price is calculated
     *            with the standard price.
     */
    public BigDecimal calculateDiscountedTotalSum(List<Watch> watches, List<String> checkoutWatchIds) {
        if (checkoutWatchIds.isEmpty()) {
            throw new IllegalArgumentException("Checkout list can't be empty");
        }

        Set<String> watchIds = watches.stream()
                .map(Watch::getId)
                .collect(Collectors.toSet());
        Set<String> checkoutIds = new HashSet<>(checkoutWatchIds);

        if (!watchIds.containsAll(checkoutIds)) {
            throw new IllegalArgumentException("Some ids in checkoutWatchIds do not have corresponding watches.");
        }

        if (!checkoutIds.containsAll(watchIds)) {
            throw new IllegalArgumentException("Some watches are not present in checkoutListWatchIds.");
        }

        return getTotalSumWithDiscount(watches, checkoutWatchIds);
    }

    private static BigDecimal getTotalSumWithDiscount(List<Watch> watches, List<String> checkoutWatchIds) {
        Map<String, Integer> watchIdCountMap = new HashMap<>();

        for (String watchId : checkoutWatchIds) {
            watchIdCountMap.put(watchId, watchIdCountMap.getOrDefault(watchId, 0) + 1);
        }

        BigDecimal totalSumWithDiscount = new BigDecimal(0);

        for (Watch watch : watches) {
            Integer count = watchIdCountMap.get(watch.getId());
            if (!watch.hasDiscount()) {
               totalSumWithDiscount = totalSumWithDiscount.add(watch.getPrice().multiply(new BigDecimal(count)));
               continue;
            }
            int countWithoutDiscount = count % watch.getDiscountedQuantity();
            int discountCount = count - countWithoutDiscount;

            BigDecimal priceWithoutDiscount = BigDecimal.valueOf(countWithoutDiscount).multiply(watch.getPrice());
            BigDecimal priceForDiscounted = BigDecimal.valueOf(discountCount / watch.getDiscountedQuantity())
                    .multiply(watch.getDiscountedPriceForQuantity());

            totalSumWithDiscount = totalSumWithDiscount.add(priceWithoutDiscount).add(priceForDiscounted);
        }
        return totalSumWithDiscount;
    }

}
