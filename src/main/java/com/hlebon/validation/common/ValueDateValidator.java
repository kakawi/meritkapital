package com.hlebon.validation.common;

import com.hlebon.controller.dto.request.Dto;
import com.hlebon.repository.HolidayRepository;
import com.hlebon.validation.CommonValidator;
import com.hlebon.validation.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * value date cannot fall on weekend or non-working day for currency
 */
@Component
public class ValueDateValidator implements CommonValidator {

    private static final Collection<DayOfWeek> WEEKENDS = asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);

    private final HolidayRepository holidayRepository;

    @Autowired
    public ValueDateValidator(final HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Override
    public ValidationError validate(final Dto dto) {
        LocalDate valueDate = dto.getValueDate();
        if (valueDate == null) {
            return null;
        }

        DayOfWeek dayOfWeek = valueDate.getDayOfWeek();
        if (WEEKENDS.contains(dayOfWeek)) {
            return new ValidationError("ValueDate cannot fall on weekend");
        }

        if (holidayRepository.existsByMonthAndDayOfMonth(valueDate.getMonth(), valueDate.getDayOfMonth())) {
            return new ValidationError("ValueDate cannot fall on non-working day");
        }

        return null;
    }

}
