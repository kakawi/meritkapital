package com.hlebon.validation.common;

import com.hlebon.controller.dto.request.Dto;
import com.hlebon.validation.ValidationError;
import com.hlebon.validation.CommonValidator;
import org.springframework.stereotype.Component;

@Component
public class TradeAndValueDatesValidator implements CommonValidator {

    @Override
    public ValidationError validate(final Dto dto) {
        if (dto.getValueDate().isBefore(dto.getTradeDate())) {
            return new ValidationError("Value date cannot be before trade date");
        }
        return null;
    }

}
