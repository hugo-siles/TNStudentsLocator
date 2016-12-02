/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinknear.studentlocator.model;

import java.util.Objects;

/**
 *
 * @author hugo.siles
 */
public class Student extends GeoPosition{
    
    private final String name;

    public Student(String name, double latitude, double longitude) {
        super(latitude, longitude);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Student other = (Student) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }

        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "{'latitude': " + getLatitude() + ", 'name': '" + name + "', 'longitude': " + getLongitude() + "}";
    }
        
}
