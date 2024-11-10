package com.watchthewatch.catalogservice.domain.model;

import java.math.BigDecimal;

public class Watch {

    private String id;
    private String name;
    private BigDecimal price;
    private int discountedQuantity;
    private BigDecimal discountedPriceForQuantity;

    public Watch(String id, String name, BigDecimal price, int discountedQuantity, BigDecimal discountedPriceForQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountedQuantity = discountedQuantity;
        this.discountedPriceForQuantity = discountedPriceForQuantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDiscountedQuantity(int discountedQuantity) {
        this.discountedQuantity = discountedQuantity;
    }

    public void setDiscountedPriceForQuantity(BigDecimal discountedPriceForQuantity) {
        this.discountedPriceForQuantity = discountedPriceForQuantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getDiscountedQuantity() {
        return discountedQuantity;
    }

    public BigDecimal getDiscountedPriceForQuantity() {
        return discountedPriceForQuantity;
    }
}
