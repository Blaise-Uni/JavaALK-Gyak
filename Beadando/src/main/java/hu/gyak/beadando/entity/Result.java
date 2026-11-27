package hu.gyak.beadando.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "eredmeny")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datum", nullable = false)
    private Date date;

    @Column(name = "plotaaz", nullable = false)
    private Long driverId;

    @Column(name = "helyezes")
    private short placement;

    @Column(name = "hiba")
    private String retirement;

    @Column(name = "csapat")
    private String team;

    @Column(name = "tipus", nullable = false)
    private String carType;

    @Column(name = "motor", nullable = false)
    private String engineType;

    public Result() {

    }

    public Result(Date date, Long driverId, short placement, String retirement, String team, String carType, String engineType) {
        this.date = date;
        this.driverId = driverId;
        this.placement = placement;
        this.retirement = retirement;
        this.team = team;
        this.carType = carType;
        this.engineType = engineType;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public short getPlacement() {
        return placement;
    }

    public void setPlacement(short placement) {
        this.placement = placement;
    }

    public String getRetirement() {
        return retirement;
    }

    public void setRetirement(String retirement) {
        this.retirement = retirement;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
