package icine.cinema.dashboard.infrastructure.model;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.List;

/**
 * The persistent class for the AUTHORITY database table.
 * 
 */
@Entity
@NamedQuery(name="Authority.findAll", query="SELECT a FROM Authority a")
public class Authority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="authority_id_seq", sequenceName="authority_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="authority_id_seq")
	private long id;

	private String description;

	private String name;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="authority")
	private List<User> users;

	public Authority() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}