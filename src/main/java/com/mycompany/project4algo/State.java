package com.mycompany.project4algo;
import java.util.*;

public class State {
    public int numStates;
    List<String> moves;
    public HashMap<String, Vehicle> vehicles;

    // initialize string (36 chars)
    // store each state as a new board string

    // store map of vehicles + position
    public State(HashMap<String, Vehicle> v) {
        vehicles = v;
    }

    // FIX
    public void initializeBoard(Vehicle v) {
        
    }

    // FIX
    /*public State move(Vehicle v, int dir) {
        // move vehicle   
    }*/

    // FIX
    public boolean isValid(Vehicle v, int r, int c, State s) {
        // check if move is valid 
        return true;
    }

    public boolean goalState() {
        Vehicle redCar = vehicles.get("0");
        return redCar.col == 5 && redCar.row == 3;
    }
}
