/*
Problem: https://open.kattis.com/problems/erase
Author: Adrian Reithaug
Submitted: June 15th, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EraseSecurely {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int overwrites = Integer.parseInt(reader.readLine());

        char[] data = reader.readLine().toCharArray();
        String verification = reader.readLine();

        boolean success = true;

        String out = "";
        if (overwrites % 2 != 0) {
            for (char c : data) {
                out += (c == '0') ? "1" : "0";
            }
        } else {
            out = String.copyValueOf(data);
        }

        if (!out.equals(verification)) {
            success = false;
        }

        System.out.println(success ? "Deletion succeeded" : "Deletion failed");

    }

}
