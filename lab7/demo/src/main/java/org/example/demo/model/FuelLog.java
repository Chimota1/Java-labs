package org.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "fuel_logs")
public class FuelLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @Column(nullable = false)
    private Double liters;

    @Column(name = "price_per_liter", nullable = false)
    private BigDecimal pricePerLiter;

    @Column(name = "refuel_date")
    private String refuelDate;

    public FuelLog() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public Double getLiters() { return liters; }
    public void setLiters(Double liters) { this.liters = liters; }
    public BigDecimal getPricePerLiter() { return pricePerLiter; }
    public void setPricePerLiter(BigDecimal pricePerLiter) { this.pricePerLiter = pricePerLiter; }
    public String getRefuelDate() { return refuelDate; }
    public void setRefuelDate(String refuelDate) { this.refuelDate = refuelDate; }
}

