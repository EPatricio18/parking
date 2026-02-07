package com.statementlabs.parking_api.domain;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class TariffCalculator {

    public BigDecimal calculate(LocalDateTime entry, LocalDateTime exit) {

        if (exit.isBefore(entry)) {
            throw new IllegalArgumentException("Exit time cannot be before entry time");
        }

        long minutes = Duration.between(entry, exit).toMinutes();
        long hours = (long) Math.ceil(minutes / 60.0);

        BigDecimal total;
        if (hours <= 6) {
            total = BigDecimal.valueOf(hours * 300);
        } else {
            total = BigDecimal.valueOf((6 * 300) + ((hours - 6) * 200));
        }

        return total;
    }
}