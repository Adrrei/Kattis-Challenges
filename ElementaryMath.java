/*
Problem: https://open.kattis.com/problems/elementarymath
Author: Adrian Reithaug
Submitted: April 25th, 2017
Time: 0.34s / 23.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementaryMath {

    public static List<List<Integer>> adjacencyList;
    public static int[] positions;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numPairs = Integer.parseInt(reader.readLine());

        Map<Long, Integer> uniqueAnswers = new HashMap<>();
        Map<Integer, Long> calculatedValues = new HashMap<>();

        Pair[] pairs = new Pair[numPairs];
        positions = new int[numPairs * 3];
        Arrays.fill(positions, -1);

        adjacencyList = new ArrayList<>();
        for (int i = 0; i < numPairs; i++) {
            adjacencyList.add(new ArrayList<>(3));
        }

        for (int i = 0; i < numPairs; i++) {
            String[] data = reader.readLine().split(" ");
            long a = Integer.parseInt(data[0]);
            long b = Integer.parseInt(data[1]);
            pairs[i] = new Pair(a, b);
            adjacencyList.get(i).add(addValue(a * b, uniqueAnswers, calculatedValues));
            adjacencyList.get(i).add(addValue(a + b, uniqueAnswers, calculatedValues));
            adjacencyList.get(i).add(addValue(a - b, uniqueAnswers, calculatedValues));
        }

        int numConnected = 0;
        for (int i = 0; i < numPairs; i++) {
            boolean[] visited = new boolean[numPairs * 3];
            numConnected = (connectValue(visited, i)) ? numConnected + 1 : 0;
        }

        if (numConnected < numPairs) {
            System.out.println("impossible");
            return;
        }

        long[] answers = new long[numPairs];
        for (int i = 0; i < uniqueAnswers.size(); i++) {
            if (positions[i] != -1) {
                answers[positions[i]] = calculatedValues.get(i);
            }
        }

        for (int i = 0; i < numPairs; i++) {
            long a = pairs[i].a;
            long b = pairs[i].b;
            String operator = " * ";

            if (a + b == answers[i]) {
                operator = " + ";
            } else if (a - b == answers[i]) {
                operator = " - ";
            }
            System.out.println(a + operator + b + " = " + answers[i]);
        }
    }

    public static int addValue(long value, Map<Long, Integer> uniqueAnswers, Map<Integer, Long> calculatedValues) {
        if (uniqueAnswers.get(value) == null) {
            uniqueAnswers.put(value, uniqueAnswers.size());
            calculatedValues.put(uniqueAnswers.get(value), value);
        }
        return uniqueAnswers.get(value);
    }

    public static boolean connectValue(boolean[] visited, int current) {
        if (current == -1) {
            return true;
        }

        for (int position : adjacencyList.get(current)) {
            if (!visited[position]) {
                visited[position] = true;
                if (connectValue(visited, positions[position])) {
                    positions[position] = current;
                    return true;
                }
            }
        }
        return false;
    }

    public static class Pair {

        long a;
        long b;

        Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

}
