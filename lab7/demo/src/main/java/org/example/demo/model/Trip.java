package org.example.demo.model;

import java.time.LocalDate;

public class Trip {
    private Long id;
    private Long vehicleId;
    private Long driverId;
    private String route;
    private LocalDate date;
    private double distanceKm;
    private String status; // PLANNED, IN_PROGRESS, COMPLETED

    public Trip() {}
    public Trip(Long id, Long vehicleId, Long driverId, String route, LocalDate date, double distanceKm, String status) {
        this.id = id; this.vehicleId = vehicleId; this.driverId = driverId;
        this.route = route; this.date = date; this.distanceKm = distanceKm; this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }
    public Long getDriverId() { return driverId; }
    public void setDriverId(Long driverId) { this.driverId = driverId; }
    public String getRoute() { return route; }
    public void setRoute(String route) { this.route = route; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(double distanceKm) { this.distanceKm = distanceKm; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}