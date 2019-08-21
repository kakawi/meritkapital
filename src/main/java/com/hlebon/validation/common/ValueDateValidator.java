package com.hlebon.validation.common;

import com.hlebon.controller.dto.request.Dto;
import com.hlebon.validation.CommonValidator;
import com.hlebon.validation.ValidationError;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * value date cannot fall on weekend or non-working day for currency
 */
@Component
public class ValueDateValidator implements CommonValidator {

    @Override
    public ValidationError validate(final Dto dto) {
        LocalDate valueDate = dto.getValueDate();
        if (valueDate == null) {
            return null;
        }

        // TODO finish
        return null;
    }

}
