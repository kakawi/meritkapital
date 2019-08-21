package com.hlebon.validation.spot;

import com.hlebon.Type;
import com.hlebon.controller.dto.SpotDto;
import com.hlebon.validation.Validator;

public abstract class SpotBaseValidator implements Validator<SpotDto> {

    @Override
    public Type getType() {
        return Type.SPOT;
    }

}
