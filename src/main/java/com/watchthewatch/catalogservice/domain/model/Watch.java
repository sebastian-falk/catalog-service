package com.watchthewatch.catalogservice.domain.model;

import java.math.BigDecimal;

public class Watch {

    private String id;
    private String name;
    private BigDecimal price;
    private int discountedQuantity;
    private BigDecimal discountedPrice;

    public Watch(String id, String name, BigDecimal price, int discountedQuantity, BigDecimal discountedPrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountedQuantity = discountedQuantity;
        this.discountedPrice = discountedPrice;
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

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
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

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }
}
