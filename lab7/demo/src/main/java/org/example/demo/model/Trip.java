package org.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @Column(name = "distance")
    private Integer distance;

    private String status;

    public Trip() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRoute() { return route; }
    public void setRoute(String route) { this.route = route; }
    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public Integer getDistance() { return distance; }
    public void setDistance(Integer distance) { this.distance = distance; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

