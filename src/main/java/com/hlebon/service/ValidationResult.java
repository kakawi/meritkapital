package com.hlebon.service;

import com.hlebon.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    private final List<ValidationError> errors = new ArrayList<>();

    public void addError(final ValidationError error) {
        errors.add(error);
    }

    public boolean isOk() {
        return errors.isEmpty();
    }

    public List<ValidationError> getErrors() {
        return errors;
    }
}
