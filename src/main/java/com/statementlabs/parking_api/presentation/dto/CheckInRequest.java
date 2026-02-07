package presentation.dto;

import jakarta.validation.constraints.NotBlank;

public class CheckInRequest {
    @NotBlank(message = "Placa do veículo é obrigatória")
    private String licensePlate;

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
}
