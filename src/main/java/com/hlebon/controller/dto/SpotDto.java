package com.hlebon.controller.dto;

import com.hlebon.Type;
import com.hlebon.controller.dto.request.Dto;

import java.time.LocalDate;

public class SpotDto extends Dto {

    private String customer;
    private String ccyPair;
    private String direction;
    private LocalDate tradeDate;
    private LocalDate valueDate;
    private String legalEntity;

    @Override
    public Type getType() {
        return Type.SPOT;
    }

    public String getCustomer() {
        return customer;
    }

    public SpotDto setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public String getCcyPair() {
        return ccyPair;
    }

    public SpotDto setCcyPair(String ccyPair) {
        this.ccyPair = ccyPair;
        return this;
    }

    public String getDirection() {
        return direction;
    }

    public SpotDto setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public SpotDto setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
        return this;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public SpotDto setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
        return this;
    }

    public String getLegalEntity() {
        return legalEntity;
    }

    public SpotDto setLegalEntity(String legalEntity) {
        this.legalEntity = legalEntity;
        return this;
    }
}
