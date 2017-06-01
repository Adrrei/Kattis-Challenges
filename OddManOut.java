/*
Problem: https://open.kattis.com/problems/oddmanout
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.19s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class OddManOut {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= numCases; i++) {
            reader.readLine(); // Unnecessary
            Map<String, Integer> invitations = new HashMap<>();

            String[] guests = reader.readLine().split(" ");

            for (String guest : guests) {
                if (invitations.containsKey(guest)) {
                    invitations.put(guest, invitations.get(guest) + 1);
                } else {
                    invitations.put(guest, 1);
                }
            }

            for (Map.Entry<String, Integer> entry : invitations.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    System.out.println("Case #" + i + ": " + entry.getKey());
                    break;
                }
            }

        }

    }

}
