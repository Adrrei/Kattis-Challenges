/*
Problem: https://open.kattis.com/problems/planina
Author: Adrian Reithaug
Submitted: September 2nd, 2017
Time: 0.02s / 1.00s
*/

using System;

namespace Kattis
{
    class Planina
    {
        static void Main(string[] args)
        {
            int numIterations = int.Parse(Console.ReadLine());
            int numPoints = (int)Math.Pow(2, numIterations) + 1;
            Console.WriteLine(numPoints * numPoints);
        }
    }
}
