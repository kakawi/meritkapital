package com.hlebon.controller;

import com.hlebon.controller.dto.request.Dto;
import com.hlebon.controller.dto.request.RequestDto;
import com.hlebon.controller.dto.response.ResponseDto;
import com.hlebon.validation.CommonValidator;
import com.hlebon.validation.TypedValidator;
import com.hlebon.validation.ValidatorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController("/api")
public class ValidatorController {

    private final ValidatorManager validatorManager;

    @Autowired
    public ValidatorController(ValidatorManager validatorManager) {
        this.validatorManager = validatorManager;
    }

    @PostMapping("validate")
    public ResponseDto validate(@RequestBody RequestDto dtos) {
        ResponseDto response = new ResponseDto();
        // TODO make a parallel
        // TODO move in service layer
        for (final Dto dto: dtos.getTest()) {
            ResponseDto.Row row = new ResponseDto.Row();
            Collection<CommonValidator> commonValidators = validatorManager.getCommonValidators();

            List<ResponseDto.Row.RowError> commonErrors = null;
            if (!commonValidators.isEmpty()) {
                commonErrors = commonValidators
                        .stream()
                        .map(v -> v.validate(dto))
                        .filter(Objects::nonNull)
                        .map(e -> new ResponseDto.Row.RowError(e.getMessage()))
                        .collect(Collectors.toList());
            }
            Collection<TypedValidator<? super Dto>> validatorsChain = validatorManager.getValidatorsChain(dto.getType());
            List<ResponseDto.Row.RowError> typedErrors = null;
            if (validatorsChain != null) {
                typedErrors = validatorsChain
                        .stream()
                        .map(v -> v.validate(dto))
                        .filter(Objects::nonNull)
                        .map(e -> new ResponseDto.Row.RowError(e.getMessage()))
                        .collect(Collectors.toList());

            }
            List<ResponseDto.Row.RowError> rowErrors = new ArrayList<>();
            if (commonErrors != null) {
                rowErrors.addAll(commonErrors);
            }
            if (typedErrors != null) {
                rowErrors.addAll(typedErrors);
            }
            if (!rowErrors.isEmpty()) {
                row.setErrors(rowErrors);
            }
            response.addRow(row);
        }

        return response;
    }
}
