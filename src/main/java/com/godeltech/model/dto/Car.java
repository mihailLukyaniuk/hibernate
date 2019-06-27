package com.godeltech.model.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "manufactorer")
    private String manufactorer;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car", fetch = FetchType.EAGER)
    private List<Rental> rentals = new ArrayList<>();

    @ManyToOne(targetEntity = Company.class, fetch = FetchType.EAGER)
    private Company company;

    public Car() {
    }

    public Car(String manufactorer, String model, Integer year, Company company) {
        this.manufactorer = manufactorer;
        this.model = model;
        this.year = year;
        this.company = company;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
                ", company=" + company +
                '}';
    }
}

