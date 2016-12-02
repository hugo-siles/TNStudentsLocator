/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.studentlocator.model;

/**
 *
 * @author hugo.siles
 */
public class BoxCoordinates {
    
    private final GeoPosition nwCoordinate;
    private final GeoPosition seCoordinate;

    public BoxCoordinates(GeoPosition nwCoordinate, GeoPosition seCoordinate) {
        this.nwCoordinate = nwCoordinate;
        this.seCoordinate = seCoordinate;
    }

    public GeoPosition getNwCoordinate() {
        return nwCoordinate;
    }

    public GeoPosition getSeCoordinate() {
        return seCoordinate;
    }
    
}
