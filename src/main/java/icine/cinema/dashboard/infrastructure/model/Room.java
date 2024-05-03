package icine.cinema.dashboard.infrastructure.model;

import java.io.Serializable;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the ROOM database table.
 * 
 */
@Entity
@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
@SQLRestriction("ACTIVE = true")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="room_id_seq", sequenceName="room_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="room_id_seq")
	private long id;

	private BigDecimal capacity;

	//bi-directional many-to-one association to Projection
	@OneToMany(mappedBy="room")
	private List<Projection> projections;

	@OneToMany(mappedBy = "room")
	private Set<Seat> seats = new LinkedHashSet<>();

	public Set<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}

	public Room() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCapacity() {
		return this.capacity;
	}

	public void setCapacity(BigDecimal capacity) {
		this.capacity = capacity;
	}

	public List<Projection> getProjections() {
		return this.projections;
	}

	public void setProjections(List<Projection> projections) {
		this.projections = projections;
	}

	public Projection addProjection(Projection projection) {
		getProjections().add(projection);
		projection.setRoom(this);

		return projection;
	}

	public Projection removeProjection(Projection projection) {
		getProjections().remove(projection);
		projection.setRoom(null);

		return projection;
	}

}