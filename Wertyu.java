/*
Problem: https://open.kattis.com/problems/wertyu
Author: Adrian Reithaug
Submitted: June 22nd, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Wertyu {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Character> altered = Arrays.asList(new Character[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\'', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/', ' '});
        List<Character> standard = Arrays.asList(new Character[]{'1', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', ' '});

        String line = reader.readLine();

        while (line != null) {
            char[] characters = line.toCharArray();

            for (char c : characters) {
                System.out.print(standard.get(altered.indexOf(c)));
            }

            System.out.println("");

            line = reader.readLine();
        }

    }

}
