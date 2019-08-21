package com.hlebon.validation.spot;

import com.hlebon.Type;
import com.hlebon.controller.dto.SpotDto;
import com.hlebon.validation.TypedValidator;

public abstract class SpotBaseValidator implements TypedValidator<SpotDto> {

    @Override
    public Type getType() {
        return Type.SPOT;
    }

}
