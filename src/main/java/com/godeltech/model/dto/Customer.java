package com.godeltech.model.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Customer", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")})
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login", unique = true, nullable = false, length = 100)
    private String login;
    @Column(name = "firstName", unique = false, nullable = false, length = 100)
    private String firstName;
    @Column(name = "lastName", unique = false, nullable = false, length = 100)
    private String lastName;

    @OneToMany
    @JoinColumn(name = "rental_id")
    private List<Rental> rentals = new ArrayList<>();


    public Customer() {
    }

    public Customer(Long id, String login, String firstName, String lastName) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getlogin() {
        return login;
    }

    public void setlogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) &&
                login.equals(customer.login) &&
                firstName.equals(customer.firstName) &&
                lastName.equals(customer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
