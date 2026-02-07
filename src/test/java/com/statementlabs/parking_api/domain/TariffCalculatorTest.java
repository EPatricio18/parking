package com.statementlabs.parking_api.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TariffCalculatorTest {

    private final TariffCalculator calculator = new TariffCalculator();

    @Test
    void calculate_lessThan6Hours() {
        LocalDateTime entry = LocalDateTime.of(2026, 2, 7, 8, 0);
        LocalDateTime exit = entry.plusHours(4);

        BigDecimal result = calculator.calculate(entry, exit);
        assertEquals(BigDecimal.valueOf(1200), result);
    }

    @Test
    void calculate_moreThan6Hours() {
        LocalDateTime entry = LocalDateTime.of(2026, 2, 7, 8, 0);
        LocalDateTime exit = entry.plusHours(8);

        BigDecimal result = calculator.calculate(entry, exit);
        assertEquals(BigDecimal.valueOf(2200), result);
    }

    @Test
    void calculate_exitBeforeEntry_throwsException() {
        LocalDateTime entry = LocalDateTime.of(2026, 2, 7, 10, 0);
        LocalDateTime exit = entry.minusHours(1);

        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(entry, exit));
    }
}