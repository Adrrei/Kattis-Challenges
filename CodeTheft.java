/*
Problem: https://open.kattis.com/problems/codetheft
Author: Adrian Reithaug
Submitted: May 27th, 2017
Time: 1.45s / 3.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CodeTheft {

    static List<List<Long>> fragments = new ArrayList<>();
    static Map<Integer, Integer> lengths = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final String end = "***END***";
        int maxLength = 0;
        int numFragments = Integer.parseInt(reader.readLine());
        String[] names = new String[numFragments];

        for (int i = 0; i <= 10000; i++) {
            fragments.add(i, new ArrayList<>());
        }

        for (int i = 0; i < numFragments; i++) {
            names[i] = reader.readLine();
            for (String line = reader.readLine(); !line.equals(end); line = reader.readLine()) {
                addHash(i, line);
            }
        }

        for (String line = reader.readLine(); !line.equals(end); line = reader.readLine()) {
            addHash(numFragments, line);
        }

        int repositoryLength = fragments.get(numFragments).size();
        for (int repoLine = 0; repoLine < repositoryLength; repoLine++) {
            if (repositoryLength - repoLine < maxLength) {
                break;
            }

            for (int fragName = 0; fragName < numFragments; fragName++) {
                int fragmentLength = fragments.get(fragName).size();

                for (int fragLine = 0; fragLine < fragmentLength; fragLine++) {
                    int thisLength = 0;

                    for (int line = 0; line < fragmentLength; line++) {
                        if (repoLine + line < repositoryLength && fragLine + line < fragmentLength && Objects.equals(fragments.get(fragName).get(fragLine + line), fragments.get(numFragments).get(repoLine + line))) {
                            thisLength++;
                        } else {
                            break;
                        }
                    }

                    if (thisLength >= maxLength) {
                        maxLength = thisLength;
                        lengths.put(fragName, maxLength);
                    }
                }
            }

        }

        System.out.print(maxLength);
        if (maxLength != 0) {
            for (int fragName = 0; fragName < numFragments; fragName++) {
                if (lengths.getOrDefault(fragName, -1) == maxLength) {
                    System.out.print(" " + names[fragName]);
                }
            }
        }
        System.out.println("");

    }

    public static void addHash(int pos, String line) {
        line = line.trim();
        if (!line.isEmpty()) {
            long hashCode = line.replaceAll("\\s+", " ").hashCode();
            fragments.get(pos).add(hashCode);
        }
    }

}
