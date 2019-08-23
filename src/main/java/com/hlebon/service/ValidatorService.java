package com.hlebon.service;

import com.hlebon.controller.dto.request.Dto;

public interface ValidatorService {

    ValidationResult validate(Dto dto);
}
