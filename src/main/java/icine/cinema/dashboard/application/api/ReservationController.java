package icine.cinema.dashboard.application.api;

import icine.cinema.dashboard.domain.dto.request.ReservationRequestDTO;
import icine.cinema.dashboard.domain.dto.response.ReservationResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/reservation")
public interface ReservationController {
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    Page<ReservationResponseDTO> getReservations(
            @PageableDefault Pageable pageable
    );

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    ReservationResponseDTO createReservation(@RequestBody ReservationRequestDTO requestDTO);

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    void deleteReservation(@PathVariable long id);
}
