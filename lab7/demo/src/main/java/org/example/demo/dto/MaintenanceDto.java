package org.example.demo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class MaintenanceDto {
    private Long id;

    @NotNull(message = "ID автомобіля обов'язкове")
    private Long vehicleId;

    @NotBlank(message = "Опис робіт обов'язковий")
    private String description;

    @NotNull(message = "Вартість обов'язкова")
    @DecimalMin(value = "0.0", inclusive = true, message = "Вартість не може бути від'ємною")
    private BigDecimal cost;

    private String status;

    // Геттери та Сеттери
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}