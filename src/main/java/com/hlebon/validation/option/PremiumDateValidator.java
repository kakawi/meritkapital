package com.hlebon.validation.option;

import com.hlebon.controller.dto.OptionDto;
import com.hlebon.validation.ValidationError;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Premium date shall be before delivery date
 */
@Component
public class PremiumDateValidator extends OptionBaseValidator {

    @Override
    public ValidationError validate(final OptionDto dto) {
        LocalDate premiumDate = dto.getPremiumDate();
        LocalDate deliveryDate = dto.getDeliveryDate();

        if (deliveryDate == null || premiumDate == null) {
            return null;
        }

        if (premiumDate.isAfter(deliveryDate)) {
            return new ValidationError("Premium date shall be before delivery date");
        }

        return null;
    }
}
