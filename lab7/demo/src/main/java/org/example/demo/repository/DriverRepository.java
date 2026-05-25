package org.example.demo.repository;

import org.example.demo.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query("select d from Driver d left join fetch d.profile where d.category = :category")
    List<Driver> findByCategoryWithProfile(@Param("category") String category);
}

