package com.example.macbook.perkupapp;

public class Gift {
    private String location;
    private String address;
    private boolean atLocation;

    public Gift(String location, String address, boolean atLocation) {
        this.location = location;
        this.address = address;
        this.atLocation = atLocation;

    }

    public boolean isAtLocation() {
        return atLocation;
    }

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }
}
