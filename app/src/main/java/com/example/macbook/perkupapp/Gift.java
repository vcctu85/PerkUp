package com.example.macbook.perkupapp;

public class Gift {
    private String location;
    private double latitude;
    private double longitude;
    public boolean atLocation;

    public Gift(String location, double latitude, double longitude) {
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;

    }
    public Gift(String location, double latitude, double longitude, boolean atLocation) {
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.atLocation = atLocation;
    }

    public boolean isAtLocation() {
        return atLocation;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getLocation() {
        return location;
    }
}
