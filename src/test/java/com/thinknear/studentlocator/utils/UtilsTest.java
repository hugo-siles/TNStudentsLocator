/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.studentlocator.utils;

import com.thinknear.studentlocator.utils.Utils;
import com.thinknear.studentlocator.model.GeoPosition;
import com.thinknear.studentlocator.model.SquareClassroom;
import com.thinknear.studentlocator.model.Student;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hugo.siles
 */
public class UtilsTest {
    
    public UtilsTest() {
    }
    
  
    @Test
    public void testGetDistance_CheckForRightDistances() {
        System.out.println("testGetDistance_CheckForRightDistances");
        
        GeoPosition engineeringClassroom = new SquareClassroom("engineeringClassroom", 34.069140, -118.442689);
        GeoPosition geologyClassroom = new SquareClassroom("geologyClassroom", 34.069585, -118.441878);
        GeoPosition psychologyClassroom = new SquareClassroom("psychologyClassroom", 34.069742, -118.441312);
        GeoPosition musicClassroom = new SquareClassroom("musicClassroom", 34.070223, -118.440193);
        GeoPosition humanitiesClassroom = new SquareClassroom("humanitiesClassroom", 34.071528, -118.441211);
        
        GeoPosition john = new Student("john", 34.069149, -118.442639 ); //engineering
        GeoPosition jane = new Student("jane", 34.069601, -118.441862);  //geology
        GeoPosition pam = new Student("pam", 34.071513, -118.441181);    //humanities
        
        double sameDistane = Utils.getDistance(engineeringClassroom, engineeringClassroom);
        assertEquals(0.0, sameDistane, 0.0);
        
        double differentDistance = Utils.getDistance(engineeringClassroom, geologyClassroom);
        assertNotEquals(0.0, differentDistance, 0.0);
        
        double smallDistance = Utils.getDistance(engineeringClassroom, john);
        assertTrue(15 > smallDistance);
        
        smallDistance = Utils.getDistance(geologyClassroom, jane);
        assertTrue(15 > smallDistance);
        
        smallDistance = Utils.getDistance(humanitiesClassroom, pam);
        assertTrue(15 > smallDistance);
        
        double bigDistance = Utils.getDistance(psychologyClassroom, john);
        assertTrue(15 < bigDistance);
        
        bigDistance = Utils.getDistance(musicClassroom, jane);
        assertTrue(15 < bigDistance);
        
        bigDistance = Utils.getDistance(engineeringClassroom, pam);
        assertTrue(15 < bigDistance);
    }
    
}
