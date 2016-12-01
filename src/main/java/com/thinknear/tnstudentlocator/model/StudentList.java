/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.tnstudentlocator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hugo.siles
 */
public class StudentList {
    
    private final List<Student> listOfStudents;

    public StudentList() {
        this.listOfStudents = new ArrayList<>();
    }
    
    public int count(){
        return listOfStudents.size();
    }

    public List<Student> getListOfStudents() {
        return Collections.unmodifiableList(listOfStudents);
    }
    
    public void addStudent(Student aStudent){
        
        if (listOfStudents.contains(aStudent)){
            return;
        }
        
        listOfStudents.add(aStudent);        
    }
    
    public boolean removeStudent(Student aStudent){
        return listOfStudents.remove(aStudent);
    }
}
