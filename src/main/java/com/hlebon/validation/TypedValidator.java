package com.hlebon.validation;

import com.hlebon.Type;
import com.hlebon.controller.dto.request.Dto;

public interface TypedValidator<T extends Dto> {

    Type getType();

    ValidationError validate(T dto);
}
