/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.studentlocator;

import com.thinknear.studentlocator.model.ClassroomList;
import com.thinknear.studentlocator.model.SquareClassroom;
import com.thinknear.studentlocator.model.Student;
import com.thinknear.studentlocator.model.StudentFoundList;
import com.thinknear.studentlocator.model.StudentList;
import java.util.Arrays;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author hugo.siles
 */
public class StudentLocatorTest {
    
    private ClassroomList allRooms;
    
    public StudentLocatorTest() {
    }

    @Before
    public void setUp() throws Exception {
        
        SquareClassroom engineeringClassroom = new SquareClassroom("engineeringClassroom", 34.069140, -118.442689);
        SquareClassroom geologyClassroom = new SquareClassroom("geologyClassroom", 34.069585, -118.441878);
        SquareClassroom psychologyClassroom = new SquareClassroom("psychologyClassroom", 34.069742, -118.441312);
        SquareClassroom musicClassroom = new SquareClassroom("musicClassroom", 34.070223, -118.440193);
        SquareClassroom humanitiesClassroom = new SquareClassroom("humanitiesClassroom", 34.071528, -118.441211);
        
        allRooms = new ClassroomList(Arrays.asList(engineeringClassroom, geologyClassroom, 
                psychologyClassroom, musicClassroom, humanitiesClassroom));
    }

    @After
    public void tearDown() throws Exception {
    }
    

    @Test
    public void testStudentsInClasses_checkForStudentsCloseToCenter() {
        System.out.println("studentsInClasses");
        
        Student john = new Student("john", 34.069149, -118.442639 ); //engineering
        Student jane = new Student("jane", 34.069601, -118.441862);  //geology
        Student pam = new Student("pam", 34.071513, -118.441181);    //humanities
        
        StudentList allStudents = new StudentList(Arrays.asList(john, jane, pam));
        
        StudentLocator locator = new StudentLocator();
        StudentFoundList studentsFound = locator.studentsInClasses(allStudents, allRooms);
        
        assertEquals(3, studentsFound.count());
        assertEquals(john, studentsFound.getListOfObjects().get(0));
        assertEquals(jane, studentsFound.getListOfObjects().get(1));
        assertEquals(pam, studentsFound.getListOfObjects().get(2));
        
        System.out.println(studentsFound.toString());
       
    }
    
    @Test
    public void testStudentsInClasses_checkForStudentsNotInRooms() {
        System.out.println("testStudentsInClasses_checkForStudentsNotInRooms");
         
        Student john = new Student("john", 34.069849, -118.443539 ); //engineering
        Student jane = new Student("jane", 34.069901, -118.441562);  //geology
        Student pam = new Student("pam", 34.071523, -118.441171);    //humanities
              
        StudentList allStudents = new StudentList(Arrays.asList(john, jane, pam));
        
        StudentLocator locator = new StudentLocator();
        StudentFoundList studentsFound = locator.studentsInClasses(allStudents, allRooms);
        
        assertEquals(1, studentsFound.count());
        assertEquals(pam, studentsFound.getListOfObjects().get(0));
        
        System.out.println(studentsFound.toString());
       
    }
}
