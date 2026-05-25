package org.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "driver_profiles")
public class DriverProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emergency_contact")
    private String emergencyContact;

    @Column(name = "medical_certificate")
    private String medicalCertificate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = false, unique = true)
    private Driver driver;

    public DriverProfile() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }
    public String getMedicalCertificate() { return medicalCertificate; }
    public void setMedicalCertificate(String medicalCertificate) { this.medicalCertificate = medicalCertificate; }
    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }
}

