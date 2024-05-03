package icine.cinema.dashboard.infrastructure.model;

import java.io.Serializable;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MOVIE database table.
 * 
 */
@Entity
@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m")
@SQLDelete(sql = "UPDATE movie SET ACTIVE=false WHERE id = ?")
@SQLRestriction("ACTIVE = true")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="movie_id_seq", sequenceName="movie_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="movie_id_seq")
	private long id;

	private String director;

	@Column(name="DURATION_MIN")
	private BigDecimal durationMin;

	private String name;

	private String url;

	private Date premiere;

	//bi-directional many-to-one association to Projection
	@OneToMany(mappedBy="movie")
	@OrderBy("id")
	private List<Projection> projections;

	@Column(name = "active")
	private Boolean active;

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Movie() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public BigDecimal getDurationMin() {
		return this.durationMin;
	}

	public void setDurationMin(BigDecimal durationMin) {
		this.durationMin = durationMin;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getPremiere() {
		return this.premiere;
	}

	public void setPremiere(Date premiere) {
		this.premiere = premiere;
	}

	public List<Projection> getProjections() {
		return this.projections;
	}

	public void setProjections(List<Projection> projections) {
		this.projections = projections;
	}

	public Projection addProjection(Projection projection) {
		getProjections().add(projection);
		projection.setMovie(this);

		return projection;
	}

	public Projection removeProjection(Projection projection) {
		getProjections().remove(projection);
		projection.setMovie(null);

		return projection;
	}

}