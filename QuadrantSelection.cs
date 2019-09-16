/*
Problem: https://open.kattis.com/problems/quadrant
Author: Adrian Reithaug
Submitted: September 16th, 2019
Time: 0.02s / 1.00s
*/

using System;

namespace Kattis
{
    public enum Quadrant
    {
        First = 1,
        Second = 2,
        Third = 3,
        Fourth = 4
    }

    public class QuadrantSelection
    {
        private static void Main(string[] args)
        {
            int x = int.Parse(Console.ReadLine());
            int y = int.Parse(Console.ReadLine());

            int quadrant = (int)GetQuadrant(x, y);

            Console.WriteLine(quadrant);
        }

        private static Quadrant GetQuadrant(int x, int y)
        {
            if (x > 0 && y > 0)
                return Quadrant.First;

            if (x < 0 && y < 0)
                return Quadrant.Third;

            if (x > 0 && y < 0)
                return Quadrant.Fourth;

            return Quadrant.Second;
        }
    }
}