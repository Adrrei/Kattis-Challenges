/*
Problem: https://open.kattis.com/problems/numberfun
Author: Adrian Reithaug
Submitted: September 16th, 2019
Time: 0.06s / 1.00s
*/

using System;

namespace Kattis
{
    public class Output
    {
        public const string Possible = "Possible";
        public const string Impossible = "Impossible";
    }

    public class NumberFun
    {
        private static void Main(string[] args)
        {
            int numCases = int.Parse(Console.ReadLine());

            while (numCases-- > 0)
            {
                int[] numbers = Array.ConvertAll(Console.ReadLine().Split(' '), int.Parse);
                int a = numbers[0];
                int b = numbers[1];
                int result = numbers[2];

                bool canProduceResult = Calculate(a, b, result);
                string verdict = canProduceResult ? Output.Possible : Output.Impossible;

                Console.WriteLine(verdict);
            }
        }

        private static bool Calculate(int a, int b, int result)
        {
            if (a + b == result)
                return true;

            if (a - b == result || b - a == result)
                return true;

            if (a * b == result)
                return true;

            if (a % b == 0 && a / b == result)
                return true;

            if (b % a == 0 && b / a == result)
                return true;

            return false;
        }
    }
}