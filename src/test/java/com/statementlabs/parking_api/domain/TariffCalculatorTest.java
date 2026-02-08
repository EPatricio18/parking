package com.statementlabs.parking_api.domain;

import com.statementlabs.parking_api.infrastructure.service.DefaultTariffCalculator;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TariffCalculatorTest {

    private final TariffCalculator calculator = new DefaultTariffCalculator();

    @Test
    void calculate_lessThan6Hours() {
        LocalDateTime entry = LocalDateTime.of(2026, 2, 7, 8, 0);
        LocalDateTime exit = entry.plusHours(4);

        BigDecimal result = calculator.calculate(entry, exit);
        // Em vez de assertEquals(BigDecimal.valueOf(1200), result);
        assertEquals(0, new BigDecimal("1200.00").compareTo(result));
    }

    @Test
    void calculate_moreThan6Hours() {
        LocalDateTime entry = LocalDateTime.of(2026, 2, 7, 8, 0);
        LocalDateTime exit = entry.plusHours(8);

        BigDecimal result = calculator.calculate(entry, exit);
        //assertEquals(BigDecimal.valueOf(2200), result);
        assertEquals(0, new BigDecimal("2200.00").compareTo(result));

    }

    @Test
    void calculate_exitBeforeEntry_throwsException() {
        LocalDateTime entry = LocalDateTime.of(2026, 2, 7, 10, 0);
        LocalDateTime exit = entry.minusHours(1);

        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(entry, exit));
    }
}