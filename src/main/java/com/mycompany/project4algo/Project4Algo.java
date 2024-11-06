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
            int xPos = sc.nextInt();
            int yPos = sc.nextInt();
            sc.nextLine();
            int length = 2;
            if (type != "car") {
                length = 3;
            }
            String key = Integer.toString(i);
            Vehicle v = new Vehicle(type, orientation, color, xPos, yPos, length, key);
            vehicles.put(key, v);
            xPos--;
            yPos--;
            if(orientation.equals("h") && length == 2){
                int start = xPos + 6*yPos;
                int end = start + 1;
                String temp;
                if(end != 35)
                    temp = board.substring(0, start) + key + key + board.substring(end + 1);
                else
                    temp = board.substring(0, start) + key + key;
                board = temp;
            }
            if(orientation.equals("h") && length == 3){
                int start = xPos + 6*yPos;
                int end = start + 2;
                String temp;
                if(end != 35)
                    temp = board.substring(0, start) + key + key + key + board.substring(end + 1);
                else
                    temp = board.substring(0, start) + key + key + key;
                board = temp;
            }
            if(orientation.equals("v")){
                for(int j = 0; j < length; j++){
                    int start = xPos + 6*yPos;
                    String temp;
                        if(start != 35)
                    temp = board.substring(0, start) + key;
                        else
                    temp = board.substring(0, start) + key + board.substring(start + 1);
                    board = temp;
                    yPos++;
                }
            }
        }
        System.out.println(board);


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
