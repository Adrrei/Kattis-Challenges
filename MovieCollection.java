/*
Problem: https://open.kattis.com/problems/moviecollection
Author: Adrian Reithaug
Submitted: March 8th, 2017
Time: 1.13s / 4.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieCollection {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numTestCases = Integer.parseInt(reader.readLine());

        while (numTestCases-- > 0) {
            String data[] = reader.readLine().split(" ");
            int numMovies = Integer.parseInt(data[0]);
            int[] collection = new int[numMovies + 1];
            int[] fenwickTree = new int[500000];

            for (int i = 1; i <= numMovies; i++) {
                updateFrequency(fenwickTree, i, 1);
                collection[i] = numMovies - i + 1; // reverse
            }

            int count = numMovies;
            data = reader.readLine().split(" ");
            for (String movie : data) {
                count++;
                int movieId = Integer.parseInt(movie);
                int total = 0;
                int index = collection[movieId];

                while (index > 0) {
                    total += fenwickTree[index];
                    index -= -index & index;
                }

                updateFrequency(fenwickTree, collection[movieId], -1);
                collection[movieId] = count;
                updateFrequency(fenwickTree, collection[movieId], 1);
                System.out.print(numMovies - total + " ");
            }
            System.out.println();

        }
    }

    public static void updateFrequency(int[] fenwickTree, int index, int value) {
        if (index >= fenwickTree.length) {
            return;
        }
        fenwickTree[index] += value;
        index += -index & index; // least significant bit
        updateFrequency(fenwickTree, index, value);
    }

}
