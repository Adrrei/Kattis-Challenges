/*
Problem: https://open.kattis.com/problems/deduplicatingfiles
Author: Adrian Reithaug
Submitted: December 23rd, 2017
Time: 1.17s / 2.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DeduplicatingFiles {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numFiles = Integer.parseInt(reader.readLine());

        while (numFiles > 0) {
            Map<String, Integer> files = new HashMap<>();
            Map<String, Integer> hashes = new HashMap<>();
            int numCollisions = 0;

            for (int i = 0; i < numFiles; i++) {
                String file = reader.readLine();

                if (files.containsKey(file)) {
                    files.put(file, files.get(file) + 1);
                } else {
                    files.put(file, 1);
                    hashes.put(file, hashCode(file));
                }
            }

            for (String file1 : files.keySet()) {
                for (String file2 : files.keySet()) {
                    if (!file1.equals(file2)) {
                        if (hashes.get(file1).equals(hashes.get(file2))) {
                            numCollisions += files.get(file1) * files.get(file2);
                        }
                    }
                }
            }

            System.out.println(files.size() + " " + numCollisions / 2);

            numFiles = Integer.parseInt(reader.readLine());
        }

        reader.close();
    }

    public static int hashCode(String file) {
        int hash = 0;
        for (char c : file.toCharArray()) {
            hash ^= c;
        }

        return hash;
    }

}
