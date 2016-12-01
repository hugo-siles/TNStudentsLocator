/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.tnstudentlocator.Utils;

import com.thinknear.tnstudentlocator.model.GeoObject;

/**
 *
 * @author hugo.siles
 */
public class Utils {
    
    private static final int EARTH_RADIUS = 6371;
    private static final int METERS_CONVERSION_FACTOR = EARTH_RADIUS * 1000;
    
    public static double getDistance(GeoObject object1, GeoObject object2) {
        
        
        double latDistance = Math.toRadians(object2.getLatitude() - object1.getLatitude());
        double lonDistance = Math.toRadians(object2.getLongitude() - object1.getLongitude());
        
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(object2.getLatitude())) * Math.cos(Math.toRadians(object1.getLatitude()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = METERS_CONVERSION_FACTOR * c;
        distance *= distance;
        return Math.sqrt(distance);
    }
    
}
