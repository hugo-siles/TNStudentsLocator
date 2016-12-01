/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.tnstudentlocator.logic;

import com.thinknear.tnstudentlocator.model.ClassroomList;
import com.thinknear.tnstudentlocator.model.GeoObject;
import com.thinknear.tnstudentlocator.model.SquareClassroom;
import com.thinknear.tnstudentlocator.model.Student;
import com.thinknear.tnstudentlocator.model.StudentFoundList;
import com.thinknear.tnstudentlocator.model.StudentList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hugo.siles
 */
public class StudentLocatorTest {
    
    public StudentLocatorTest() {
    }
    

    @Test
    public void testStudentsInClasses_checkForStudentsCloseToCenter() {
        System.out.println("studentsInClasses");
        
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
        
        assertEquals(3, studentsFound.count());
        assertEquals(john, studentsFound.getListOfStudentsFound().get(0));
        assertEquals(jane, studentsFound.getListOfStudentsFound().get(1));
        assertEquals(pam, studentsFound.getListOfStudentsFound().get(2));
        
        System.out.println(studentsFound.toString());
       
    }
    
    @Test
    public void testStudentsInClasses_checkForStudentsNotInRooms() {
        System.out.println("testStudentsInClasses_checkForStudentsNotInRooms");
        
        GeoObject engineeringClassroom = new SquareClassroom("engineeringClassroom", 34.069140, -118.442689);
        GeoObject geologyClassroom = new SquareClassroom("geologyClassroom", 34.069585, -118.441878);
        GeoObject psychologyClassroom = new SquareClassroom("psychologyClassroom", 34.069742, -118.441312);
        GeoObject musicClassroom = new SquareClassroom("musicClassroom", 34.070223, -118.440193);
        GeoObject humanitiesClassroom = new SquareClassroom("humanitiesClassroom", 34.071528, -118.441211);
        
        GeoObject john = new Student("john", 34.069849, -118.443539 ); //engineering
        GeoObject jane = new Student("jane", 34.069901, -118.441562);  //geology
        GeoObject pam = new Student("pam", 34.071523, -118.441171);    //humanities
              
        StudentList allStudents = new StudentList();
        allStudents.addStudent((Student) john);
        allStudents.addStudent((Student) jane);
        allStudents.addStudent((Student) pam);
        
        ClassroomList allRooms = new ClassroomList();
        allRooms.addClassroom((SquareClassroom) geologyClassroom);
        allRooms.addClassroom((SquareClassroom) psychologyClassroom);
        allRooms.addClassroom((SquareClassroom) musicClassroom);
        allRooms.addClassroom((SquareClassroom) humanitiesClassroom);
        allRooms.addClassroom((SquareClassroom) engineeringClassroom);
        
        StudentLocator locator = new StudentLocator();
        StudentFoundList studentsFound = locator.studentsInClasses(allStudents, allRooms);
        
        assertEquals(1, studentsFound.count());
        assertEquals(pam, studentsFound.getListOfStudentsFound().get(0));
        
        System.out.println(studentsFound.toString());
       
    }
    
}
