package com.hlebon.service;

import com.hlebon.controller.dto.request.Dto;
import com.hlebon.validation.CommonValidator;
import com.hlebon.validation.TypedValidator;
import com.hlebon.validation.ValidatorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
public class ValidatorServiceImpl implements ValidatorService {

    private final ValidatorManager validatorManager;

    @Autowired
    public ValidatorServiceImpl(ValidatorManager validatorManager) {
        this.validatorManager = validatorManager;
    }

    @Override
    public ValidationResult validate(final Dto dto) {
        ValidationResult result = new ValidationResult();

        Collection<CommonValidator> commonValidators = validatorManager.getCommonValidators();

        if (!commonValidators.isEmpty()) {
            commonValidators
                    .stream()
                    .map(v -> v.validate(dto))
                    .filter(Objects::nonNull)
                    .forEach(result::addError);
        }

        Collection<TypedValidator<? super Dto>> validatorsChain = validatorManager.getValidatorsChain(dto.getType());
        if (validatorsChain != null) {
            validatorsChain
                    .stream()
                    .map(v -> v.validate(dto))
                    .filter(Objects::nonNull)
                    .forEach(result::addError);
        }

        return result;
    }
}
