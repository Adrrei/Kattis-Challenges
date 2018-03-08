/*
Problem: https://open.kattis.com/problems/medals
Author: Adrian Reithaug
Submitted: March 8th, 2018
Time: 0.02s / 1.00s
 */

using System;
using System.Collections.Generic;

namespace Kattis
{
    class Medals
    {
        static void Main(string[] args)
        {
            while (true)
            {
                int numCountries = int.Parse(Console.ReadLine());

                if (numCountries == 0)
                {
                    break;
                }

                Dictionary<string, int[]> Countries = new Dictionary<string, int[]>();

                int numMedals = 0;

                for (int i = 0; i < numCountries; i++)
                {
                    string[] input = Console.ReadLine().Split(' ');
                    int numGold = int.Parse(input[1]);
                    int numSilver = int.Parse(input[2]);
                    int numBronze = int.Parse(input[3]);

                    numMedals += numGold + numSilver + numBronze;
                    Countries.Add(input[0], new int[3] { numGold, numSilver, numBronze });
                }

                CalculateScore(Countries, numMedals);
            }

        }

        public static void CalculateScore(Dictionary<string, int[]> Countries, int numMedals)
        {
            for (int j = 0; j <= 3; j++)
            {
                for (int k = 0; k <= 3; k++)
                {
                    if (CompareScore(Countries, numMedals, j, k))
                    {
                        Console.WriteLine("Canada wins!");
                        return;
                    }
                }
            }
            Console.WriteLine("Canada cannot win.");
        }

        public static bool CompareScore(Dictionary<string, int[]> Countries, int numMedals, double j, double k)
        {
            double scoreBest = 0;
            double scoreCanada = 0;
            foreach (KeyValuePair<string, int[]> country in Countries)
            {
                double score = (Math.Pow(numMedals, 0) * country.Value[0]) + (Math.Pow(numMedals, j) * country.Value[1]) + (Math.Pow(numMedals, k) * country.Value[2]);
                if (country.Key.Equals("Canada"))
                {
                    scoreCanada = score;
                }
                else if (score > scoreBest)
                {
                    scoreBest = score;
                }
            }
            return scoreCanada >= scoreBest;
        }
    }
}
