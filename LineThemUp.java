/*
Problem: https://open.kattis.com/problems/lineup
Author: Adrian Reithaug
Submitted: June 5th, 2017
Time: 0.08s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LineThemUp {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numPeople = Integer.parseInt(reader.readLine()) - 1;
        String prevName = reader.readLine();

        char order = ' ';
        while (numPeople-- > 0) {
            String currName = reader.readLine();

            int max = Math.min(prevName.length(), currName.length());
            for (int i = 0; i < max; i++) {
                if (prevName.charAt(i) < currName.charAt(i)) {
                    if (order == ' ' || order == 'I') {
                        order = 'I';
                        break;
                    } else {
                        order = 'N';
                        break;
                    }
                } else if (prevName.charAt(i) > currName.charAt(i)) {
                    if (order == ' ' || order == 'D') {
                        order = 'D';
                        break;
                    } else {
                        order = 'N';
                        break;
                    }
                }
            }

            if (order == 'N') {
                break;
            }
            prevName = currName;

        }

        switch (order) {
            case 'I':
                System.out.println("INCREASING");
                break;
            case 'D':
                System.out.println("DECREASING");
                break;
            default:
                System.out.println("NEITHER");
                break;
        }
    }

}
