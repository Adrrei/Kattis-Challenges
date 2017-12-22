/*
Problem: https://open.kattis.com/problems/pathtracing
Author: Adrian Reithaug
Submitted: December 22nd, 2017
Time: 0.38s / 2.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PathTracing {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int col = 500;
        int row = 500;
        int minCol = 500;
        int maxCol = 500;
        int minRow = 500;
        int maxRow = 500;

        char[][] grid = new char[minCol + maxCol + 1][minRow + maxRow + 1];
        grid[col][row] = 'S';

        String direction;
        while ((direction = reader.readLine()) != null) {
            switch (direction.charAt(0)) {
                case 'l':
                    col--;
                    break;
                case 'r':
                    col++;
                    break;
                case 'u':
                    row--;
                    break;
                default:
                    row++;
                    break;
            }

            maxRow = (row > maxRow) ? row : maxRow;
            minRow = (row < minRow) ? row : minRow;
            maxCol = (col > maxCol) ? col : maxCol;
            minCol = (col < minCol) ? col : minCol;

            if (grid[row][col] != 'S') {
                grid[row][col] = '*';
            }
        }
        reader.close();

        grid[row][col] = 'E';

        for (int i = minRow - 1; i <= maxRow + 1; i++) {
            for (int j = minCol - 1; j <= maxCol + 1; j++) {
                if ((i == minRow - 1 || i == maxRow + 1) || (j == minCol - 1 || j == maxCol + 1)) {
                    grid[i][j] = '#';
                } else if (grid[i][j] == 0) {
                    grid[i][j] = ' ';
                }
                System.out.print(grid[i][j]);
            }
            System.out.println("");
        }
    }

}
