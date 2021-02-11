package codeclan.booking_system.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    @OneToMany(mappedBy = "booking")
    @JsonIgnoreProperties({"booking"})
    private List<Booking> bookings;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
        this.bookings = new ArrayList<>();
    }

    public Customer() {
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
