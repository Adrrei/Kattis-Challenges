/*
Problem: https://open.kattis.com/problems/city
Author: Adrian Reithaug
Submitted: September 5th, 2017
Time: 0.96s / 9.00s
*/

using System;

namespace Kattis
{
    public class CityDestruction
    {
        private static long damage;
        private static House[] houses;
        private static long[,] houseMoves;

        static void Main(string[] args)
        {
            int numCases = int.Parse(Console.ReadLine());

            while (numCases-- > 0)
            {
                string[] data = Console.ReadLine().Split(' ');
                int numBuildings = int.Parse(data[0]);
                damage = long.Parse(data[1]);

                string[] houseHealth = Console.ReadLine().Split(' ');
                string[] houseExplosion = Console.ReadLine().Split(' ');

                houses = new House[numBuildings + 1];
                houses[numBuildings] = new House(0, 0);
                houseMoves = new long[numBuildings + 1, 2];

                for (int i = 0; i <= numBuildings; i++)
                {
                    if (i != numBuildings)
                    {
                        houses[i] = new House(long.Parse(houseHealth[i]), long.Parse(houseExplosion[i]));
                    }

                    for (int j = 0; j < 2; j++)
                    {
                        houseMoves[i, j] = -1;
                    }
                }

                Console.WriteLine(MinimumMoves(0, 0, 0));
            }
        }

        public static long MinimumMoves(int id, int type, long explosion)
        {
            if (id == houses.Length - 1)
            {
                return 0;
            }

            if (houseMoves[id, type] > 0)
            {
                return houseMoves[id, type];
            }

            long move1 = Math.Max(0, (houses[id].Health - explosion + damage - 1 - houses[id + 1].Explosion) / damage);
            long move2 = Math.Max(0, (houses[id].Health - explosion + damage - 1) / damage); 

            long minimum = Math.Min(move1 + MinimumMoves(id + 1, 0, 0), move2 + MinimumMoves(id + 1, 1, houses[id].Explosion));
            houseMoves[id, type] = minimum;

            return minimum;
        }
    }

    public class House
    {
        public long Health { get; private set; }
        public long Explosion { get; private set; }

        public House(long health, long explosion)
        {
            this.Health = health;
            this.Explosion = explosion;
        }

    }
}
