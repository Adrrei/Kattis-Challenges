/*
Problem: https://open.kattis.com/problems/doggopher
Author: Adrian Reithaug
Submitted: September 14th, 2019
Time: 0.02s / 1.00s
*/

using System;

namespace Kattis
{
    public class DogAndGopher
    {
        private static void Main(string[] args)
        {
            double[] coordinates = Array.ConvertAll(Console.ReadLine().Split(' '), double.Parse);

            double gopherX = coordinates[0];
            double gopherY = coordinates[1];
            double dogX = coordinates[2];
            double dogY = coordinates[3];

            bool escape = false;
            string hole;
            while (!string.IsNullOrWhiteSpace(hole = Console.ReadLine()))
            {
                double[] holeCoordinates = Array.ConvertAll(hole.Split(' '), double.Parse);
                double holeX = holeCoordinates[0];
                double holeY = holeCoordinates[1];

                double gopherPos = Math.Sqrt(Math.Pow((gopherX - holeX), 2) + Math.Pow((gopherY - holeY), 2)) * 2;
                double dogPos = Math.Sqrt(Math.Pow((dogX - holeX), 2) + Math.Pow((dogY - holeY), 2));

                escape = gopherPos <= dogPos;

                if (escape)
                {
                    Console.WriteLine($"The gopher can escape through the hole at ({holeX:F3},{holeY:F3}).");
                    break;
                }
            }

            if (!escape)
            {
                Console.WriteLine("The gopher cannot escape.");
            }
        }
    }
}