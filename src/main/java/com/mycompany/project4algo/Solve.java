package com.mycompany.project4algo;
import java.util.*;

// second draft
public class Solve { 

    // changed to hashset bc it just checks existence of state
    public static HashSet<String> visited = new HashSet<>();
    
    public static int bfs(State initialState, HashMap<String, Vehicle> vehicles) {
        Queue<State> queue = new LinkedList<>();
        
        queue.add(initialState);
        visited.add(initialState.getBoard());
        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            String board = currentState.getBoard();
            if (done(board)) {
                // for tracking - needs fixing
                currentState.getMovesList().forEach(System.out::println);
                return currentState.getMoves();
            }

            for (Vehicle v : vehicles.values()) {
                for (String newBoard : getPossibleMoves(board, v)) {
                    if (!visited.contains(newBoard)) {
                        visited.add(newBoard);
                        queue.add(new State(newBoard, currentState.getMoves() + 1));
                    }
                }
            }
        }
        // no solution found
        return -1;
    }

    // wheres the end?? <- FIXED jk not really
    private static boolean done(String board) {
        StringBuilder goalBoard = new StringBuilder(board);
        if (goalBoard.charAt(17) == 'a') {
            return true;
        }
        return false;
    }

    private static List<String> getPossibleMoves(String board, Vehicle vehicle) {
        List<String> moves = new ArrayList<>();
        int row = vehicle.getRow();
        int col = vehicle.getCol();
        String orientation = vehicle.getOrientation();
        int length = vehicle.getLength();
        String key = vehicle.getKey();
        int index = -1;

        // remove car
        StringBuilder newBoard = new StringBuilder(board);

        for (int i = 0; i < newBoard.length(); i++) {
            if (newBoard.charAt(i) == key.charAt(0)) {
                newBoard.setCharAt(i, '-');
                index = i;
            }
        }
        String clearedBoard = newBoard.toString();
        if(orientation.equals("h")){
            index = index - length + 1;
        }
        else{
            index = index - 6*(length - 1);
        }
        row = index/6;
        col = index%6;

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
}
