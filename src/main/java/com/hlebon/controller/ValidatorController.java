package com.hlebon.controller;

import com.hlebon.controller.dto.request.Dto;
import com.hlebon.controller.dto.request.RequestDto;
import com.hlebon.controller.dto.response.ResponseDto;
import com.hlebon.validation.Validator;
import com.hlebon.validation.ValidatorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        for (final Dto dto: dtos.getTest()) {
            ResponseDto.Row row = new ResponseDto.Row();
            Collection<Validator<? super Dto>> validatorsChain = validatorManager.getValidatorsChain(dto.getType());
            if (validatorsChain != null) {
                List<ResponseDto.Row.RowError> rowErrors = validatorsChain
                        .stream()
                        .map(v -> v.validate(dto))
                        .filter(Objects::nonNull)
                        .map(e -> new ResponseDto.Row.RowError(e.getMessage()))
                        .collect(Collectors.toList());
                if (!rowErrors.isEmpty()) {
                    row.setErrors(rowErrors);
                }
            }
            response.addRow(row);
        }

        return response;
    }
}
