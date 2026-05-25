package org.example.demo.repository;

import org.example.demo.model.FuelLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelLogRepository extends JpaRepository<FuelLog, Long> {
    List<FuelLog> findByVehicle_Id(Long vehicleId);
}

