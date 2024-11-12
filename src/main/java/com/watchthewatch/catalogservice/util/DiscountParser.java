package com.watchthewatch.catalogservice.util;

import java.math.BigDecimal;

public class DiscountParser {

    public static Discount parseDiscount(String discount) {
        if (discount == null || discount.isEmpty()) {
            return new Discount(null, null);
        }
        String[] parts = discount.split(" for ");
        int quantity = Integer.parseInt(parts[0].trim());
        BigDecimal totalPriceForQuantity = new BigDecimal(parts[1].trim());

        return new Discount(quantity, totalPriceForQuantity);
    }

    public static class Discount {
        private final Integer quantity;
        private final BigDecimal totalPriceForQuantity;

        public Discount(Integer quantity, BigDecimal totalPriceForQuantity) {
            this.quantity = quantity;
            this.totalPriceForQuantity = totalPriceForQuantity;
        }

        public int getQuantity() { return quantity; }
        public BigDecimal getTotalPriceForQuantity() { return totalPriceForQuantity; }
    }

}
