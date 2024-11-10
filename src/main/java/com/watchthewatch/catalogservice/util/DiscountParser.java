package com.watchthewatch.catalogservice.util;

import java.math.BigDecimal;

public class DiscountParser {

    public static Discount parseDiscount(String discount) {
        String[] parts = discount.split(" for ");
        int quantity = Integer.parseInt(parts[0].trim());
        BigDecimal totalPriceForQuantity = new BigDecimal(parts[1].trim());

        return new Discount(quantity, totalPriceForQuantity);
    }

    public static class Discount {
        private final int quantity;
        private final BigDecimal totalPriceForQuantity;

        public Discount(int quantity, BigDecimal totalPriceForQuantity) {
            this.quantity = quantity;
            this.totalPriceForQuantity = totalPriceForQuantity;
        }

        public int getQuantity() { return quantity; }
        public BigDecimal getTotalPriceForQuantity() { return totalPriceForQuantity; }
    }

}
