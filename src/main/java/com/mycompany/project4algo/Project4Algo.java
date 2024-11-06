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

        // key - color, value - vehicle
        HashMap<String, Vehicle> vehicles = new HashMap<>();

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
            Vehicle v = new Vehicle(type, orientation, color, xPos, yPos, length);
            vehicles.put(color, v);
        }

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
