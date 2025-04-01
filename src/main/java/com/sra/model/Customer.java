package com.sra.model;

import com.sra.repository.ReservationsRepository;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;

@Component
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name",length=20, unique=true, nullable=false)
    private String name;

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<Reservation> getReservations(ReservationsRepository reservationsRepository) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation reservation : reservationsRepository.getData()) {
            if (reservation.getCustomerName().equals(this.name)) result.add(reservation);
        }
        return result;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Customer other = (Customer) object;
        return (this.name.equals(other.getName()));
    }

    public int hashCode () {
        return Objects.hash(name);

    }

}
