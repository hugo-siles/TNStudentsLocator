/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.tnstudentlocator.logic;

import com.thinknear.tnstudentlocator.Utils.Utils;
import com.thinknear.tnstudentlocator.model.*;
/**
 *
 * @author hugo.siles
 */
public class StudentLocator {   
    
    public StudentFoundList studentsInClasses(StudentList completeStudentslist, 
            ClassroomList completeRoomsList) {
        
        StudentFoundList result = new StudentFoundList();
        
        for (SquareClassroom room : completeRoomsList.getListOfClassrooms()){
            
            for (Student aStudent : completeStudentslist.getListOfStudents()){
                
                double distance = Utils.getDistance(room, aStudent);
                if (distance < room.getDistanceToSide()) {
                    result.addStudent(aStudent); //100% percent certaint
                    
                } else if (distance < room.getDistanceToCorner()) {
                    result.addStudent(aStudent); //Quite probably inside the room
                } else {
                    // compute corners of the room
                    // check if student is inside those corners
                }
            }            
        }       
        
        return result;
    }
    
    

}
