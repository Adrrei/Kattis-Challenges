/*
Problem: https://open.kattis.com/problems/allergy
Author: Adrian Reithaug
Submitted: April 23rd, 2017
Time: 0.35s / 3.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllergyTest {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int totalAllergens = Integer.parseInt(reader.readLine());
        int[] numAllergens = new int[8];
        numAllergens[0] = 1;

        for (int i = 0; i < totalAllergens; i++) {
            numAllergens[Integer.parseInt(reader.readLine())]++;
        }

        Map<Integer, Integer> storedDurations = new HashMap<>();

        System.out.println(testScheme(numAllergens, storedDurations));
    }

    static int testScheme(int[] numAllergens, Map<Integer, Integer> storedDurations) {
        int hashCode = Arrays.hashCode(numAllergens);
        if (storedDurations.get(hashCode) != null) {
            return storedDurations.get(hashCode);
        }

        List<Integer> allergens = new ArrayList<>();
        int days = numAllergens[0];
        int totalAllergens = 0;
        
        for (int i = 1; i < 8; i++) {
            totalAllergens += numAllergens[i];
            if (numAllergens[i] != 0) {
                allergens.add(i);
            }
        }

        if (totalAllergens == 1) {
            return (days == allergens.get(0)) ? days : Integer.MAX_VALUE;
        }

        int shortestScheme = Integer.MAX_VALUE;
        for (int i = 0; i < allergens.size(); i++) {
            int liveDuration = allergens.get(i);

            if (liveDuration >= days) {
                for (int j = 1; j < 8; j++) {
                    
                    if (liveDuration < days + j) {
                        numAllergens[0] = j;
                        numAllergens[liveDuration]--;
                        int thisScheme = testScheme(numAllergens, storedDurations) + days;
                        numAllergens[liveDuration]++;
                        shortestScheme = (thisScheme > 0) ? Math.min(shortestScheme, thisScheme) : shortestScheme;
                    }
                }
                
            }
        }
        storedDurations.put(hashCode, shortestScheme);

        return shortestScheme;
    }

}
