/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.studentlocator.model;

import com.thinknear.studentlocator.utils.Utils;

/**
 *
 * @author hugo.siles
 */
public class SquareClassroom extends GeoPosition{
    
    private static final int ROOM_SIDE_IN_MTS = 20; //assume fix size for all the rooms
    private static final int HALF_SIDE_IN_MTS = ROOM_SIDE_IN_MTS / 2; //We assume that the coordinates of the room are exactly in the middle 
    
    private final String name;

    public SquareClassroom(String name, double latitude, double longitude) {
        super(latitude, longitude);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
    public double getDistanceToSide(){
        return HALF_SIDE_IN_MTS; 
    }
   
    
    public BoxCoordinates getCornersCoordinates(){
        
        GeoPosition nwCoordinate = Utils.calculateDeltaPosition(this, HALF_SIDE_IN_MTS, -HALF_SIDE_IN_MTS);      
        GeoPosition seCoordinate = Utils.calculateDeltaPosition(this, -HALF_SIDE_IN_MTS, HALF_SIDE_IN_MTS);
               
        return new BoxCoordinates(nwCoordinate, seCoordinate);
        
        
    }
}
