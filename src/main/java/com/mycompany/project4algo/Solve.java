package com.mycompany.project4algo;
import java.util.*;

public class Solve {
    // HashMap<State, State> 
    public static int bfs(State initialState, HashMap<String, Vehicle> v) {
        Queue<State> queue = new LinkedList<>();
        queue.add(initialState);
        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            if (goalState() == true) {
                return currentState.getMoves();
            }
            if (goalState() == true) {
                break;
            }
        }

        // enqueue initial state
        // dequeue
        // check if red car at goal
        // if not: try all possible moves for each vehicle and add new states to queue
        // if yes: break and return moves
        return 0;
    }

    public static boolean goalState() {
        return true;
    }
}
