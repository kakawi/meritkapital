package com.hlebon.controller;

import com.hlebon.controller.dto.request.Dto;
import com.hlebon.controller.dto.request.RequestDto;
import com.hlebon.controller.dto.response.ResponseDto;
import com.hlebon.service.ValidationResult;
import com.hlebon.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController("/api")
public class ValidatorController {

    private final ValidatorService validatorService;

    @Autowired
    public ValidatorController(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @PostMapping("validate")
    public ResponseDto validate(@RequestBody RequestDto dtos) {
        ResponseDto response = new ResponseDto();
        for (final Dto dto : dtos.getTest()) {
            ResponseDto.Row row = new ResponseDto.Row();
            ValidationResult validationResult = validatorService.validate(dto);
            if (!validationResult.isOk()) {
                List<ResponseDto.Row.RowError> rowErrors = validationResult
                        .getErrors()
                        .stream()
                        .map(e -> new ResponseDto.Row.RowError(e.getMessage()))
                        .collect(Collectors.toList());
                row.setErrors(rowErrors);
            }

            response.addRow(row);
        }

        return response;
    }
}
