/*
Problem: https://open.kattis.com/problems/zoo
Author: Adrian Reithaug
Submitted: June 12th, 2017
Time: 0.23s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.TreeMap;

public class Zoo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int listId = 1;
        while (true) {
            int numAnimals = Integer.parseInt(reader.readLine());

            if (numAnimals == 0) {
                break;
            } else {
                SortedMap<String, Integer> animals = new TreeMap<>();
                System.out.println("List " + listId++ + ":");

                while (numAnimals-- > 0) {
                    String animal = reader.readLine().toLowerCase();
                    animal = animal.substring(animal.lastIndexOf(" ") + 1);
                    animals.put(animal, animals.getOrDefault(animal, 0) + 1);
                }

                animals.entrySet().forEach((map) -> {
                    System.out.println(map.getKey() + " | " + map.getValue());
                });
            }
        }
    }

}
