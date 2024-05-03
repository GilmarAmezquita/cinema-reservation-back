package icine.cinema.dashboard.application.controller;

import icine.cinema.dashboard.application.api.ReservationController;
import icine.cinema.dashboard.domain.dto.request.ReservationRequestDTO;
import icine.cinema.dashboard.domain.dto.response.ReservationResponseDTO;
import icine.cinema.dashboard.domain.exception.error.IcineException;
import icine.cinema.dashboard.domain.mapper.ReservationMapper;
import icine.cinema.dashboard.infrastructure.model.*;
import icine.cinema.dashboard.infrastructure.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationControllerImpl implements ReservationController {
    private final ReservationRepository reservationRepository;
    private final ProjectionRepository projectionRepository;
    private final UserRepository userRepository;
    private final ReservationMapper reservationMapper;
    private final SeatRepository seatRepository;
    private final SeatReservedRepository seatReservedRepository;

    @Override
    public Page<ReservationResponseDTO> getReservations(Pageable pageable) {
        return reservationRepository.findAll(pageable).map(reservationMapper::toReservationResponseDTO);
    }

    @Override
    @Transactional
    public ReservationResponseDTO createReservation(ReservationRequestDTO requestDTO) {
        Projection projection = projectionRepository.findById(requestDTO.projectionId()).orElseThrow();
        User user = userRepository.findById(requestDTO.userId()).orElseThrow();
        Reservation reservation = reservationMapper.toReservation(requestDTO);
        List<Seat> seats = seatRepository.findAllById(requestDTO.seatIds());
        List<Long> seatIds = requestDTO.seatIds();

        if (projection.getSeatReserveds().stream().anyMatch(seatReserved -> seatIds.stream().anyMatch(seatId -> seatReserved.getSeat().getId() == seatId))) {
            throw new IcineException("Seat is already reserved", HttpStatus.BAD_REQUEST);
        }
        reservation.setProjection(projection);
        reservation.setUser(user);
        reservation.setSeatReserveds(
                seats.stream().map(seat -> {
                    SeatReserved seatReserved = new SeatReserved();
                    seatReserved.setSeat(seat);
                    seatReserved.setReservation(reservation);
                    seatReserved.setProjection(projection);
                    seatReserved.setActive(true);
                    return seatReserved;
                }).toList());
        reservation.setActive(true);
        reservationRepository.save(reservation);
        seatReservedRepository.saveAll(reservation.getSeatReserveds());
        return reservationMapper.toReservationResponseDTO(
                reservation
        );
    }

    @Override
    @Transactional
    public void deleteReservation(long id) {
        seatReservedRepository.deleteAllById(
                reservationRepository.findById(id).orElseThrow().getSeatReserveds().stream().map(SeatReserved::getId).toList()
        );
        reservationRepository.deleteById(id);
    }
}
