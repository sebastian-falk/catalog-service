package com.watchthewatch.catalogservice.infrastructure.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "watches")
public class Watch {

    @Id
    @Column(name = "watch_id")
    private String watchId;

    @Column(nullable = false, name = "watch_name")
    private String watchName;

    @Column(nullable = false, name = "unit_price")
    private BigDecimal unitPrice;

    @Column(nullable = true)
    private String discount;

    protected Watch() {}

    public Watch(String watchId, String watchName, BigDecimal unitPrice, String discount) {
        this.watchId = watchId;
        this.watchName = watchName;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    public String getWatchId() {
        return watchId;
    }

    public void setWatchId(String watchId) {
        this.watchId = watchId;
    }

    public String getWatchName() {
        return watchName;
    }

    public void setName(String watchName) {
        this.watchName = watchName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Watch{" +
                "watchId='" + watchId + '\'' +
                ", watchName='" + watchName + '\'' +
                ", unitPrice=" + unitPrice +
                ", discount='" + discount + '\'' +
                '}';
    }
}
