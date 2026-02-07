package com.parking_api.presentation.dto;

import jakarta.validation.constraints.NotBlank;

public record CheckInRequest(
    @NotBlank String plate
) {}