package com.mycompany.project4algo;

import java.util.*;

public class State {
    public String boardState;
    public int numMoves;
    // for print: needs implementation
    public List<String> movesList;

    public State(String board) {
        boardState = board;
        numMoves = 0;
        movesList = new ArrayList<>();
    }

    public State(String board, int moves){
        boardState = board;
        numMoves = moves;
        this.movesList = new ArrayList<>();
    }

    /*
    public State(String board, int moves, List<String> previousMoves){
        boardState = board;
        numMoves = moves;
        movesList = new ArrayList<>(previousMoves);
    }
        */

    public int getMoves() {
        return numMoves;
    }

    public void addMove(String move) {
        movesList.add(move);
    }

    public List<String> getMovesList() {
        return movesList;
    }

    public String getBoard(){
        return boardState;
    }
}
