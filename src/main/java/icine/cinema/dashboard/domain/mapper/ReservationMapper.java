package icine.cinema.dashboard.domain.mapper;

import icine.cinema.dashboard.domain.dto.request.ReservationRequestDTO;
import icine.cinema.dashboard.domain.dto.response.ReservationResponseDTO;
import icine.cinema.dashboard.infrastructure.model.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationResponseDTO toReservationResponseDTO(Reservation reservationResponseDTO);
    Reservation toReservation(ReservationRequestDTO reservationRequestDTO);
}
