package org.example.demo.model;

public class Vehicle {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private String licensePlate;
    private String status; // AVAILABLE, IN_USE, MAINTENANCE

    public Vehicle() {}
    public Vehicle(Long id, String brand, String model, int year, String licensePlate, String status) {
        this.id = id; this.brand = brand; this.model = model;
        this.year = year; this.licensePlate = licensePlate; this.status = status;
    }

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}