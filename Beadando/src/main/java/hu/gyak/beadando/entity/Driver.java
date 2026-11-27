package hu.gyak.beadando.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "pilota")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "az")
    private Long id;

    @Column(name = "nev", nullable = false)
    private String name;

    @Column(name = "nem", nullable = false)
    private String gender;

    @Column(name = "szuldat")
    private LocalDate dateOfBirth;

    @Column(name = "nemzet", nullable = false)
    private String nationality;

    public Driver() {

    }

    public Driver(String name, String gender, LocalDate dateOfBirth, String nationality) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
