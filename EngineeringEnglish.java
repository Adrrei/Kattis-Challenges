/*
Problem: https://open.kattis.com/problems/engineeringenglish
Author: Adrian Reithaug
Submitted: June 19th, 2017
Time: 0.28s / 4.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class EngineeringEnglish {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<String> duplicates = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        String line = reader.readLine();

        while (line != null) {
            String[] words = line.split(" ");

            line = "";
            for (String word : words) {
                if (duplicates.contains(word)) {
                    line += ". ";
                } else {
                    duplicates.add(word);
                    line += word + " ";
                }
            }

            System.out.println(line);

            line = reader.readLine();
        }

    }

}
