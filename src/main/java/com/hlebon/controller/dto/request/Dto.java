package com.hlebon.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hlebon.Type;
import com.hlebon.controller.dto.ForwardDto;
import com.hlebon.controller.dto.OptionDto;
import com.hlebon.controller.dto.SpotDto;

import java.time.LocalDate;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "Spot", value = SpotDto.class),
        @JsonSubTypes.Type(name = "Forward", value = ForwardDto.class),
        @JsonSubTypes.Type(name = "VanillaOption", value = OptionDto.class)
})
public abstract class Dto {

    private String customer;
    private String ccyPair;
    private String direction;
    private LocalDate tradeDate;
    private LocalDate valueDate;
    private String legalEntity;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCcyPair() {
        return ccyPair;
    }

    public void setCcyPair(String ccyPair) {
        this.ccyPair = ccyPair;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    public String getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(String legalEntity) {
        this.legalEntity = legalEntity;

    }

    public abstract Type getType();

}
