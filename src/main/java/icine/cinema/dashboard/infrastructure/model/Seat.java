package icine.cinema.dashboard.infrastructure.model;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NamedQuery(name="Seat.findAll", query="SELECT s FROM Seat s")
@SQLDelete(sql = "UPDATE seat SET ACTIVE=false WHERE id = ?")
@SQLRestriction("ACTIVE = true")
public class Seat implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="seat_id_seq", sequenceName="seat_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seat_id_seq")
    private long id;

    @Column(name="SEAT_NUMBER")
    private String seatNumber;

    //bi-directional many-to-one association to Room
    @ManyToOne
    private Room room;

    @Column(name = "\"row\"")
    private Integer row;

    @Column(name = "number")
    private Integer number;

    @Column(name = "price")
    private Integer price;

    @OneToMany(mappedBy = "seat")
    private Set<SeatReserved> seatReserveds = new LinkedHashSet<>();

    public Set<SeatReserved> getSeatReserveds() {
        return seatReserveds;
    }

    public void setSeatReserveds(Set<SeatReserved> seatReserveds) {
        this.seatReserveds = seatReserveds;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Seat() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
