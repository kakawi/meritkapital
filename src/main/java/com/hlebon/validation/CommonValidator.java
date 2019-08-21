package com.hlebon.validation;

import com.hlebon.controller.dto.request.Dto;

public interface CommonValidator {

    ValidationError validate(Dto dto);
}
