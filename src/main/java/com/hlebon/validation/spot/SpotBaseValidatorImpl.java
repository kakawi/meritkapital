package com.hlebon.validation.spot;

import com.hlebon.controller.dto.SpotDto;
import com.hlebon.validation.ValidationError;
import org.springframework.stereotype.Component;

@Component
public class SpotBaseValidatorImpl extends SpotBaseValidator {

    @Override
    public ValidationError validate(SpotDto dto) {
        return null;
    }

}
