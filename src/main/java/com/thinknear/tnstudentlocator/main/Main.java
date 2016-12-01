/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.tnstudentlocator.main;

import com.thinknear.tnstudentlocator.logic.StudentLocator;
import com.thinknear.tnstudentlocator.model.ClassroomList;
import com.thinknear.tnstudentlocator.model.GeoObject;
import com.thinknear.tnstudentlocator.model.SquareClassroom;
import com.thinknear.tnstudentlocator.model.Student;
import com.thinknear.tnstudentlocator.model.StudentFoundList;
import com.thinknear.tnstudentlocator.model.StudentList;

/**
 *
 * @author hugo.siles
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GeoObject engineeringClassroom = new SquareClassroom("engineeringClassroom", 34.069140, -118.442689);
        GeoObject geologyClassroom = new SquareClassroom("geologyClassroom", 34.069585, -118.441878);
        GeoObject psychologyClassroom = new SquareClassroom("psychologyClassroom", 34.069742, -118.441312);
        GeoObject musicClassroom = new SquareClassroom("musicClassroom", 34.070223, -118.440193);
        GeoObject humanitiesClassroom = new SquareClassroom("humanitiesClassroom", 34.071528, -118.441211);
        
        GeoObject john = new Student("john", 34.069149, -118.442639 ); //engineering
        GeoObject jane = new Student("jane", 34.069601, -118.441862);  //geology
        GeoObject pam = new Student("pam", 34.071513, -118.441181);    //humanities
        
        StudentList allStudents = new StudentList();
        allStudents.addStudent((Student) john);
        allStudents.addStudent((Student) jane);
        allStudents.addStudent((Student) pam);
        
        ClassroomList allRooms = new ClassroomList();
        allRooms.addClassroom((SquareClassroom) engineeringClassroom);
        allRooms.addClassroom((SquareClassroom) geologyClassroom);
        allRooms.addClassroom((SquareClassroom) psychologyClassroom);
        allRooms.addClassroom((SquareClassroom) musicClassroom);
        allRooms.addClassroom((SquareClassroom) humanitiesClassroom);
        
        StudentLocator locator = new StudentLocator();
        StudentFoundList studentsFound = locator.studentsInClasses(allStudents, allRooms);
        
        System.out.println(studentsFound.toString());
        
        
        john = new Student("john", 34.069849, -118.443539 ); //engineering
        jane = new Student("jane", 34.069901, -118.441562);  //geology
        pam = new Student("pam", 34.071523, -118.441171);    //humanities
              
        allStudents = new StudentList();
        allStudents.addStudent((Student) john);
        allStudents.addStudent((Student) jane);
        allStudents.addStudent((Student) pam);
        
        allRooms = new ClassroomList();
        allRooms.addClassroom((SquareClassroom) geologyClassroom);
        allRooms.addClassroom((SquareClassroom) psychologyClassroom);
        allRooms.addClassroom((SquareClassroom) musicClassroom);
        allRooms.addClassroom((SquareClassroom) humanitiesClassroom);
        allRooms.addClassroom((SquareClassroom) engineeringClassroom);
        
        locator = new StudentLocator();
        studentsFound = locator.studentsInClasses(allStudents, allRooms);
        
        System.out.println(studentsFound.toString());
        
        
    }
    
}
