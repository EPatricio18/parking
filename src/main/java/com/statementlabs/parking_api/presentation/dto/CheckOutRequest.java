package com.statementlabs.parking_api.presentation.dto;

import jakarta.validation.constraints.NotBlank;

public record CheckOutRequest(
    @NotBlank String plateOrTicketId
) {}
