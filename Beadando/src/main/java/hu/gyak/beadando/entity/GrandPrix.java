package hu.gyak.beadando.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "gp")
public class GrandPrix {
    @Id
    @Column(name = "datum")
    private Date date;

    @Column(name = "nev", nullable = false)
    private String name;

    @Column(name = "helyszin", nullable = false)
    private String country;

    public GrandPrix() {

    }

    public GrandPrix(Date date, String name, String country){
        this.date = date;
        this.name = name;
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
