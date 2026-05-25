package org.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TripDto {
    private Long id;

    @NotBlank(message = "Route is required")
    private String route;

    @NotNull(message = "Driver ID is required")
    private Long driverId;

    @NotNull(message = "Vehicle ID is required")
    private Long vehicleId;

    @Min(value = 1, message = "Distance must be greater than 0")
    private Integer distance;

    private String status;
    private String driverName;
    private String vehicleLicensePlate;

    public TripDto() {
    }

    public TripDto(Long id, String route, Long driverId, Long vehicleId, Integer distance, String status, String driverName, String vehicleLicensePlate) {
        this.id = id;
        this.route = route;
        this.driverId = driverId;
        this.vehicleId = vehicleId;
        this.distance = distance;
        this.status = status;
        this.driverName = driverName;
        this.vehicleLicensePlate = vehicleLicensePlate;
    }

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
    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public String getVehicleLicensePlate() { return vehicleLicensePlate; }
    public void setVehicleLicensePlate(String vehicleLicensePlate) { this.vehicleLicensePlate = vehicleLicensePlate; }
}

