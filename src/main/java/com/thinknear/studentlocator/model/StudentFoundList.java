/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.studentlocator.model;

/**
 *
 * @author hugo.siles
 */
public class StudentFoundList extends ListWrapper<Student>{
    
    
    @Override
    public String toString() {
        return "StudentFoundList{" + "listOfStudentsFound=" + getListOfObjects() + '}';
    }
    
    
}
