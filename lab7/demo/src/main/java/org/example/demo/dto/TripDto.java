package org.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TripDto {
    private Long id;

    @NotBlank(message = "Маршрут обов'язковий")
    private String route;

    @NotNull(message = "ID водія обов'язкове")
    private Long driverId;

    @NotNull(message = "ID автомобіля обов'язкове")
    private Long vehicleId;

    @Min(value = 1, message = "Дистанція має бути більшою за 0")
    private Integer distance;

    private String status;

    // Геттери та Сеттери
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRoute() { return route; }
    public void setRoute(String route) { this.route = route; }
    public Long getDriverId() { return driverId; }
    public void setDriverId(Long driverId) { this.driverId = driverId; }
    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }
    public Integer getDistance() { return distance; }
    public void setDistance(Integer distance) { this.distance = distance; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}