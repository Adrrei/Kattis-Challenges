/*
Problem: https://open.kattis.com/problems/gamerank
Author: Adrian Reithaug
Submitted: September 3rd, 2017
Time: 0.02s / 1.00s
*/

using System;

namespace Kattis
{
    class GameRank
    {
        static void Main(string[] args)
        {
            string games = Console.ReadLine();

            int rank = 25;
            int stars = 0;
            int concurrentWins = 0;

            for (int i = 0; i < games.Length && rank != 0; i++)
            {
                if (games[i] == 'W')
                {
                    concurrentWins++;
                    stars += (concurrentWins >= 3 && rank >= 6) ? 2 : 1;

                    if (stars > StarsRequired(rank))
                    {
                        stars -= StarsRequired(rank);
                        rank--;
                    }
                }
                else
                {
                    concurrentWins = 0;

                    if (rank < 20 || (rank == 20 && stars > 0))
                    {
                        stars--;
                    }

                    if (stars < 0)
                    {
                        rank++;
                        stars = StarsRequired(rank) - 1;
                    }
                }

            }

            Console.WriteLine(rank == 0 ? "Legend" : rank.ToString());
        }

        private static int StarsRequired(int rank)
        {
            if (rank >= 21)
            {
                return 2;
            }
            else if (rank >= 16)
            {
                return 3;
            }
            else if (rank >= 11)
            {
                return 4;
            }
            return 5;
        }
    }
}
