package com.hlebon.validation.option;

import com.hlebon.controller.dto.OptionDto;
import com.hlebon.validation.ValidationError;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * the style can be either American or European
 */
@Component
public class StyleValidator extends OptionBaseValidator {

    private static final Collection<String> SUPPORTED_STYLES = asList(
            "AMERICAN",
            "EUROPEAN"
    );

    @Override
    public ValidationError validate(final OptionDto dto) {
        String style = dto.getStyle();
        if (style == null) {
            return null;
        }

        if (!SUPPORTED_STYLES.contains(style)) {
            return new ValidationError("The style can be either AMERICAN or EUROPEAN");
        }

        return null;
    }
}
