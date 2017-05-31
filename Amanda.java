/*
Problem: https://open.kattis.com/problems/amanda
Author: Adrian Reithaug
Submitted: January 27th, 2017
Time: 1.00s / 9.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Amanda {

    static boolean possible = true;
    static int[] lounges;
    static boolean[] visited0, visited1;
    static List<List<Integer>> neighbors = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] data = reader.readLine().split(" ");
        int numAirports = Integer.parseInt(data[0]);
        int numRoutes = Integer.parseInt(data[1]);

        lounges = new int[numAirports];
        visited0 = new boolean[numAirports];
        visited1 = new boolean[numAirports];

        for (int i = 0; i < numAirports; i++) {
            neighbors.add(new ArrayList<>());
        }

        Arrays.fill(lounges, -1);

        for (int i = 0; i < numRoutes; i++) {
            data = reader.readLine().split(" ");
            int startingAirport = Integer.parseInt(data[0]) - 1;
            int adjacentAirport = Integer.parseInt(data[1]) - 1;
            int numLounges = Integer.parseInt(data[2]);

            switch (numLounges) {
                case 0:
                    if (lounges[startingAirport] == 1 || lounges[adjacentAirport] == 1) {
                        possible = false;
                    } else {
                        lounges[startingAirport] = lounges[adjacentAirport] = 0;
                    }
                    break;
                case 2:
                    if (lounges[startingAirport] == 0 || lounges[adjacentAirport] == 0) {
                        possible = false;
                    } else {
                        lounges[startingAirport] = lounges[adjacentAirport] = 1;
                    }
                    break;
                default:
                    if (lounges[startingAirport] != -1) {
                        lounges[adjacentAirport] = (lounges[startingAirport] + 1) % 2;
                    } else if (lounges[adjacentAirport] != -1) {
                        lounges[startingAirport] = (lounges[adjacentAirport] + 1) % 2;
                    } else {
                        neighbors.get(startingAirport).add(adjacentAirport);
                        neighbors.get(adjacentAirport).add(startingAirport);
                    }
                    break;
            }
        }

        reader.close();

        if (possible) {
            for (int i = 0; i < lounges.length; i++) {
                if (!visited0[i] && lounges[i] != -1) {
                    if (!isCorrectNumLounges(i)) {
                        possible = false;
                        break;
                    }
                }
            }
        }

        int totalLounges = 0;
        for (int i = 0; i < lounges.length; i++) {
            if (possible) {
                if (visited0[i] && !visited1[i]) {
                    totalLounges += sum(i);
                } else if (!visited1[i]) {
                    lounges[i] = 0;
                    Lounges numLounges = setNumLounges(i);
                    totalLounges += Math.min(numLounges.startingAirport, numLounges.adjacentAirport);
                }
            } else {
                break;
            }
        }

        if (possible) {
            System.out.println(totalLounges);
        } else {
            System.out.println("impossible");
        }
    }

    // Get the number of lounges for the startingAirport and its neighbors
    public static int sum(int startingAirport) {
        visited1[startingAirport] = true;
        int sumLounges = lounges[startingAirport];
        for (int i = 0; i < neighbors.get(startingAirport).size(); i++) {
            int adjacentAirport = neighbors.get(startingAirport).get(i);
            if (!visited1[adjacentAirport]) {
                sumLounges += sum(adjacentAirport);
            }
        }
        return sumLounges;
    }

    public static boolean isCorrectNumLounges(int startingAirport) {
        visited0[startingAirport] = true;
        for (int i = 0; i < neighbors.get(startingAirport).size(); i++) {
            int adjacentAirport = neighbors.get(startingAirport).get(i);

            if (lounges[adjacentAirport] == -1) {
                lounges[adjacentAirport] = (lounges[startingAirport] + 1) % 2;
                if (!isCorrectNumLounges(adjacentAirport)) {
                    return false;
                }
            } else if (lounges[adjacentAirport] == lounges[startingAirport]) {
                return false;
            } else if (!visited0[adjacentAirport]) {
                if (!isCorrectNumLounges(adjacentAirport)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Sets the number of lounges for each airport adjacent to the startingAirport
    public static Lounges setNumLounges(int startingAirport) {
        visited1[startingAirport] = true;
        int first = (lounges[startingAirport] == 0) ? 1 : 0;
        int second = (lounges[startingAirport] == 0) ? 0 : 1;

        Lounges totalLounges = new Lounges(first, second);

        for (int i = 0; i < neighbors.get(startingAirport).size(); i++) {
            int adjacentAirport = neighbors.get(startingAirport).get(i);

            // Assign number of lounges for each airport, opposite of its destination (1/0)
            if (lounges[adjacentAirport] == -1) {
                lounges[adjacentAirport] = (lounges[startingAirport] + 1) % 2;
                Lounges individual = setNumLounges(adjacentAirport);
                if (!possible) {
                    return totalLounges;
                }
                totalLounges.startingAirport += individual.startingAirport;
                totalLounges.adjacentAirport += individual.adjacentAirport;
            } else if (lounges[adjacentAirport] == lounges[startingAirport]) {
                possible = false;
                return totalLounges;
            }
        }

        return totalLounges;
    }

    public static class Lounges {

        public int startingAirport;
        public int adjacentAirport;

        public Lounges(int startingAirport, int adjacentAirport) {
            this.startingAirport = startingAirport;
            this.adjacentAirport = adjacentAirport;
        }
    }
}
