package com.sachin.cab.booking.servlet.model;

public class Driver {
    private int id;
    private String name;
    private String licenseNumber;
    private String phoneNumber;
    private String carModel;
    private boolean isAvailable;


    // Parameterized Constructor
    public Driver(int id, String name, String licenseNumber, String phoneNumber, String carModel, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.phoneNumber = phoneNumber;
        this.carModel = carModel;
        this.isAvailable = isAvailable;
    }

    public Driver(String name, String license) {
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getCarModel() { return carModel; }
    public void setCarModel(String carModel) { this.carModel = carModel; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }

    @Override
    public String toString() {
        return "Driver{id=" + id + ", name='" + name + "', licenseNumber='" + licenseNumber +
                "', phoneNumber='" + phoneNumber + "', carModel='" + carModel +
                "', isAvailable=" + isAvailable + "}";
    }
}
