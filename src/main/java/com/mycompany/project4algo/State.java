package com.mycompany.project4algo;
import java.util.*;

public class State {
    public int numStates;
    public String boardState;
    public int numMoves;

    public State(String board) {
        boardState = board;
    }

    
    public State move(Vehicle v, int dir) {
        // move vehicle  
        String newState = new String(this.boardState);
        int newRow = v.row; 
        int newCol = v.col;

        if (v.orientation == "h") {
            newRow += v.row;
        }
        if (v.orientation == "v") {
            newCol += v.col;
        }
    }

    // FIX
    public boolean isValid(Vehicle v, int r, int c, State s) {
         

        return true;
    }

    public int getMoves() {
        return numMoves;
    }
}
