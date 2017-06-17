/*
Problem: https://open.kattis.com/problems/vote
Author: Adrian Reithaug
Submitted: June 17th, 2017
Time: 0.12s / 2.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PopularVote {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(reader.readLine());

        while (numCases-- > 0) {
            int leadingCandidate = 0;

            int numCandidates = Integer.parseInt(reader.readLine());
            int[] votes = new int[numCandidates];
            for (int i = 0; i < numCandidates; i++) {
                int numVotes = Integer.parseInt(reader.readLine());
                votes[i] = numVotes;
            }

            int sumVotes = 0;
            int leaderVotes = 0;

            for (int i = 0; i < numCandidates; i++) {
                if (votes[i] > leaderVotes) {
                    leadingCandidate = i;
                    leaderVotes = votes[i];
                }

                sumVotes += votes[i];
            }

            Arrays.sort(votes);

            if (votes[numCandidates - 1] == votes[numCandidates - 2]) {
                System.out.println("no winner");
            } else {
                sumVotes -= leaderVotes;
                System.out.print(leaderVotes > sumVotes ? "majority" : "minority");
                System.out.println(" winner " + (leadingCandidate + 1));
            }
        }

    }

}
