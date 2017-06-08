/*
Problem: https://open.kattis.com/problems/maptiles2
Author: Adrian Reithaug
Submitted: June 8th, 2017
Time: 0.10s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MapTiles {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String quadkey = reader.readLine();

        int zoom = quadkey.length();
        int x = 0;
        int y = 0;

        for (int i = 0; i < quadkey.length(); i++) {
            char current = quadkey.charAt(i);
            int coordinate = (int) Math.pow(2, quadkey.length() - i - 1);

            if (current == '1' || current == '3') {
                x += coordinate;
            }
            if (current == '2' || current == '3') {
                y += coordinate;
            }
        }

        System.out.println(zoom + " " + x + " " + y);
    }

}
