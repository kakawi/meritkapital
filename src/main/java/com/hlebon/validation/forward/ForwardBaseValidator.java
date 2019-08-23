package com.hlebon.validation.forward;

import com.hlebon.Type;
import com.hlebon.controller.dto.ForwardDto;
import com.hlebon.validation.TypedValidator;

public abstract class ForwardBaseValidator implements TypedValidator<ForwardDto> {

    @Override
    public Type getType() {
        return Type.FORWARD;
    }

}
