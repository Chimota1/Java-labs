package org.example.demo.repository;

import org.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByMake(String make);

    @Query("select distinct v from Vehicle v left join fetch v.fuelLogs where v.status = :status")
    List<Vehicle> findVehiclesWithFuelLogsByStatus(@Param("status") String status);
}

