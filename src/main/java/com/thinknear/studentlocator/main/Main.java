/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.studentlocator.main;

import com.thinknear.studentlocator.StudentLocator;
import com.thinknear.studentlocator.model.ClassroomList;
import com.thinknear.studentlocator.model.SquareClassroom;
import com.thinknear.studentlocator.model.Student;
import com.thinknear.studentlocator.model.StudentFoundList;
import com.thinknear.studentlocator.model.StudentList;
import java.util.Arrays;

/**
 *
 * @author hugo.siles
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SquareClassroom engineeringClassroom = new SquareClassroom("engineeringClassroom", 34.069140, -118.442689);
        SquareClassroom geologyClassroom = new SquareClassroom("geologyClassroom", 34.069585, -118.441878);
        SquareClassroom psychologyClassroom = new SquareClassroom("psychologyClassroom", 34.069742, -118.441312);
        SquareClassroom musicClassroom = new SquareClassroom("musicClassroom", 34.070223, -118.440193);
        SquareClassroom humanitiesClassroom = new SquareClassroom("humanitiesClassroom", 34.071528, -118.441211);
        
        ClassroomList allRooms = new ClassroomList(Arrays.asList(engineeringClassroom, geologyClassroom, 
                psychologyClassroom, musicClassroom, humanitiesClassroom));
        
        Student john = new Student("john", 34.069149, -118.442639 ); //engineering
        Student jane = new Student("jane", 34.069601, -118.441862);  //geology
        Student pam = new Student("pam", 34.071513, -118.441181);    //humanities
        
        StudentList allStudents = new StudentList(Arrays.asList(john, jane, pam));
        
        StudentLocator locator = new StudentLocator();
        StudentFoundList studentsFound = locator.studentsInClasses(allStudents, allRooms);
        
        System.out.println(studentsFound.toString());
        
        
        john = new Student("john", 34.069849, -118.443539 ); //engineering
        jane = new Student("jane", 34.069901, -118.441562);  //geology
        pam = new Student("pam", 34.071523, -118.441171);    //humanities
              
        allStudents = new StudentList(Arrays.asList(john, jane, pam));
        
        allRooms = new ClassroomList();
        allRooms.addObject((SquareClassroom) geologyClassroom);
        allRooms.addObject((SquareClassroom) psychologyClassroom);
        allRooms.addObject((SquareClassroom) musicClassroom);
        allRooms.addObject((SquareClassroom) humanitiesClassroom);
        allRooms.addObject((SquareClassroom) engineeringClassroom);
        
        locator = new StudentLocator();
        studentsFound = locator.studentsInClasses(allStudents, allRooms);
        
        System.out.println(studentsFound.toString());
    }
    
}
