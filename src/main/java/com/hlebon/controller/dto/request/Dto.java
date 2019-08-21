package com.hlebon.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hlebon.Type;
import com.hlebon.controller.dto.ForwardDto;
import com.hlebon.controller.dto.OptionDto;
import com.hlebon.controller.dto.SpotDto;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "Spot", value = SpotDto.class),
        @JsonSubTypes.Type(name = "Forward", value = ForwardDto.class),
        @JsonSubTypes.Type(name = "VanillaOption", value = OptionDto.class)
})
public abstract class Dto {

    public abstract Type getType();

}
