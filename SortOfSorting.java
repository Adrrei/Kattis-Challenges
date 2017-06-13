/*
Problem: https://open.kattis.com/problems/sortofsorting
Author: Adrian Reithaug
Submitted: June 13th, 2017
Time: 0.78s / 3.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortOfSorting {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numNames = Integer.parseInt(reader.readLine());
        while (true) {

            List<String> names = new ArrayList<>();
            while (numNames-- > 0) {
                names.add(reader.readLine());
            }

            names.sort((name1, name2) -> {
                int returnValue = 0;
                for (int i = 0; i < 2; i++) {
                    if (name1.charAt(i) > name2.charAt(i)) {
                        returnValue = 1;
                        break;
                    } else if (name1.charAt(i) < name2.charAt(i)) {
                        returnValue = -1;
                        break;
                    }
                }

                return returnValue;
            });

            for (String name : names) {
                System.out.println(name);
            }

            numNames = Integer.parseInt(reader.readLine());
            if (numNames > 0) {
                System.out.println("");
            } else {
                break;
            }
        }

    }

}
