package icine.cinema.dashboard.infrastructure.model;

import java.io.Serializable;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The persistent class for the "user" database table.
 * 
 */
@Entity
@Table(name="\"user\"")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u ")
@SQLDelete(sql = "UPDATE \"user\" SET ACTIVE=false WHERE id = ?")
@SQLRestriction("ACTIVE = true")
public class User implements UserDetails, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="user_id_seq", sequenceName="user_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_id_seq")
	private long id;

	private String address;

	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String password;

	private Boolean active;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="user")
	private List<Reservation> reservations;

	//bi-directional many-to-one association to Authority
	@ManyToOne
	private Authority authority;

	public User() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = List.of();
		if(this.getAuthority() != null) {
			authorities = Stream.of(this.getAuthority()).map(
					authority -> new SimpleGrantedAuthority(authority.getName())
			).collect(Collectors.toList());
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return this.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.getActive();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setUser(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setUser(null);

		return reservation;
	}

	public Authority getAuthority() {
		return this.authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

}