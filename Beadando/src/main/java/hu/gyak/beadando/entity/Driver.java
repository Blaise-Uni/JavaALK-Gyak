package hu.gyak.beadando.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pilota")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nev", nullable = false)
    private String name;

    @Column(name = "nem", nullable = false)
    private String gender;

    @Column(name = "szuldat", nullable = false)
    private Date dateOfBirth;

    @Column(name = "nemzet", nullable = false)
    private String nationality;
}
