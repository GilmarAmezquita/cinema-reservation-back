package icine.cinema.dashboard.infrastructure.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.io.Serializable;

@Entity
@NamedQuery(name="SeatReserved.findAll", query="SELECT sr FROM SeatReserved sr")
@SQLDelete(sql = "UPDATE seat_reserved SET ACTIVE=false WHERE id = ?")
@SQLRestriction("ACTIVE = true")
public class SeatReserved implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="seat_reserved_id_seq", sequenceName="seat_reserved_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seat_reserved_id_seq")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "projection_id", nullable = false)
    private Projection projection;

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
