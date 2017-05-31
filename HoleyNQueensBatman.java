/*
Problem: https://open.kattis.com/problems/holeynqueensbatman
Author: Adrian Reithaug
Submitted: March 24th, 2017
Time: 3.62s / 9.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HoleyNQueensBatman {

    static int numSolutions = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] data = reader.readLine().split(" ");
            int boardLength = Integer.parseInt(data[0]);
            int numHoles = Integer.parseInt(data[1]);
            if (boardLength == 0 && numHoles == 0) {
                break;
            }
            numSolutions = 0;
            int[][] board = new int[boardLength][boardLength];
            while (numHoles-- > 0) {
                data = reader.readLine().split(" ");
                int row = Integer.parseInt(data[0]);
                int column = Integer.parseInt(data[1]);
                board[row][column] = 2;
            }
            numSolutions = placeQueen(board, 0);
            System.out.println(numSolutions);
        }

    }

    public static int placeQueen(int[][] board, int column) {
        if (column == board.length) {
            return numSolutions++;
        }
        for (int row = 0; row < board.length; row++) {
            if (isPlacementPossible(board, row, column)) {
                board[row][column] = 1;
                placeQueen(board, column + 1);
                board[row][column] = 0;
            }
        }
        return numSolutions;
    }

    public static boolean isPlacementPossible(int[][] board, int row, int column) {
        int initRow = row;
        int initColumn = column;

        if (board[row][column] == 2) {
            return false;
        }

        int col = 0;
        while (col < board.length) {
            if (board[row][col++] == 1) {
                return false;
            }
        }

        while (row >= 0 && column >= 0) {
            if (board[row--][column--] == 1) {
                return false;
            }
        }

        while (initColumn >= 0 && initRow < board.length) {
            if (board[initRow++][initColumn--] == 1) {
                return false;
            }
        }
        return true;
    }

}
