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
public class StudentFoundList {
    
    private final List<Student> listOfStudentsFound;

    public StudentFoundList() {
        this.listOfStudentsFound = new ArrayList<>();
    }
    
    public int count(){
        return listOfStudentsFound.size();
    }

    public List<Student> getListOfStudentsFound() {
        return Collections.unmodifiableList(listOfStudentsFound);
    }   
    
    
    public void addStudent(Student aStudent){
        
        if (listOfStudentsFound.contains(aStudent)){
            return;
        }
        
        listOfStudentsFound.add(aStudent);        
    }
    
    public boolean removeStudent(Student aStudent){
        return listOfStudentsFound.remove(aStudent);
    }

    @Override
    public String toString() {
        return "StudentFoundList{" + "listOfStudentsFound=" + listOfStudentsFound + '}';
    }
    
    
}
