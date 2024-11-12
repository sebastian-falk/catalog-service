package com.watchthewatch.catalogservice.domain.model;

import java.math.BigDecimal;

public class Watch {

    private String id;
    private String name;
    private BigDecimal price;
    private Integer discountedQuantity;
    private BigDecimal discountedPriceForQuantity;

    public Watch(String id, String name, BigDecimal price, Integer discountedQuantity, BigDecimal discountedPriceForQuantity) {
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

    public void setDiscountedQuantity(Integer discountedQuantity) {
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

    public Integer getDiscountedQuantity() {
        return discountedQuantity;
    }

    public BigDecimal getDiscountedPriceForQuantity() {
        return discountedPriceForQuantity;
    }

    public boolean hasDiscount() {
        return discountedQuantity != null;
    }
}
