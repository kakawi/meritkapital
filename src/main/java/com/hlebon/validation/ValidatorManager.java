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
    private Map<Type, List<Validator<? super Dto>>> validators = new HashMap<>();

    @Autowired
    public ValidatorManager(List<Validator<? extends Dto>> allValidators) {
        for (Validator validator : allValidators) {
            validators.computeIfAbsent(validator.getType(), e -> new ArrayList<>());
            validators.get(validator.getType()).add(validator);
        }
    }

    public Collection<Validator<? super Dto>> getValidatorsChain(Type type) {
        return validators.get(type);
    }
}
