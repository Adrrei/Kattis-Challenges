/*
Problem: https://open.kattis.com/problems/classy
Author: Adrian Reithaug
Submitted: September 2nd, 2017
Time: 0.75s / 6.00s
*/

using System;
using System.Collections.Generic;
using System.Linq;

namespace Kattis
{
    class AClassyProblem
    {

        static void Main(string[] args)
        {
            int numCases = int.Parse(Console.ReadLine());

            while (numCases-- > 0)
            {
                int numPeople = int.Parse(Console.ReadLine());
                var dictNames = new Dictionary<string, string>();

                for (int i = 0; i < numPeople; i++)
                {
                    string data = Console.ReadLine();
                    string[] types = data.Split(new char[] { ' ', '-' });
                    string typeValue = "";

                    for (int j = 0; j < types.Length; j++)
                    {
                        string type = types[types.Length - j - 1];

                        if (type.Equals("upper"))
                        {
                            typeValue += '0';
                        }
                        else if (type.Equals("middle"))
                        {
                            typeValue += '1';
                        }
                        else if (type.Equals("lower"))
                        {
                            typeValue += '2';
                        }
                    }

                    for (int j = typeValue.Length; j < 10; j++)
                    {
                        typeValue += '1';
                    }

                    dictNames.Add(data.Substring(0, data.IndexOf(':')), typeValue);

                }

                List<KeyValuePair<string, string>> listNames = dictNames.ToList();

                listNames.Sort(
                    delegate (KeyValuePair<string, string> pair1, KeyValuePair<string, string> pair2)
                    {
                        int order = pair1.Value.CompareTo(pair2.Value);
                        return (order == 0) ? pair1.Key.CompareTo(pair2.Key) : order;
                    }
                );

                foreach (KeyValuePair<string, string> type in listNames)
                {
                    Console.WriteLine(type.Key);
                }

                Console.WriteLine("==============================");
            }

        }
    }
}
