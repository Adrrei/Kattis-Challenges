/*
Problem: https://open.kattis.com/problems/pebblesolitaire2
Author: Adrian Reithaug
Submitted: February 22nd, 2017
Time: 0.31s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class PebbleSolitaire {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numGames = Integer.parseInt(reader.readLine());
        while (numGames-- > 0) {
            HashMap<String, Integer> boardState = new HashMap<>();
            char[] board = reader.readLine().toCharArray();
            int pebblesRemaining = playSolitaire(board, boardState);

            System.out.println(pebblesRemaining);
        }
    }

    public static int playSolitaire(char[] board, HashMap<String, Integer> boardState) {
        String data = new String(board);
        if (boardState.get(data) == null) {
            boardState.put(data, -1);
        } else if (boardState.get(data) != -1) {
            return boardState.get(data);
        }

        char[] previousState = Arrays.copyOf(board, board.length);
        int pebblesRemaining = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i] == 'o') {
                pebblesRemaining++;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i] == 'o') {
                if (i + 2 < board.length && board[i + 1] == 'o' && board[i + 2] == '-') {
                    board[i] = '-';
                    board[i + 1] = '-';
                    board[i + 2] = 'o';
                    pebblesRemaining = Math.min(pebblesRemaining, playSolitaire(board, boardState));
                    board = Arrays.copyOf(previousState, board.length);
                }
                if (i - 2 >= 0 && board[i - 1] == 'o' && board[i - 2] == '-') {
                    board[i] = '-';
                    board[i - 1] = '-';
                    board[i - 2] = 'o';
                    pebblesRemaining = Math.min(pebblesRemaining, playSolitaire(board, boardState));
                    board = Arrays.copyOf(previousState, board.length);
                }
            }
        }

        boardState.put(data, pebblesRemaining);
        return pebblesRemaining;
    }

}
