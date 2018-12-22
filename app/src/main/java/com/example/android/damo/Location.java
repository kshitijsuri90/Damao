package com.example.android.damo;

public class Location {

    private double Latitude;
    private double Longitude;

    public double getLatitude() {
        return Latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public Location(double latitude, double longitude) {

        Latitude = latitude;
        Longitude = longitude;
    }
}
