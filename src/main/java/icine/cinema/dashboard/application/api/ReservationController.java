package icine.cinema.dashboard.application.api;

import icine.cinema.dashboard.domain.dto.response.ReservationResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reservation")
public interface ReservationController {
    @GetMapping
    Page<ReservationResponseDTO> getReservations(
            @PageableDefault Pageable pageable
    );

    @PostMapping
    ReservationResponseDTO createReservation();

    @DeleteMapping()
    void deleteReservation();
}
