/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.studentlocator.utils;

import com.thinknear.studentlocator.model.BoxCoordinates;
import com.thinknear.studentlocator.model.GeoPosition;

/**
 *
 * @author hugo.siles
 */
public class Utils {
    
    private static final double FACTOR_CONVERSION = Math.PI * 180;
    private static final int EARTH_RADIUS_IN_KM = 6371;
    private static final int EARTH_RADIUS_IN_MTS = EARTH_RADIUS_IN_KM * 1000;
    
    public static double getDistance(GeoPosition pos1, GeoPosition pos2) {
        
        
        double latDistance = Math.toRadians(pos2.getLatitude() - pos1.getLatitude());
        double lonDistance = Math.toRadians(pos2.getLongitude() - pos1.getLongitude());
        
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(pos2.getLatitude())) * Math.cos(Math.toRadians(pos1.getLatitude()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = EARTH_RADIUS_IN_MTS * c;
        distance *= distance;
        return Math.sqrt(distance);
    }
    
    public static GeoPosition calculateDeltaPosition(GeoPosition origPosition, 
            double deltaLat, double deltaLong){
        
        double newLat = origPosition.getLatitude() + (FACTOR_CONVERSION)*(deltaLat/EARTH_RADIUS_IN_MTS);
        double newLon = origPosition.getLongitude() + (FACTOR_CONVERSION)*(deltaLong/EARTH_RADIUS_IN_MTS)/Math.cos(origPosition.getLatitude());
        
        return new GeoPosition(newLat, newLon);
        
    }
    
    public static boolean isPointInsideBox(BoxCoordinates box, GeoPosition point){
        
        GeoPosition nwCoordinate = box.getNwCoordinate();
        GeoPosition seCoordinate = box.getSeCoordinate();
        
        return ( nwCoordinate.getLatitude() <= point.getLatitude() && 
                 point.getLatitude() <= seCoordinate.getLatitude() && 
                nwCoordinate.getLongitude() <= point.getLongitude() && 
                point.getLongitude() <= seCoordinate.getLongitude());
   
    }
    
}
