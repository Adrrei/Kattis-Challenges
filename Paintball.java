/*
Problem: https://open.kattis.com/problems/paintball
Author: Adrian Reithaug
Submitted: April 27th, 2017
Time: 0.31s / 3.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Paintball {

    public static Map<Integer, Integer> targets = new HashMap<>();
    public static List<List<Integer>> adjacencyList;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(" ");

        int numPlayers = Integer.parseInt(data[0]) + 1;
        int numSightings = Integer.parseInt(data[1]);

        adjacencyList = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        while (numSightings-- > 0) {
            data = reader.readLine().split(" ");
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);
            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);
        }

        for (int player = 0; player < numPlayers; player++) {
            boolean[] hitPlayers = new boolean[numPlayers];
            for (int target : adjacencyList.get(player)) {
                if (playerHit(hitPlayers, target)) {
                    targets.put(target, player);
                    break;
                }
            }
        }

        if (targets.size() != (numPlayers - 1)) {
            System.out.println("Impossible");
            return;
        }

        for (int i = 1; i < numPlayers; i++) {
            System.out.println(targets.get(i));
        }
    }

    public static boolean playerHit(boolean[] hitPlayers, int newTarget) {
        Integer player = targets.get(newTarget);
        if (player == null) {
            return true;
        }

        hitPlayers[newTarget] = true;
        for (int target : adjacencyList.get(player)) {
            if (!hitPlayers[target] && playerHit(hitPlayers, target)) {
                targets.put(target, player);
                return true;
            }
        }
        return false;
    }

}
