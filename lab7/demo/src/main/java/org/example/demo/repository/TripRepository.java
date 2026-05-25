    package org.example.demo.repository;

    import org.example.demo.dto.TripDto;
    import org.example.demo.model.Trip;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    @Repository
    public interface TripRepository extends JpaRepository<Trip, Long> {

        @Query("select t from Trip t")
        List<Trip> findAllForNPlusOne();

        @Query("select t from Trip t join fetch t.driver join fetch t.vehicle")
        List<Trip> findAllWithDriverAndVehicle();

        @Query("select t from Trip t join fetch t.driver join fetch t.vehicle where t.status = :status")
        List<Trip> findByStatusWithJoins(@Param("status") String status);

        @Query(value = """
                select new org.example.demo.dto.TripDto(
                    t.id,
                    t.route,
                    d.id,
                    v.id,
                    t.distance,
                    t.status,
                    d.fullName,
                    v.licensePlate
                )
                from Trip t
                join t.driver d
                join t.vehicle v
                """,
                countQuery = "select count(t) from Trip t")
        Page<TripDto> findTripPageDto(Pageable pageable);
    }

