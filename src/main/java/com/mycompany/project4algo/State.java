package com.mycompany.project4algo;
import java.util.*;

/**
 * This class is for the State object. 
 *
 * @author Roni Ebenezer, Jonique Chan
 * @version 1.0
 * File: State.java
 * Created: Nov 2024
 * ©Copyright Cedarville University, its Computer Science faculty, 
 * and the authors. All rights reserved.
 *
 * Description: This class is for the State object where it contains two constructors to initializes
 * a State given a board. It contains getters for its board and moves as well as a helper function
 * to keep track of the list of moves for printing later.
 */

public class State {
    public String boardState;
    public int numMoves;
    public List<String> movesList;
    
    // initial constructor 
    public State(String board) {
        boardState = board;
        numMoves = 0;
        movesList = new ArrayList<>();
    }
    
    // constructor to keep track of moves
    public State(String board, int moves, List<String> previousMoves){
        boardState = board;
        numMoves = moves;
        movesList = new ArrayList<>(previousMoves);
    }

    // method to get moves
    public int getMoves() {
        return numMoves;
    }

    // method to add moves to the lsit of moves
    public void addMove(String move) {
        movesList.add(move);
    }

    // method to get list of moves
    public List<String> getMovesList() {
        return movesList;
    }

    // method to get the state of a board as a string
    public String getBoard(){
        return boardState;
    }
}
