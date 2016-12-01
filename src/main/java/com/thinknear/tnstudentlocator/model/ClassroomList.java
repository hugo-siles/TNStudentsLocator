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
public class ClassroomList {
    
    private final List<SquareClassroom> listOfClassrooms;

    public ClassroomList() {
        this.listOfClassrooms = new ArrayList<>();
    }
    
    public int count(){
        return listOfClassrooms.size();
    }

    public List<SquareClassroom> getListOfClassrooms() {
        return Collections.unmodifiableList(listOfClassrooms);
    }
    
    public void addClassroom(SquareClassroom room){
        
        if (listOfClassrooms.contains(room)){
            return;
        }
        
        listOfClassrooms.add(room);        
    }
    
    public boolean removeClassroom(SquareClassroom room){
        return listOfClassrooms.remove(room);
    }
}
