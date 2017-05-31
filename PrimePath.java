/*
Problem: https://open.kattis.com/problems/primepath
Author: Adrian Reithaug
Submitted: May 4th, 2017
Time: 0.27s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class PrimePath {

    static Map<String, Boolean> primes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numTestCases = Integer.parseInt(reader.readLine());

        for (int i = 1000; i < 10000; i++) {
            if (isPrime(i)) {
                primes.put(String.valueOf(i), false);
            }
        }

        while (numTestCases-- > 0) {
            String[] data = reader.readLine().split(" ");

            System.out.println(shortestPrimeDistance(data[0], data[1]));
            for (Map.Entry<String, Boolean> entry : primes.entrySet()) {
                primes.put(entry.getKey(), false);
            }
        }
    }

    public static int shortestPrimeDistance(String input, String target) {
        Queue<Prime> queue = new ArrayDeque<>();
        queue.add(new Prime(input, 0));

        while (!queue.isEmpty()) {
            Prime current = queue.poll();

            if (current.number.equals(target)) {
                return current.distance;
            }

            char[] charPrime = current.number.toCharArray();
            for (int i = 0; i < current.number.length(); i++) {
                for (int j = 0; j <= 9; j++) {
                    char previousChar = charPrime[i];
                    charPrime[i] = Integer.toString(j).charAt(0);

                    String newPrime = new String(charPrime);
                    if (primes.get(newPrime) != null && primes.get(newPrime) == false) {
                        queue.add(new Prime(newPrime, current.distance + 1));
                        primes.put(newPrime, true);
                    }

                    charPrime[i] = previousChar;
                }
            }
        }

        return 0;
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static class Prime {

        String number;
        int distance;

        Prime(String number, int distance) {
            this.number = number;
            this.distance = distance;
        }
    }

}
