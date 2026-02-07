package com.statementlabs.parking_api.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class TariffCalculator {

    public int calculate(LocalDateTime entry, LocalDateTime exit) {

        long minutes = Duration.between(entry, exit).toMinutes();
        
        double hours = Math.ceil(minutes / 60.0);

        if (hours <= 6) {
            return hours * 300.0;
        } else {
            return (6 * 300.0) + ((hours - 6) * 200.0);
        }

    }
}