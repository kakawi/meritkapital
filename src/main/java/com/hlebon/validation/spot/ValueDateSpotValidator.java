package com.hlebon.validation.spot;

import com.hlebon.controller.dto.SpotDto;
import com.hlebon.validation.ValidationError;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ValueDateSpotValidator extends SpotBaseValidator {

    @Override
    public ValidationError validate(SpotDto dto) {
        LocalDate valueDate = dto.getValueDate();
        if (valueDate == null) {
            return null;
        }

        LocalDate today = LocalDate.now();
        final int daysToAdd;
        switch (today.getDayOfWeek()) {
            case TUESDAY:
            case FRIDAY:
                daysToAdd = 4;
                break;
            case SATURDAY:
                daysToAdd = 3;
                break;
            default:
                daysToAdd = 2;
        }

        if (!today.plusDays(daysToAdd).equals(valueDate)) {
            return new ValidationError("The spot date is two business days");
        }

        return null;
    }

}
