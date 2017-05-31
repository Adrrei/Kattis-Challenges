/*
Problem: https://open.kattis.com/problems/megainversions
Author: Adrian Reithaug
Submitted: March 10th, 2017
Time: 0.33s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MegaInversions {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long sequenceLength = Long.parseLong(reader.readLine());
        String sequence[] = reader.readLine().split(" ");

        List<Long> numbers = new ArrayList<>();
        List<Long> fenwickTree = new ArrayList<>();

        for (int i = 0; i < sequenceLength + 1; i++) {
            numbers.add(i, 0L);
            fenwickTree.add(i, 0L);
        }

        long inversions = 0;
        for (String value : sequence) {
            int number = Integer.parseInt(value);
            update(numbers, number, 1);
            update(fenwickTree, number, (getSum(numbers, sequenceLength) - getSum(numbers, number)));
            inversions += getSum(fenwickTree, sequenceLength) - getSum(fenwickTree, number);
        }
        System.out.println(inversions);
    }

    public static void update(List<Long> data, long index, long value) {
        if (index >= data.size()) {
            return;
        }
        data.set((int) index, data.get((int) index) + value);
        index += -index & index; // least significant bit
        update(data, index, value);
    }

    public static long getSum(List<Long> data, long index) {
        long total = 0;
        while (index > 0) {
            total += data.get((int) index);
            index -= -index & index;
        }
        return total;
    }

}
