/*
Problem: https://open.kattis.com/problems/symmetricorder
Author: Adrian Reithaug
Submitted: May 31st, 2017
Time: 0.09s / 2.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SymmetricOrder {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int id = 1;
        while (true) {
            int numInSet = Integer.parseInt(reader.readLine());
            if (numInSet == 0) {
                break;
            }
            System.out.println("SET " + id);

            List<String> names = new ArrayList<>();

            for (int i = 0; i < numInSet; i++) {
                if (i % 2 == 0) {
                    System.out.println(reader.readLine());
                } else {
                    names.add(reader.readLine());
                }
            }

            for (int i = names.size() - 1; i >= 0; i--) {
                System.out.println(names.get(i));
            }

            id++;
        }

    }

}
