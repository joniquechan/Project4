/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project4algo;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author User
 */
public class Project4Algo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.println("input: ");

        // key - color, value - vehicle
        HashMap<String, Vehicle> vehicles = new HashMap<>();
        String board = "------------------------------------";
        HashMap<String, String> colors = new HashMap<>();
        
        int numVehicles = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numVehicles; i++) {
            String type = sc.nextLine();
            String color = sc.nextLine();
            String orientation = sc.nextLine();
            int row = sc.nextInt();
            int col = sc.nextInt();
            sc.nextLine();
            int length = 2;
            if (!type.equals("car")) {
                length = 3;
            }
            String key = Integer.toString(i);
            Vehicle v = new Vehicle(type, orientation, color, row, col, length, key);
            vehicles.put(key, v);

            row--;
            col--;
            int start = col + 6*row;
            String temp;
            if(orientation.equals("h") && length == 2){
                int end = start + 1;
                if(end <= 35)
                    temp = board.substring(0, start) + key + key + board.substring(end + 1);
                else
                    temp = board.substring(0, start) + key + key;
                board = temp;
            }
            else if(orientation.equals("h") && length == 3){
                int end = start + 2;
                if(end <= 35)
                    temp = board.substring(0, start) + key + key + key + board.substring(end + 1);
                else
                    temp = board.substring(0, start) + key + key + key;
                board = temp;
            }
            else if(orientation.equals("v")){
                for(int j = 0; j < length; j++){
                    start = col + 6*row;
                    if(start <= 35)
                        temp = board.substring(0, start) + key + board.substring(start + 1);
                    else
                    temp = board.substring(0, start) + key;
                    board = temp;
                    row++;
                }
            }
        }
        
        State s = new State(board);
        Solve.bfs(s, vehicles);




        // create

        // solve + print result

        // TODO:
        // parse input 
        // make BFS
        // find adjacency
        // hashmap of position - parent position
        // generate new board state, check if its in hashmap
        // yes = skip, no = add to queue, mark visited
    }
}
