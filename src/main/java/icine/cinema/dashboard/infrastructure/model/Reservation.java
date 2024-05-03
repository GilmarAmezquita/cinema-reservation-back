package icine.cinema.dashboard.infrastructure.model;

import java.io.Serializable;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistent class for the RESERVATION database table.
 *
 */
@Entity
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
@SQLDelete(sql = "UPDATE reservation SET ACTIVE=false WHERE id = ?")
@SQLRestriction("ACTIVE = true")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="reservation_id_seq", sequenceName="reservation_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reservation_id_seq")
	@OrderBy
	private long id;

	private Integer seats;

	//bi-directional many-to-one association to Projection
	@ManyToOne
	private Projection projection;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OrderBy("id")
    private List<SeatReserved> seatReserveds;

	@Column(name = "active")
	private Boolean active;

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<SeatReserved> getSeatReserveds() {
        return seatReserveds;
    }

    public void setSeatReserveds(List<SeatReserved> seatReserveds) {
        this.seatReserveds = seatReserveds;
    }

    public Reservation() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getSeats() {
		return this.seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public Projection getProjection() {
		return this.projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}