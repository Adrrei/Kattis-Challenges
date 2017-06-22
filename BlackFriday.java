/*
Problem: https://open.kattis.com/problems/blackfriday
Author: Adrian Reithaug
Submitted: June 22nd, 2017
Time: 0.09s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BlackFriday {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numParticipants = Integer.parseInt(reader.readLine());
        String[] idParticipants = reader.readLine().split(" ");

        Set<Integer> seen = new HashSet<>(numParticipants);
        Set<Integer> uniques = new HashSet<>(numParticipants);

        for (int i = 0; i < numParticipants; i++) {
            int outcome = Integer.parseInt(idParticipants[i]);

            if (seen.contains(outcome)) {
                uniques.remove(outcome);
            } else {
                seen.add(outcome);
                uniques.add(outcome);
            }
        }

        if (uniques.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(Arrays.asList(idParticipants).indexOf(Integer.toString(Collections.max(uniques))) + 1);
        }

    }

}
