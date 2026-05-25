package org.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column(name = "license_plate", nullable = false, unique = true)
    private String licensePlate;

    @Column(name = "manufacture_year")
    private Integer manufactureYear;

    private String status;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<Trip> trips = new ArrayList<>();

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<FuelLog> fuelLogs = new ArrayList<>();

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<Maintenance> maintenances = new ArrayList<>();

    @ManyToMany(mappedBy = "assignedVehicles", fetch = FetchType.LAZY)
    private Set<Driver> assignedDrivers = new HashSet<>();

    public Vehicle() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    public Integer getManufactureYear() { return manufactureYear; }
    public void setManufactureYear(Integer manufactureYear) { this.manufactureYear = manufactureYear; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<Trip> getTrips() { return trips; }
    public void setTrips(List<Trip> trips) { this.trips = trips; }
    public List<FuelLog> getFuelLogs() { return fuelLogs; }
    public void setFuelLogs(List<FuelLog> fuelLogs) { this.fuelLogs = fuelLogs; }
    public List<Maintenance> getMaintenances() { return maintenances; }
    public void setMaintenances(List<Maintenance> maintenances) { this.maintenances = maintenances; }
    public Set<Driver> getAssignedDrivers() { return assignedDrivers; }
    public void setAssignedDrivers(Set<Driver> assignedDrivers) { this.assignedDrivers = assignedDrivers; }
}

