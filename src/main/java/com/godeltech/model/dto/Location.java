package com.godeltech.model.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Location", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")})
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "countryCode", unique = false, nullable = false, length = 100)
    private String countryCode;
    @Column(name = "city", unique = false, nullable = false, length = 100)
    private String city;
    @Column(name = "street", unique = false, nullable = false, length = 100)
    private String street;
    @Column(name = "building", unique = false, nullable = false, length = 100)
    private String building;

    public Location() {
    }

    public Location(Long id, String countryCode, String city, String street, String building) {
        this.id = id;
        this.countryCode = countryCode;
        this.city = city;
        this.street = street;
        this.building = building;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private List<Company> companies = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id.equals(location.id) &&
                countryCode.equals(location.countryCode) &&
                city.equals(location.city) &&
                street.equals(location.street) &&
                building.equals(location.building);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryCode, city, street, building);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", countryCode='" + countryCode + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                '}';
    }
}
