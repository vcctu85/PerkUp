package com.example.macbook.perkupapp;

public class Gift {
    private int numPoints;
    private String location;

    public Gift(int numPoints, String location) {
        this.numPoints = numPoints;
        this.location = location;

    }

    public int getNumPoints() {
        return numPoints;
    }

    public String getLocation() {
        return location;
    }
}
