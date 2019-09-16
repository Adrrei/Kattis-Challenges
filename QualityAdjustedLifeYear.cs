/*
Problem: https://open.kattis.com/problems/qaly
Author: Adrian Reithaug
Submitted: September 16th, 2019
Time: 0.02s / 1.00s
*/

using System;

namespace Kattis
{
    public class QualityAdjustedLifeYear
    {
        private static void Main(string[] args)
        {
            int numPeriods = int.Parse(Console.ReadLine());

            double sum = 0;

            while (numPeriods-- > 0)
            {
                double[] lifePeriods = Array.ConvertAll(Console.ReadLine().Split(' '), double.Parse);

                double qualityOfLife = lifePeriods[0];
                double numOfYears = lifePeriods[1];

                sum += qualityOfLife * numOfYears;
            }

            Console.WriteLine(sum);
        }
    }
}