package com.mycompany.project4algo;

public class Vehicle {
    public String type;
    public String orientation;
    public String color;
    int row, col, length;

    public Vehicle(String t, String o, String c, int r, int co, int l) {
        type = t;
        orientation = o;
        color = c;
        row = r;
        col = co;
        length = l;
    }

    public String getType() {
        return type;
    }

    public String getOrientation() {
        return orientation;
    }

    public String getColor() {
        return color;
    }
}
