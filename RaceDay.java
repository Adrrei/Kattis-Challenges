/*
Problem: https://open.kattis.com/problems/raceday
Author: Adrian Reithaug
Submitted: September 17th, 2017
Time: 0.87s / 3.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class RaceDay {

    public static void main(String[] args) throws IOException {
        final String FORMAT = "%-20s%10s%10s%10s%10s%10s%10s%10s\n";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int numRunners = Integer.parseInt(reader.readLine());

            if (numRunners == 0) {
                break;
            }

            Runner[] runners = new Runner[numRunners];

            for (int i = 0; i < numRunners; i++) {
                String[] contestant = reader.readLine().split(" ");

                runners[i] = new Runner(contestant[0], contestant[1], contestant[2]);
            }

            numRunners *= 3;

            while (numRunners-- > 0) {
                String[] lapTime = reader.readLine().split(" ");
                for (Runner runner : runners) {
                    if (lapTime[0].equals(runner.bib)) {
                        switch (lapTime[1]) {
                            case "S1":
                                runner.firstSplit = lapTime[2];
                                break;
                            case "S2":
                                runner.secondSplit = lapTime[2];
                                break;
                            case "F":
                                runner.finalTime = lapTime[2];
                                break;
                        }
                    }
                }
            }

            Collections.sort(Arrays.asList(runners), (Runner r1, Runner r2) -> r1.firstSplit.compareTo(r2.firstSplit));
            runners[0].firstRank = 1;
            for (int i = 1; i < runners.length; i++) {
                if (runners[i].firstSplit.equals(runners[i - 1].firstSplit)) {
                    runners[i].firstRank = runners[i - 1].firstRank;
                } else {
                    runners[i].firstRank = i + 1;
                }
            }

            Collections.sort(Arrays.asList(runners), (Runner r1, Runner r2) -> r1.secondSplit.compareTo(r2.secondSplit));
            runners[0].secondRank = 1;
            for (int i = 1; i < runners.length; i++) {
                if (runners[i].secondSplit.equals(runners[i - 1].secondSplit)) {
                    runners[i].secondRank = runners[i - 1].secondRank;
                } else {
                    runners[i].secondRank = i + 1;
                }
            }

            Collections.sort(Arrays.asList(runners), (Runner r1, Runner r2) -> r1.finalTime.compareTo(r2.finalTime));
            runners[0].finalRank = 1;
            for (int i = 1; i < runners.length; i++) {
                if (runners[i].finalTime.equals(runners[i - 1].finalTime)) {
                    runners[i].finalRank = runners[i - 1].finalRank;
                } else {
                    runners[i].finalRank = i + 1;
                }
            }

            Arrays.sort(runners);

            System.out.format(FORMAT, "NAME", "BIB", "SPLIT1", "RANK", "SPLIT2", "RANK", "FINISH", "RANK");
            for (Runner r : runners) {
                System.out.format(FORMAT, r.lastname + ", " + r.firstname, r.bib, r.firstSplit, r.firstRank, r.secondSplit, r.secondRank, r.finalTime, r.finalRank);
            }
            System.out.println("");

        }

    }

    public static class Runner implements Comparable<Runner> {

        String lastname;
        String firstname;
        String bib;
        String firstSplit;
        String secondSplit;
        String finalTime;
        int firstRank;
        int secondRank;
        int finalRank;

        public Runner(String firstname, String lastname, String bib) {
            this.lastname = lastname;
            this.firstname = firstname;
            this.bib = bib;
        }

        public int compareTo(Runner r) {
            int compare = lastname.compareTo(r.lastname);
            return (compare == 0) ? firstname.compareTo(r.firstname) : compare;
        }
    }
}
