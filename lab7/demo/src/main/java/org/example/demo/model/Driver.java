package org.example.demo.model;

public class Driver {
    private Long id;
    private String fullName;
    private String licenseNumber;
    private String category;    // A, B, C, D
    private String status;      // FREE, BUSY

    public Driver() {}
    public Driver(Long id, String fullName, String licenseNumber, String category, String status) {
        this.id = id; this.fullName = fullName; this.licenseNumber = licenseNumber;
        this.category = category; this.status = status;
    }

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
}
