/*
Problem: https://open.kattis.com/problems/bank
Author: Adrian Reithaug
Submitted: September 27th, 2017
Time: 0.27s / 3.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(" ");
        int numPeople = Integer.parseInt(data[0]);
        int totalTime = Integer.parseInt(data[1]);

        List<Integer>[] money = new ArrayList[totalTime];

        for (int i = 0; i < totalTime; i++) {
            money[i] = new ArrayList<>();
        }

        while (numPeople-- > 0) {
            String[] person = reader.readLine().split(" ");
            money[Integer.parseInt(person[1])].add(Integer.parseInt(person[0]));
        }

        List<Integer> moneyOptions = new ArrayList<>(totalTime);

        int maxMoney = 0;
        for (int i = totalTime - 1; i >= 0; i--) {
            moneyOptions.addAll(money[i]);

            if (!moneyOptions.isEmpty()) {
                Collections.sort(moneyOptions);
                maxMoney += moneyOptions.remove(moneyOptions.size() - 1);
            }

        }

        System.out.println(maxMoney);
    }
}
