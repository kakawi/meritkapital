package com.hlebon.validation.common;

import com.hlebon.controller.dto.request.Dto;
import com.hlebon.repository.HolidayRepository;
import com.hlebon.validation.ValidationError;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ValueDateValidatorTest {

    @Mock
    private HolidayRepository holidayRepository;

    @InjectMocks
    private ValueDateValidator valueDateValidator;

    @Before
    public void reset() {
        Mockito.reset(holidayRepository);
    }

    @Test
    public void validate_success() {
        // prerequisites
        Dto dto = mock(Dto.class);
        Month month = Month.AUGUST;
        int dayOfMonth = 23;
        when(dto.getValueDate()).thenReturn(LocalDate.of(2019, month, dayOfMonth));
        when(holidayRepository.existsByMonthAndDayOfMonth(month, dayOfMonth)).thenReturn(false);

        // test
        ValidationError actual = valueDateValidator.validate(dto);

        // assert
        assertNull(actual);
    }

    @Test
    public void validate_weekends() {
        // prerequisites
        Dto dto = mock(Dto.class);
        Month month = Month.AUGUST;
        int dayOfMonth = 24;
        when(dto.getValueDate()).thenReturn(LocalDate.of(2019, month, dayOfMonth));
        when(holidayRepository.existsByMonthAndDayOfMonth(month, dayOfMonth)).thenReturn(false);

        // test
        ValidationError actual = valueDateValidator.validate(dto);

        // assert
        assertNotNull(actual);
        assertEquals("ValueDate cannot fall on weekend", actual.getMessage());
    }

    @Test
    public void validate_holiday() {
        // prerequisites
        Dto dto = mock(Dto.class);
        Month month = Month.AUGUST;
        int dayOfMonth = 23;
        when(dto.getValueDate()).thenReturn(LocalDate.of(2019, month, dayOfMonth));
        when(holidayRepository.existsByMonthAndDayOfMonth(month, dayOfMonth)).thenReturn(true);

        // test
        ValidationError actual = valueDateValidator.validate(dto);

        // assert
        assertNotNull(actual);
        assertEquals("ValueDate cannot fall on non-working day", actual.getMessage());
    }
}