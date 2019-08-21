package com.hlebon.controller.dto;

import com.hlebon.Type;
import com.hlebon.controller.dto.request.Dto;

import java.time.LocalDate;

public class OptionDto extends Dto {

    private String style;
    private String strategy;
    private LocalDate deliveryDate;
    private LocalDate expiryDate;
    private LocalDate premiumDate;
    private String payCcy;

    @Override
    public Type getType() {
        return Type.OPTIONS;
    }

    public String getStyle() {
        return style;
    }

    public OptionDto setStyle(String style) {
        this.style = style;
        return this;
    }

    public String getStrategy() {
        return strategy;
    }

    public OptionDto setStrategy(String strategy) {
        this.strategy = strategy;
        return this;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public OptionDto setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public OptionDto setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public LocalDate getPremiumDate() {
        return premiumDate;
    }

    public OptionDto setPremiumDate(LocalDate premiumDate) {
        this.premiumDate = premiumDate;
        return this;
    }

    public String getPayCcy() {
        return payCcy;
    }

    public OptionDto setPayCcy(String payCcy) {
        this.payCcy = payCcy;
        return this;
    }
}
