package org.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VehicleDto {
    private Long id;

    @NotBlank(message = "Марка авто обов'язкова")
    private String make;

    @NotBlank(message = "Модель авто обов'язкова")
    private String model;

    @NotBlank(message = "Номерний знак обов'язковий")
    private String licensePlate;

    @NotNull(message = "Рік випуску обов'язковий")
    @Min(value = 1900, message = "Рік випуску не може бути меншим за 1900")
    private Integer manufactureYear;

    private String status;

    // Геттери та Сеттери
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
}