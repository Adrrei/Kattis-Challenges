/*
Problem: https://open.kattis.com/problems/coast
Author: Adrian Reithaug
Submitted: January 28th, 2017
Time: 0.66s / 4.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Coast {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String[] DIMENSION;
        String[][] grid = null;
        int height = 0;
        int width = 0;
        int km = 0;

        try {
            DIMENSION = reader.readLine().split(" ");
            height = Integer.parseInt(DIMENSION[0]);
            width = Integer.parseInt(DIMENSION[1]);
            grid = new String[height][width];
            String input;

            // Create a grid from the input
            for (int y = 0; y < height; y++) {
                input = reader.readLine();
                for (int x = 0; x < width; x++) {
                    grid[y][x] = String.valueOf(input.charAt(x));
                }
            }
            reader.close();
        } catch (IOException e) {
        }

        // Set directions for west, north, east, and south of the current position
        Coordinate[] directions = {new Coordinate(-1, 0), new Coordinate(0, 1), new Coordinate(1, 0), new Coordinate(0, -1)};
        boolean[][] visited = new boolean[height][width];
        List<Coordinate> queue = new ArrayList<>();
        List<Coordinate> edges = new ArrayList<>();

        // Add the edges of the grid as starting nodes
        for (int y = 0; y < height; y++) {
            edges.add(new Coordinate(y, 0));
            edges.add(new Coordinate(y, width - 1));
        }

        for (int x = 0; x < width; x++) {
            edges.add(new Coordinate(0, x));
            edges.add(new Coordinate(height - 1, x));
        }

        // Add edge to queue if land/unvisited
        for (Coordinate edge : edges) {
            if (!visited[edge.x][edge.y] || grid[edge.x][edge.y].equals("1")) {
                queue.add(edge);
                visited[edge.x][edge.y] = true;
            }
        }

        while (!queue.isEmpty()) {
            Coordinate currentPosition = queue.remove(0);

            if (grid[currentPosition.x][currentPosition.y].equals("1")) {
                km++;
            } else {
                // Check if neighbors are land
                for (Coordinate direction : directions) {
                    int x = currentPosition.x + direction.x;
                    int y = currentPosition.y + direction.y;

                    if (x >= 0 && y >= 0 && x <= height - 1 && y <= width - 1) {
                        if (grid[x][y].equals("1")) {
                            km++;
                        } else if (!visited[x][y]) {
                            queue.add(new Coordinate(x, y));
                            visited[x][y] = true;
                        }
                    }

                }
            }
        }

        System.out.println(km);
    }

    private static class Coordinate {

        int x;
        int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
