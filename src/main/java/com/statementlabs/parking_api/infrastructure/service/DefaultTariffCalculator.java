package com.statementlabs.parking_api.infrastructure.service;

import com.statementlabs.parking_api.domain.TariffCalculator;
import org.springframework.stereotype.Component;
import java.time.Duration;
import java.time.LocalDateTime;
import java.math.BigDecimal;


@Component
public class DefaultTariffCalculator implements TariffCalculator {

    @Override
    public BigDecimal calculate(LocalDateTime entry, LocalDateTime exit) {
        if (exit.isBefore(entry)) {
            throw new IllegalArgumentException("Exit time cannot be before entry time");
        }

        long minutes = Duration.between(entry, exit).toMinutes();

        long hours = (long) Math.ceil(minutes / 60.0);

        long value;
        if (hours <= 6) {
            value = hours * 300;
        } else {
            value = (6 * 300) + ((hours - 6) * 200);
        }
        
        return BigDecimal.valueOf(value).setScale(2);
    }
}