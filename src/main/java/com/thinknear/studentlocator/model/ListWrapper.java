/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.studentlocator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hugo.siles
 * @param <T>
 */
public abstract class ListWrapper<T> {
    
    private final List<T> listOfObjects;

    public ListWrapper() {
        this.listOfObjects = new ArrayList<>();
    }

    public ListWrapper(List<T> listOfObjects) {
        this.listOfObjects = listOfObjects;
    }    
       
    public int count(){
        return listOfObjects.size();
    }

    public List<T> getListOfObjects() {
        return Collections.unmodifiableList(listOfObjects);
    }
    
    public void addObject(T room){
        
        if (listOfObjects.contains(room)){
            return;
        }
        
        listOfObjects.add(room);        
    }
    
    public boolean removeObject(T room){
        return listOfObjects.remove(room);
    }
    
}
