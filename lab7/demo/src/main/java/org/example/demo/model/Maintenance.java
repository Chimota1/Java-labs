package org.example.demo.model;

import java.time.LocalDate;

public class Maintenance {
    private Long id;
    private Long vehicleId;
    private String type;        // OIL_CHANGE, TIRE, INSPECTION, REPAIR
    private LocalDate date;
    private double cost;
    private String description;

    public Maintenance() {}
    public Maintenance(Long id, Long vehicleId, String type, LocalDate date, double cost, String description) {
        this.id = id; this.vehicleId = vehicleId; this.type = type;
        this.date = date; this.cost = cost; this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}