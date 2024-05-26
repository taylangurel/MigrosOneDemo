package com.migrosone.MigrosOneDemo.model;

import lombok.Data;

@Data
public class CourierTravelInfo {
    private double lastLatitude;
    private double lastLongitude;
    private double totalDistance;
    private boolean firstUpdate;

    public CourierTravelInfo() {
        this.totalDistance = 0.0;
        this.firstUpdate = true;
    }

    public void updateLocation(double latitude, double longitude) {
        if (firstUpdate) {
            this.lastLatitude = latitude;
            this.lastLongitude = longitude;
            this.firstUpdate = false;
        } else {
            double distance = calculateDistance(this.lastLatitude, this.lastLongitude, latitude, longitude);
            this.totalDistance += distance;
            this.lastLatitude = latitude;
            this.lastLongitude = longitude;
        }
    }

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int EARTH_RADIUS = 6371000; // Radius of the Earth in meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }
}