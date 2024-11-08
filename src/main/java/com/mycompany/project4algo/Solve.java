package com.mycompany.project4algo;
import java.util.*;

/**
 * This class implements the breadth first search algorithm and prints the move string.
 *
 * @author Roni Ebenezer, Jonique Chan
 * @version 1.0
 * File: Solve.java
 * Created: Nov 2024
 * ©Copyright Cedarville University, its Computer Science faculty, 
 * and the authors. All rights reserved.
 *
 * Description: This class contains the method for implementing the breadth first search algorithm.
 * It contains the main bfs method that loops through a queue and adds new states until it reaches the
 * goal state where the red car is at the exit. It has two helper methods: getPossibleMoves to find different states for a given 
 * vehicle and addVehicle to add a given vehicle into the board. It also has two helper methods to keep track of and
 * generate a move string by calculating the difference between the initial board and the board that contains the correct move. 
 */

public class Solve { 

    // hashset to keep track of visited states
    public static HashSet<String> visited = new HashSet<>();
    
    // breadth-first search algorithm
    public static int bfs(State initialState, HashMap<String, Vehicle> vehicles) {
        // create queue
        Queue<State> queue = new LinkedList<>();
        String initialBoard = initialState.getBoard();
        queue.add(initialState);
        visited.add(initialState.getBoard());

        while (!queue.isEmpty()) {
            // dequeue
            State currentState = queue.poll();
            String board = currentState.getBoard();

            // check if red car is at goal
            if (done(board)) {
                // print moves
                currentState.getMovesList().forEach(System.out::println);
                return currentState.getMoves();
            }

            // try all possible moves for each vehicle
            for (Vehicle v : vehicles.values()) {
                for (String newBoard : getPossibleMoves(board, v)) {
                    if (!visited.contains(newBoard)) {
                        
                        // create list to keep track of moves
                        List<String> updatedMovesList = new ArrayList<>(currentState.getMovesList());
                        String move = moveString(v, initialBoard, newBoard);
                        updatedMovesList.add(move);

                        // add state to hahset
                        visited.add(newBoard);

                        // add new state to queue
                        queue.add(new State(newBoard, currentState.getMoves() + 1, updatedMovesList));
                    }
                }
            }
        }
        // no solution found
        return -1;
    }

    // boolean method to check if red car is at goal
    private static boolean done(String board) {
        StringBuilder goalBoard = new StringBuilder(board);
        if (goalBoard.charAt(17) == 'a') {
            return true;
        }
        return false;
    }

    // method that gets a list of possible moves for a given vehicle
    private static List<String> getPossibleMoves(String board, Vehicle vehicle) {
        List<String> moves = new ArrayList<>();
        int row = vehicle.getRow();
        int col = vehicle.getCol();
        String orientation = vehicle.getOrientation();
        int length = vehicle.getLength();
        String key = vehicle.getKey();
        int index = -1;

        // remove vehicle
        StringBuilder newBoard = new StringBuilder(board);

        for (int i = 0; i < newBoard.length(); i++) {
            if (newBoard.charAt(i) == key.charAt(0)) {
                newBoard.setCharAt(i, '-');
                index = i;
            }
        }

        String clearedBoard = newBoard.toString();
        if (orientation.equals("h")) {
            index = index - length + 1;
        }
        else {
            index = index - 6 * (length - 1);
        }

        row = index / 6;
        col = index % 6;

        // if vehicle is horizontal
        if (orientation.equals("h")) {
            // move left
            int left = col - 1;
            // check bounds + if theres a vehicle
            while (left >= 0 && clearedBoard.charAt(row * 6 + left) == '-') {
                index = left + 6 * row;
                moves.add(addVehicle(clearedBoard, index, length, key, true));
                left--;
            }
            // move right
            int right = col + length;
            while (right < 6 && clearedBoard.charAt(row * 6 + right) == '-') {
                index = right + 6 * row;
                moves.add(addVehicle(clearedBoard, index - length + 1, length, key, true));
                right++;
            }
        } 
        // if vehicle is vertical
        else {
            // move up
            int up = row - 1;
            while (up >= 0 && clearedBoard.charAt(up * 6 + col) == '-') {
                index = col + 6 * up;
                moves.add(addVehicle(clearedBoard, index, length, key, false));
                up--;
            }
            // move down
            int down = row + length;
            while (down < 6 && clearedBoard.charAt(down * 6 + col) == '-') {
                index = col + 6 * down;
                moves.add(addVehicle(clearedBoard, index - 6 * (length - 1), length, key, false));
                down++;
            }
        }

        return moves;
    }

    // method to add a vehicle to the board
    private static String addVehicle(String board, int startIdx, int length, String key, boolean isHorizontal) {
        StringBuilder newBoard = new StringBuilder(board);
        
        for (int i = 0; i < length; i++) {
            int end;
            if (isHorizontal) {
                end = startIdx + i;
            }
            else {
                end = startIdx + i * 6;
            }
            newBoard.setCharAt(end, key.charAt(0));
        }
        return newBoard.toString();
    }

    // method to generate move string to represent vehicle movement
    private static String moveString(Vehicle v, String oldBoard, String newBoard) {
        // calculate old and new positions and find difference
        int oldPos = v.getRow() * 6 + v.getCol();
        int newPos = newBoard.indexOf(v.getKey().charAt(0));  
        int diff = calculateMovementDiff(oldPos, newPos, v.getOrientation());

        // find direction
        String direction = "";
        if (v.getOrientation().equals("h")) {
            if (diff > 0) {
                direction = "R";
            } 
            else {
                direction = "L";
            }
        } 
        else {
            if (diff > 0) {
                direction = "D";
            } 
            else {
                direction = "U";
            }
        }
        
        String result = v.getColor() + " " + Math.abs(diff) + " " + direction;
        return result;
    }
    
    // method to calculate difference based on vehicle orientation
    private static int calculateMovementDiff(int oldPos, int newPos, String orientation) {
        if (orientation.equals("h")) {
            // horizontal diff
            int hdiff = newPos % 6 - oldPos % 6;
            return hdiff;
        } 
        else {
            // vertical diff
            int vdiff = (newPos / 6) - (oldPos / 6);
            return vdiff;
        }
    }
}
