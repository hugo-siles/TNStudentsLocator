/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.studentlocator;

import com.thinknear.studentlocator.model.BoxCoordinates;
import com.thinknear.studentlocator.model.StudentFoundList;
import com.thinknear.studentlocator.model.ClassroomList;
import com.thinknear.studentlocator.model.SquareClassroom;
import com.thinknear.studentlocator.model.Student;
import com.thinknear.studentlocator.model.StudentList;
import com.thinknear.studentlocator.utils.Utils;
/**
 *
 * @author hugo.siles
 */
public class StudentLocator {   
    
    public StudentFoundList studentsInClasses(StudentList completeStudentslist, 
            ClassroomList completeRoomsList) {
        
        StudentFoundList result = new StudentFoundList();
        
        for (SquareClassroom room : completeRoomsList.getListOfObjects()){
            
            for (Student aStudent : completeStudentslist.getListOfObjects()){
                
                double distance = Utils.getDistance(room, aStudent);
                if (distance < room.getDistanceToSide()) {
                    result.addObject(aStudent); //100% percent certaint
                } else {
                    //depends on the precision of the box coordinates
                    BoxCoordinates cornersCoords = room.getCornersCoordinates(); 
                    if (Utils.isPointInsideBox(cornersCoords, aStudent)) {
                        result.addObject(aStudent);
                    }
                }

            }            
        }       
        
        return result;
    }
    
    

}
