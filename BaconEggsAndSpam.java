/*
Problem: https://open.kattis.com/problems/baconeggsandspam
Author: Adrian Reithaug
Submitted: June 15th, 2017
Time: 0.20s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class BaconEggsAndSpam {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int numDays = Integer.parseInt(reader.readLine());

            if (numDays == 0) {
                break;
            }

            SortedMap<String, List<String>> menu = new TreeMap<>();

            while (numDays-- > 0) {
                String[] data = reader.readLine().split(" ");

                for (int i = 1; i < data.length; i++) {
                    List<String> names;

                    if (menu.containsKey(data[i])) {
                        names = menu.get(data[i]);
                    } else {
                        names = new ArrayList<>();
                    }

                    names.add(data[0]);
                    menu.put(data[i], names);
                }
            }

            for (Map.Entry<String, List<String>> map : menu.entrySet()) {
                String order = map.getKey() + " ";
                Collections.sort(map.getValue());
                for (String name : map.getValue()) {
                    order += name + " ";
                }

                System.out.println(order);
            }

            System.out.println("");

        }

    }

}
