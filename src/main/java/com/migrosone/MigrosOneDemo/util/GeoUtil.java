package com.migrosone.MigrosOneDemo.util;

public class GeoUtil {

    // Radius of the Earth in meters
    private static final double EARTH_RADIUS = 6371000; // in meters

    // Function to calculate distance between two coordinates using Haversine formula
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Convert latitude and longitude from degrees to radians
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        // Calculate the change in coordinates
        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        // Calculate the distance using Haversine formula
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; // Distance in meters
    }

    // Function to check if a coordinate is within a certain radius of another coordinate
    public static boolean isWithinRadius(double lat1, double lon1, double lat2, double lon2, double radius) {
        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        return distance <= radius;
    }
}
