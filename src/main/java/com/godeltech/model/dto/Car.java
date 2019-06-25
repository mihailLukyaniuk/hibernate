package com.godeltech.model.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Car", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")})
public class Car implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "manufactorer", unique = false, nullable = false, length = 100)
    private String manufactorer;
    @Column(name = "model", unique = false, nullable = false, length = 100)
    private String model;
    @Column(name = "year", unique = false, nullable = false, length = 100)
    private Integer year;

    @ManyToOne
    private Company company;

    @OneToMany
    @JoinColumn(name = "rental_id")
    private List<Rental> rentals = new ArrayList<>();

    public Car(Long id, String manufactorer, String model, Integer year) {
        this.id = id;
        this.manufactorer = manufactorer;
        this.model = model;
        this.year = year;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufactorer() {
        return manufactorer;
    }

    public void setManufactorer(String manufactorer) {
        this.manufactorer = manufactorer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id.equals(car.id) &&
                manufactorer.equals(car.manufactorer) &&
                model.equals(car.model) &&
                year.equals(car.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manufactorer, model, year);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", manufactorer='" + manufactorer + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}

