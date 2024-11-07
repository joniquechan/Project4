package com.mycompany.project4algo;

public class Vehicle {
    public String type;
    public String orientation;
    public String color;
    int row, col, length;
    String key;

    public Vehicle(String t, String o, String c, int r, int co, int l, String k) {
        type = t;
        orientation = o;
        color = c;
        row = r;
        col = co;
        length = l;
        key = k;
    }

    public String getType() {
        return type;
    }

    public String getOrientation() {
        return orientation;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public int getLength(){
        return length;
    }

    public String getColor() {
        return color;
    }

    public String getKey() {
        return key;
    }
}
