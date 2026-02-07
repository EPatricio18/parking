package com.statementlabs.parking_api.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class TariffCalculator {

    public int calculate(LocalDateTime entry, LocalDateTime exit) {

        long hours = Duration.between(entry, exit).toHours();

        if (hours <= 1) {
            return 200;
        }

        return (int) (hours * 300);
    }
}