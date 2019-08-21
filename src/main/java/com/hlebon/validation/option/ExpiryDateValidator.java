package com.hlebon.validation.option;

import com.hlebon.controller.dto.OptionDto;
import com.hlebon.validation.ValidationError;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Expiry date shall be before delivery date
 */
@Component
public class ExpiryDateValidator extends OptionBaseValidator {

    @Override
    public ValidationError validate(final OptionDto dto) {
        LocalDate expiryDate = dto.getExpiryDate();
        LocalDate deliveryDate = dto.getDeliveryDate();

        if (deliveryDate == null || expiryDate == null) {
            return null;
        }

        if (expiryDate.isAfter(deliveryDate)) {
            return new ValidationError("Expiry date shall be before delivery date");
        }

        return null;
    }
}
