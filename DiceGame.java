/*
Problem: https://open.kattis.com/problems/dicegame
Author: Adrian Reithaug
Submitted: June 1st, 2017
Time: 0.09s / 4.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiceGame {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] diceGunnar = reader.readLine().split(" ");
        String[] diceEmma = reader.readLine().split(" ");

        int sumGunnar = 0;
        int sumEmma = 0;

        for (int i = 0; i < diceGunnar.length; i++) {
            sumGunnar += Integer.parseInt(diceGunnar[i]);
            sumEmma += Integer.parseInt(diceEmma[i]);
        }

        if (sumEmma > sumGunnar) {
            System.out.println("Emma");
        } else if (sumEmma < sumGunnar) {
            System.out.println("Gunnar");
        } else {
            System.out.println("Tie");
        }

    }

}
