package com.hlebon.controller.dto;

import com.hlebon.Type;
import com.hlebon.controller.dto.request.Dto;

public class ForwardDto extends Dto {

    private String customer;
    private String ccyPair;
    private String direction;
    private String tradeDate;
    private String valueDate;
    private String legalEntity;

    @Override
    public Type getType() {
        return Type.FORWARD;
    }

    public String getCustomer() {
        return customer;
    }

    public ForwardDto setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public String getCcyPair() {
        return ccyPair;
    }

    public ForwardDto setCcyPair(String ccyPair) {
        this.ccyPair = ccyPair;
        return this;
    }

    public String getDirection() {
        return direction;
    }

    public ForwardDto setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public ForwardDto setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
        return this;
    }

    public String getValueDate() {
        return valueDate;
    }

    public ForwardDto setValueDate(String valueDate) {
        this.valueDate = valueDate;
        return this;
    }

    public String getLegalEntity() {
        return legalEntity;
    }

    public ForwardDto setLegalEntity(String legalEntity) {
        this.legalEntity = legalEntity;
        return this;
    }
}
