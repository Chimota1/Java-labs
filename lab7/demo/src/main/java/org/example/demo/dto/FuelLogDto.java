package org.example.demo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class FuelLogDto {
    private Long id;

    @NotNull(message = "ID автомобіля обов'язкове")
    private Long vehicleId;

    @NotNull(message = "Кількість літрів обов'язкова")
    @Positive(message = "Кількість літрів має бути більшою за 0")
    private Double liters;

    @NotNull(message = "Ціна за літр обов'язкова")
    @DecimalMin(value = "0.01", message = "Ціна має бути більшою за 0")
    private BigDecimal pricePerLiter;

    @NotBlank(message = "Дата заправки обов'язкова")
    private String refuelDate;

    // Геттери та Сеттери
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }
    public Double getLiters() { return liters; }
    public void setLiters(Double liters) { this.liters = liters; }
    public BigDecimal getPricePerLiter() { return pricePerLiter; }
    public void setPricePerLiter(BigDecimal pricePerLiter) { this.pricePerLiter = pricePerLiter; }
    public String getRefuelDate() { return refuelDate; }
    public void setRefuelDate(String refuelDate) { this.refuelDate = refuelDate; }
}