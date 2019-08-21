package com.hlebon.validation;

import com.hlebon.Type;
import com.hlebon.controller.dto.request.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ValidatorManager {
    private final Map<Type, List<TypedValidator<? super Dto>>> validators = new HashMap<>();
    private final List<CommonValidator> commonValidators = new ArrayList<>();

    @Autowired
    public ValidatorManager(
            final List<TypedValidator<? extends Dto>> allTypedValidators,
            final List<CommonValidator> commonValidators
    ) {
        for (TypedValidator typedValidator : allTypedValidators) {
            validators.computeIfAbsent(typedValidator.getType(), e -> new ArrayList<>());
            validators.get(typedValidator.getType()).add(typedValidator);
        }
        this.commonValidators.addAll(commonValidators);
    }

    public Collection<TypedValidator<? super Dto>> getValidatorsChain(Type type) {
        return validators.get(type);
    }

    public List<CommonValidator> getCommonValidators() {
        return commonValidators;
    }
}
