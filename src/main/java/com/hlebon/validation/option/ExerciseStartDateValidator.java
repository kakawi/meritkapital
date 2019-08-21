package com.hlebon.validation.option;

import com.hlebon.controller.dto.OptionDto;
import com.hlebon.validation.ValidationError;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * American option style will have in addition the excerciseStartDate,
 * which has to be after the trade date but before the expiry date
 */
@Component
public class ExerciseStartDateValidator extends OptionBaseValidator {

    private static final String americanStyle = "AMERICAN";

    @Override
    public ValidationError validate(final OptionDto dto) {
        String style = dto.getStyle();
        LocalDate excerciseStartDate = dto.getExcerciseStartDate();
        LocalDate tradeDate = dto.getTradeDate();
        LocalDate expiryDate = dto.getExpiryDate();

        if (style == null
                || excerciseStartDate == null
                || tradeDate == null
                || expiryDate == null) {
            return null;
        }
        if (!americanStyle.equals(style)) {
            return null;
        }

        if (excerciseStartDate.isBefore(tradeDate) || excerciseStartDate.isAfter(expiryDate)) {
            return new ValidationError("excerciseStartDate has to be after the trade date but before the expiry date");
        }

        return null;
    }
}
