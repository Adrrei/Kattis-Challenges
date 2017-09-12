/*
Problem: https://open.kattis.com/problems/bitbybit
Author: Adrian Reithaug
Submitted: September 12th, 2017
Time: 0.02s / 1.00s
*/

using System;

namespace Kattis
{
    class BitByBit
    {
        static void Main(string[] args)
        {
            int numOperations = int.Parse(Console.ReadLine());

            while (true)
            {
                if (numOperations == 0)
                {
                    break;
                }

                char[] register = "????????????????????????????????".ToCharArray();

                for (int i = 0; i < numOperations; i++)
                {
                    string[] operation = Console.ReadLine().Split(' ');
                    int position = int.Parse(operation[1]);

                    switch (operation[0][0])
                    {
                        case 'A':
                            register[position] = AND(register[position], register[int.Parse(operation[2])]);
                            break;
                        case 'O':
                            register[position] = OR(register[position], register[int.Parse(operation[2])]);
                            break;
                        default:
                            register[position] = (operation[0][0] == 'S') ? '1' : '0';
                            break;
                    }
                }

                for (int i = register.Length - 1; i >= 0; i--)
                {
                    Console.Write(register[i]);
                }

                Console.WriteLine();

                numOperations = int.Parse(Console.ReadLine());
            }
        }

        static char AND(char bitI, char bitJ)
        {
            if (bitI == '0' || bitJ == '0')
            {
                return '0';
            }
            if (bitI == '?' || bitJ == '?')
            {
                return '?';
            }
            return '1';
        }

        static char OR(char bitI, char bitJ)
        {
            if (bitI == '1' || bitJ == '1')
            {
                return '1';
            }
            if (bitI == '?' || bitJ == '?')
            {
                return '?';
            }
            return '0';
        }
    }
}
