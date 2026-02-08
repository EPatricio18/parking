package com.statementlabs.parking_api.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TariffCalculator {
    BigDecimal calculate(LocalDateTime entry, LocalDateTime exit);
}