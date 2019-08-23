package com.hlebon.validation.common;

import com.hlebon.controller.dto.request.Dto;
import com.hlebon.repository.CurrencyRepository;
import com.hlebon.validation.CommonValidator;
import com.hlebon.validation.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * validate currencies if they are valid ISO codes (ISO 4217)
 */
@Component
public class CurrencyValidator implements CommonValidator {

    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyValidator(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public ValidationError validate(final Dto dto) {
        String ccyPair = dto.getCcyPair();
        if (ccyPair == null) {
            return null;
        }

        String firstCurrency = ccyPair.substring(0, 3);
        String secondCurrency = ccyPair.substring(3);

        final String message = "%s - such currency doesn't exist";
        if (!currencyRepository.existsByIso(firstCurrency)) {
            return new ValidationError(String.format(message, firstCurrency));
        }

        if (!currencyRepository.existsByIso(secondCurrency)) {
            return new ValidationError(String.format(message, secondCurrency));
        }

        return null;
    }

}
