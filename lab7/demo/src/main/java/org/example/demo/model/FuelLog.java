package org.example.demo.model;

import java.time.LocalDate;

public class FuelLog {
    private Long id;
    private Long vehicleId;
    private LocalDate date;
    private double liters;
    private double cost;
    private String station;

    public FuelLog() {}
    public FuelLog(Long id, Long vehicleId, LocalDate date, double liters, double cost, String station) {
        this.id = id; this.vehicleId = vehicleId; this.date = date;
        this.liters = liters; this.cost = cost; this.station = station;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public double getLiters() { return liters; }
    public void setLiters(double liters) { this.liters = liters; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public String getStation() { return station; }
    public void setStation(String station) { this.station = station; }
}