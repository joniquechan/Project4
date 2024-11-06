package com.mycompany.project4algo;
import java.util.*;

public class State {
    public int numStates;
    public int boardSize = 6;
    List<String> moves;
    public Map<String, Vehicle> vehicles;

    // FIX
    public State(Map<String, Vehicle> v) {
        vehicles = v;
    }

    // FIX
    public void initializeBoard(Vehicle v) {

    }

    // FIX
    public State move(Vehicle v, int dir) {
        // move vehicle        
    }

    // FIX
    public boolean isValid(Vehicle v, int r, int c, State s) {
        // check if move is valid 
        return true;
    }

    public boolean goalState() {
        Vehicle redCar = vehicles.get("red");
        return redCar.col == 5 && redCar.row == 3;
    }
}
