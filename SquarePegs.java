/*
Problem: https://open.kattis.com/problems/squarepegs
Author: Adrian Reithaug
Submitted: April 22nd, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SquarePegs {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(" ");
        int numPlots = Integer.parseInt(data[0]);
        int circHouses = Integer.parseInt(data[1]);
        int sqHouses = Integer.parseInt(data[2]);

        List<Integer> plots = new ArrayList<>();
        List<Double> circles = new ArrayList<>();

        data = reader.readLine().split(" ");
        for (int i = 0; i < numPlots; i++) {
            plots.add(Integer.parseInt(data[i]));
        }
        
        data = reader.readLine().split(" ");
        for (int i = 0; i < circHouses; i++) {
            circles.add(Double.parseDouble(data[i]));
        }
        
        data = reader.readLine().split(" ");
        for (int i = 0; i < sqHouses; i++) {
            int size = Integer.parseInt(data[i]);
            double newSize = Math.sqrt(Math.pow(size, 2)/2);
            circles.add(newSize);
        }

        Collections.sort(circles);
        Collections.sort(plots);

        int bestNum = 0;
        int k = plots.size() - 1;

        for (int j = circles.size() - 1; j >= 0; j--) {
            if (circles.get(j) < plots.get(k)) {
                bestNum++;
                if (k - 1 >= 0) {
                    k--;
                } else {
                    break;
                }
            }
        }
        System.out.println(bestNum);

    }

}
