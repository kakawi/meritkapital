package com.hlebon.validation.common;


import com.hlebon.controller.dto.request.Dto;
import com.hlebon.validation.ValidationError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(BlockJUnit4ClassRunner.class)
public class TradeAndValueDatesValidatorTest {

    private TradeAndValueDatesValidator validator = new TradeAndValueDatesValidator();

    @Test
    public void validate_success() {
        // prerequisites
        Dto dto = mock(Dto.class);
        LocalDate now = LocalDate.now();

        when(dto.getTradeDate()).thenReturn(now);
        when(dto.getValueDate()).thenReturn(now.plusDays(1));

        // test
        ValidationError actual = validator.validate(dto);

        // asserts
        assertNull(actual);
    }

    @Test
    public void validate_wrong() {
        // prerequisites
        Dto dto = mock(Dto.class);
        LocalDate now = LocalDate.now();

        when(dto.getTradeDate()).thenReturn(now.plusDays(1));
        when(dto.getValueDate()).thenReturn(now);

        // test
        ValidationError actula = validator.validate(dto);

        // asserts
        assertNotNull(actula);
    }
}