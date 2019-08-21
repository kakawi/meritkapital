package com.hlebon.validation.common;

import com.hlebon.controller.dto.request.Dto;
import com.hlebon.validation.ValidationError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(BlockJUnit4ClassRunner.class)
public class SupportedCounterpartiesValidatorTest {

    private SupportedCounterpartiesValidator validator = new SupportedCounterpartiesValidator();

    @Test
    public void validate_successPluto1() {
        // prerequisites
        Dto dto = mock(Dto.class);
        when(dto.getCustomer()).thenReturn("PLUTO1");

        // test
        ValidationError actual = validator.validate(dto);

        // assert
        assertNull(actual);
    }

    @Test
    public void validate_successPluto2() {
        // prerequisites
        Dto dto = mock(Dto.class);
        when(dto.getCustomer()).thenReturn("PLUTO2");

        // test
        ValidationError actual = validator.validate(dto);

        // assert
        assertNull(actual);
    }

    @Test
    public void validate_wrong() {
        // prerequisites
        Dto dto = mock(Dto.class);
        when(dto.getCustomer()).thenReturn("PLUTO3");

        // test
        ValidationError actual = validator.validate(dto);

        // assert
        assertNotNull(actual);
    }
}