package com.hlebon.validation.common;

import com.hlebon.controller.dto.request.Dto;
import com.hlebon.validation.ValidationError;
import com.hlebon.validation.CommonValidator;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * value date cannot be before trade date
 */
@Component
public class TradeAndValueDatesValidator implements CommonValidator {

    @Override
    public ValidationError validate(final Dto dto) {
        LocalDate valueDate = dto.getValueDate();
        LocalDate tradeDate = dto.getTradeDate();
        if (valueDate == null || tradeDate == null) {
            return null;
        }
        if (valueDate.isBefore(tradeDate)) {
            return new ValidationError("Value date cannot be before trade date");
        }
        return null;
    }

}
