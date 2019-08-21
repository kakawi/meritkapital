package com.hlebon.validation.common;

import com.hlebon.controller.dto.request.Dto;
import com.hlebon.validation.CommonValidator;
import com.hlebon.validation.ValidationError;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 * if the counterparty is one of the supported ones
 */
@Component
public class SupportedCounterpartiesValidator implements CommonValidator {

    private static final Collection<String> SUPPORTED_COUNTERPARTIES = Arrays.asList(
            "PLUTO1",
            "PLUTO2"
    );

    @Override
    public ValidationError validate(final Dto dto) {
        String customer = dto.getCustomer();
        if (customer == null) {
            return null;
        }

        if (!SUPPORTED_COUNTERPARTIES.contains(customer)) {
            return new ValidationError(customer + " is not supported");
        }

        return null;
    }

}
