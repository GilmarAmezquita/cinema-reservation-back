package icine.cinema.dashboard.infrastructure.model;

import java.io.Serializable;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the PROJECTION database table.
 * 
 */
@Entity
@NamedQuery(name="Projection.findAll", query="SELECT p FROM Projection p")
@SQLDelete(sql = "UPDATE projection SET ACTIVE=false WHERE id = ?")
@SQLRestriction("ACTIVE = true")
public class Projection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="projection_id_seq", sequenceName="projection_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="projection_id_seq")
	@OrderBy
	private long id;

	@Column(name="START_DATE")
	private Date startDate;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	private Movie movie;

	//bi-directional many-to-one association to Room
	@ManyToOne
	private Room room;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="projection")
	@OrderBy("id")
	private List<Reservation> reservations;

	@OneToMany(mappedBy = "projection")
	@OrderBy("id")
	private Set<SeatReserved> seatReserveds = new LinkedHashSet<>();

	@Column(name = "active")
	private Boolean active;

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<SeatReserved> getSeatReserveds() {
		return seatReserveds;
	}

	public void setSeatReserveds(Set<SeatReserved> seatReserveds) {
		this.seatReserveds = seatReserveds;
	}

	public Projection() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setProjection(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setProjection(null);

		return reservation;
	}

}