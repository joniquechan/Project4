/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project4algo;
import java.util.*;

/**
 * This class is the main file.
 *
 * @author Roni Ebenezer, Jonique Chan
 * @version 1.0
 * File: Project4Algo.java
 * Created: Nov 2024
 * ©Copyright Cedarville University, its Computer Science faculty, 
 * and the authors. All rights reserved.
 *
 * Description: This class is the main file that reads the input in, creates the initial board state,
 * stores the information of each vehicle and outputs the result.
 */

public class Project4Algo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input: ");

        // key - color, value - vehicle
        HashMap<String, Vehicle> vehicles = new HashMap<>();
        String board = "------------------------------------";
        
        int numVehicles = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numVehicles; i++) {
            String type = sc.nextLine();
            String color = sc.nextLine();
            String orientation = sc.nextLine();
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            sc.nextLine();
            int length = 2;

            if (!type.equals("car")) {
                length = 3;
            }

            char k = (char)(i + 97);
            String key = "" + k;
            Vehicle v = new Vehicle(type, orientation, color, row, col, length, key);
            vehicles.put(key, v);

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
        
        // initialize initial state
        State s = new State(board);
        int result = Solve.bfs(s, vehicles);

        // print results
        if(result == 1){
            System.out.println("1 move");
        }
        else{
            System.out.println(result + " moves");
        }
        sc.close();
    }
}
