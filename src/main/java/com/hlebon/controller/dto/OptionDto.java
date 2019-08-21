package com.hlebon.controller.dto;

import com.hlebon.Type;
import com.hlebon.controller.dto.request.Dto;

import java.time.LocalDate;

public class OptionDto extends Dto {

    private String customer;
    private String ccyPair;
    private String style;
    private String direction;
    private String strategy;
    private LocalDate tradeDate;
    private LocalDate deliveryDate;
    private LocalDate expiryDate;
    private LocalDate valueDate;
    private LocalDate premiumDate;
    private String payCcy;
    private String legalEntity;

    @Override
    public Type getType() {
        return Type.OPTIONS;
    }

    public String getCustomer() {
        return customer;
    }

    public OptionDto setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public String getCcyPair() {
        return ccyPair;
    }

    public OptionDto setCcyPair(String ccyPair) {
        this.ccyPair = ccyPair;
        return this;
    }

    public String getStyle() {
        return style;
    }

    public OptionDto setStyle(String style) {
        this.style = style;
        return this;
    }

    public String getDirection() {
        return direction;
    }

    public OptionDto setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public String getStrategy() {
        return strategy;
    }

    public OptionDto setStrategy(String strategy) {
        this.strategy = strategy;
        return this;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public OptionDto setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
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

    public LocalDate getValueDate() {
        return valueDate;
    }

    public OptionDto setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
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

    public String getLegalEntity() {
        return legalEntity;
    }

    public OptionDto setLegalEntity(String legalEntity) {
        this.legalEntity = legalEntity;
        return this;
    }
}
