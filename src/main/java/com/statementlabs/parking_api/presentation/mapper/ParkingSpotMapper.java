package presentation.mapper;

import com.parking_api.domain.model.ParkingSpot;
import com.parking_api.presentation.dto.ParkingSpotDTO;

public class PresentationParkingSpotMapper {

    public static ParkingSpotDTO toDTO(ParkingSpot domain) {
        if (domain == null) return null;
        return new ParkingSpotDTO(
            domain.getId(),
            domain.getStatus()
        );
    }
}