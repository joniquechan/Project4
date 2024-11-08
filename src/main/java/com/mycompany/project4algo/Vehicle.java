package com.mycompany.project4algo;

/**
 * This class is for the Vehicle object. 
 *
 * @author Roni Ebenezer, Jonique Chan
 * @version 1.0
 * File: Vehicle.java
 * Created: Nov 2024
 * ©Copyright Cedarville University, its Computer Science faculty, 
 * and the authors. All rights reserved.
 *
 * Description: This class is for the Vehicle object where it contains a constructor to initialize a vehicle given the information from the input.
 * It also contains getters for each corresponding information. 
 */

public class Vehicle {
    public String type;
    public String orientation;
    public String color;
    int row, col, length;
    String key;

    // constructor
    public Vehicle(String t, String o, String c, int r, int co, int l, String k) {
        type = t;
        orientation = o;
        color = c;
        row = r;
        col = co;
        length = l;
        key = k;
    }

    // method to get type
    public String getType() {
        return type;
    }

    // method to get orientation
    public String getOrientation() {
        return orientation;
    }

    // method to get row
    public int getRow(){
        return row;
    }

    // method to get col
    public int getCol(){
        return col;
    }

    // method to get length
    public int getLength(){
        return length;
    }

    // method to get color
    public String getColor() {
        return color;
    }

    // method to get key
    public String getKey() {
        return key;
    }
}
