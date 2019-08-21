package com.hlebon.controller.dto;

import com.hlebon.Type;
import com.hlebon.controller.dto.request.Dto;

public class SpotDto extends Dto {

    @Override
    public Type getType() {
        return Type.SPOT;
    }
}
