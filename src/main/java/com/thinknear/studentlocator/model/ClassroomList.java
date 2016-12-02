/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.studentlocator.model;

import java.util.List;

/**
 *
 * @author hugo.siles
 */
public class ClassroomList extends ListWrapper<SquareClassroom> {

    public ClassroomList() {
    }

    public ClassroomList(List<SquareClassroom> listOfObjects) {
        super(listOfObjects);
    }
       
    @Override
    public String toString() {
        return "ClassroomList{" + "listOfClassRooms=" + getListOfObjects() + '}';
    }
   
}
