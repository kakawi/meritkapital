package com.hlebon.validation.option;

import com.hlebon.Type;
import com.hlebon.controller.dto.OptionDto;
import com.hlebon.validation.TypedValidator;

public abstract class OptionBaseValidator implements TypedValidator<OptionDto> {

    @Override
    public Type getType() {
        return Type.OPTIONS;
    }

}
