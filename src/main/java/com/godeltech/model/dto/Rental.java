package com.godeltech.model.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Rental", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")})
public class Rental implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "startDateTime", unique = false, nullable = false, length = 100)
    private Date startDateTime;
    @Column(name = "endDateTime", unique = false, nullable = false, length = 100)
    private Date endDateTime;

    public Rental() {
    }

    public Rental(Long id, Date startDateTime, Date endDateTime) {
        this.id = id;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    @ManyToOne
    private Car car;

    @ManyToOne
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return id.equals(rental.id) &&
                startDateTime.equals(rental.startDateTime) &&
                endDateTime.equals(rental.endDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDateTime, endDateTime);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                '}';
    }
}