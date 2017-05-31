/*
Problem: https://open.kattis.com/problems/rubiksrevenge
Author: Adrian Reithaug
Submitted: March 26th, 2017
Time: 12.64s / 33.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RubiksRevenge {

    static Deque<char[][]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> solvedMap = new HashMap<>();
        Map<String, Integer> unsolvedMap = new HashMap<>();

        final int SIZE = 4;
        char[][] solvedCube = new char[SIZE][SIZE];
        char[][] unsolvedCube = new char[SIZE][SIZE];

        String unsolvedStr = "";
        String solvedStr = "RRRRGGGGBBBBYYYY";
        for (int i = 0, k = 0; i < SIZE; i++) {
            unsolvedStr += reader.readLine();
            for (int j = 0; j < SIZE; j++, k++) {
                solvedCube[i][j] = solvedStr.charAt(k);
                unsolvedCube[i][j] = unsolvedStr.charAt(k);
            }
        }

        // Bidirectional search to save time
        breadthFirstSearch(solvedCube, solvedMap, 6);
        breadthFirstSearch(unsolvedCube, unsolvedMap, 5);

        int maxMoves = 12;
        for (Map.Entry<String, Integer> entry : solvedMap.entrySet()) {
            if (unsolvedMap.containsKey(entry.getKey())) {
                maxMoves = Math.min(maxMoves, entry.getValue() + unsolvedMap.get(entry.getKey()));
            }
        }
        System.out.println(maxMoves);
    }

    public static void breadthFirstSearch(char[][] cube, Map<String, Integer> map, int level) {
        map.put(arrayToString(cube), 0);

        queue = new LinkedList<>();
        queue.push(cube);

        while (!queue.isEmpty()) {
            char[][] current = queue.pop();

            String cubeStr = arrayToString(current);
            if (!map.containsKey(cubeStr)) {
                map.put(cubeStr, 0);
            }
            int mapValue = map.get(cubeStr);
            if (mapValue == level) {
                break;
            }

            for (int row = 0; row < 4; row++) {
                shiftColors("left", map, row, current, mapValue);
                shiftColors("right", map, row, current, mapValue);
                shiftColors("up", map, row, current, mapValue);
                shiftColors("down", map, row, current, mapValue);
            }
        }

    }

    public static void shiftColors(String move, Map<String, Integer> map, int row, char[][] current, int mapValue) {
        char[][] next = new char[4][4];
        for (int i = 0; i < next.length; i++) {
            System.arraycopy(current[i], 0, next[i], 0, current[i].length);
        }

        int col = row;
        switch (move) {
            case "left":
                char first = current[row][0];
                for (col = 3; col > 0; col--) {
                    next[row][col - 1] = current[row][col];
                }
                next[row][3] = first;
                break;
            case "right":
                first = current[row][3];
                for (col = 0; col < 3; col++) {
                    next[row][col + 1] = current[row][col];
                }
                next[row][0] = first;
                break;
            case "up":
                first = current[0][col];
                for (row = 3; row > 0; row--) {
                    next[row - 1][col] = current[row][col];
                }
                next[3][col] = first;
                break;
            case "down":
                first = current[3][col];
                for (row = 0; row < 3; row++) {
                    next[row + 1][col] = current[row][col];
                }
                next[0][col] = first;
                break;
        }

        String nextStr = arrayToString(next);
        if (!map.containsKey(nextStr)) {
            map.put(nextStr, mapValue + 1);
            queue.addLast(next);
        }
    }

    public static String arrayToString(char[][] array) {
        return Arrays.deepToString(array).replace(",", "").replace("[", "").replace("]", "").replace(" ", "");
    }

}
