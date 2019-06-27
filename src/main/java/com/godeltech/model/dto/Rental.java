package com.godeltech.model.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Rental implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "startDateTime")
    private LocalDate startDateTime;

    @Column(name = "endDateTime")
    private LocalDate endDateTime;

    @ManyToOne(targetEntity = Car.class, fetch = FetchType.EAGER)
    private Car car;

    @ManyToOne(targetEntity = Customer.class , fetch = FetchType.EAGER)
    private Customer customer;

    public Rental() {
    }

    public Rental(LocalDate startDateTime, LocalDate endDateTime, Car car, Customer customer) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.car = car;
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDate startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDate getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDate endDateTime) {
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
                ", car=" + car +
                ", customer=" + customer +
                '}';
    }
}