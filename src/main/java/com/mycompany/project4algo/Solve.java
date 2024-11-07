package com.mycompany.project4algo;
import java.util.*;

public class Solve {
    // HashMap<State, State> 
    public static int bfs(State initialState, HashMap<String, Vehicle> vehicles) {
        Queue<State> queue = new LinkedList<>();
        HashMap<String, String> visted = new HashMap<>();
        queue.add(initialState);

        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            String board = currentState.getBoard();
            if (done(board)) {
                return currentState.getMoves();
            }
            for(Vehicle v : vehicles.values()){
                String orientation = v.getOrientation();
                int row = v.getRow();
                int col = v.getCol();
                int length = v.getLength();
                String key = v.getKey();
                String newBoard;
                int start = col + 6*row;
                int end = start + length - 1;
                int y = row;
                int moves = currentState.getMoves() + 1;

                //remove car from board
                newBoard = board.substring(0);
                if(orientation.equals("h") && length == 2){
                    if(end <= 35)
                        newBoard = board.substring(0, start) + "--" + board.substring(end + 1);
                    else
                        newBoard = board.substring(0, start) + "--";
                }
                else if(orientation.equals("h") && length == 3){
                    if(end <= 35)
                        newBoard = board.substring(0, start) + "---" + board.substring(end + 1);
                    else
                        newBoard = board.substring(0, start) + "---";
                }
                else if(orientation.equals("v")){
                    for(int a = 0; a < length; a++){
                        start = col + 6*y;
                        if(start <= 35)
                            newBoard = newBoard.substring(0, start) + "-" + board.substring(start + 1);
                        else
                            newBoard = newBoard.substring(0, start) + "-";
                        y++;
                    }
                }

                //if vehicle is horizontal
                if(orientation.equals("h")){
                    int j = col - 1;
                    //check spots to the left
                    while(j >= 0){
                        int index = j + 6*row;
                        //check for another vehicle
                        if(!board.substring(index, index).equals("-")){
                            break;
                        }
                        String result = addhVehicle(newBoard,index, length, key);
                        if(!duplicate(result, initialState, visted)){
                            visted.put(result, board);
                            queue.add(new State(result, moves));
                        }
                        j--;
                    }

                    //check spots to the right
                    j = col + length;
                    while(j <= 5){
                        int index = j + 6*row;
                        //check for another vehicle
                        if(!board.substring(index, index).equals("-")){
                            break;
                        }
                        String result = addhVehicle(newBoard, index - length + 1, length, key);
                        if(!duplicate(result, initialState, visted)){
                            visted.put(result, board);
                            queue.add(new State(result, moves));
                        }
                        j++;
                    }
                }
                //if vehicle if vertical
                else{
                    int i = row - 1;
                    //check spots to the top
                    while(i >= 0){
                        int index = col + 6*i;
                        //check for another vehicle
                        if(!board.substring(index, index).equals("-")){
                            break;
                        }
                        String result = addvVehicle(newBoard, index, length, key);
                        if(!duplicate(result, initialState, visted)){
                            visted.put(result, board);
                            queue.add(new State(result, moves));
                        }
                        i--;
                    }
                    //check spots to the bottom
                    i = row + length;
                    while(i <= 5){
                        int index = col + 6*i;
                        //check for another vehicle
                        if(!board.substring(index, index).equals("-")){
                            break;
                        }
                        String result = addhVehicle(newBoard, index - 6*(length - 1), length, key);
                        //check if duplicate has already been created
                        if(!duplicate(result, initialState, visted)){
                            visted.put(result, board);
                            queue.add(new State(result, moves));
                        }
                        i++;
                    }

                }
                
            }
        }

        // enqueue initial state
        // dequeue
        // check if red car at goal
        // if not: try all possible moves for each vehicle and add new states to queue
        // if yes: break and return moves
        return 0;
    }

    private static boolean done(String board) {
        if(board.substring(10,12).equals("00")){
            return true;
        }
        return false;
    }

    private static String addhVehicle(String board, int index, int length, String key){
        String temp = board.substring(0);
        int end;
        if(length == 2){
            end = index + 1;
            if(end <= 35)
                temp = temp.substring(0, index) + key + key + temp.substring(end + 1);
            else
                temp = temp.substring(0, index) + key + key;
        }
        else{
            end = index + 2;
            if(end <= 35)
                temp = temp.substring(0, index) + key + key + key + temp.substring(end + 1);
            else
                temp = temp.substring(0, index) + key + key + key;
        }

        return temp;
    }

    private static String addvVehicle(String board, int index, int length, String key){
        String temp = board.substring(0);
        for(int j = 0; j < length; j++){
            if(index <= 35)
                temp = temp.substring(0, index) + key + temp.substring(index + 1);
            else
                temp = temp.substring(0, index) + key;
            index += 6;
        }

        return temp;
    }

    private static boolean duplicate(String board, State initialState, HashMap<String, String> visted){
        String dup = visted.get(board);

        if(dup == null && !board.equals(initialState.getBoard())){
            return false;
        }
        return true;
    }
}
