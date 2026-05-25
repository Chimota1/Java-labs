package org.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "license_number", nullable = false, unique = true)
    private String licenseNumber;

    private String category;
    private String status;

    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private DriverProfile profile;

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    private List<Trip> trips = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "driver_vehicle_assignments",
            joinColumns = @JoinColumn(name = "driver_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    private Set<Vehicle> assignedVehicles = new HashSet<>();

    public Driver() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public DriverProfile getProfile() { return profile; }

    public void setProfile(DriverProfile profile) {
        this.profile = profile;
        if (profile != null) {
            profile.setDriver(this);
        }
    }

    public List<Trip> getTrips() { return trips; }
    public void setTrips(List<Trip> trips) { this.trips = trips; }
    public Set<Vehicle> getAssignedVehicles() { return assignedVehicles; }
    public void setAssignedVehicles(Set<Vehicle> assignedVehicles) { this.assignedVehicles = assignedVehicles; }
}

