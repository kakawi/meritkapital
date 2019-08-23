package com.hlebon.validation.forward;

import com.hlebon.controller.dto.ForwardDto;
import com.hlebon.validation.ValidationError;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component
public class ValueDateForwardValidator extends ForwardBaseValidator {

    @Override
    public ValidationError validate(ForwardDto dto) {
        LocalDate valueDate = dto.getValueDate();
        if (valueDate == null) {
            return null;
        }

        LocalDate today = LocalDate.now();
        final int daysToAdd;
        if (today.getDayOfWeek() == DayOfWeek.SATURDAY) {
            daysToAdd = 6;
        } else {
            daysToAdd = 5;
        }

        if (!today.plusDays(daysToAdd).equals(valueDate)) {
            return new ValidationError("The forward date is five business days");
        }

        return null;
    }

}
