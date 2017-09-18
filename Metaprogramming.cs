/*
Problem: https://open.kattis.com/problems/metaprogramming
Author: Adrian Reithaug
Submitted: September 18th, 2017
Time: 0.06s / 4.00s
*/

using System;
using System.Collections.Generic;

namespace Kattis
{
    class Metaprogramming
    {
        static void Main(string[] args)
        {

            Dictionary<String, int> definitions = new Dictionary<string, int>();

            string command;
            while ((command = Console.ReadLine()) != null)
            {

                if (command[0].Equals('d'))
                {
                    string[] definition = command.Split(' ');
                    if (definitions.ContainsKey(definition[2]))
                    {
                        definitions[definition[2]] = int.Parse(definition[1]);
                    }
                    else
                    {
                        definitions.Add(definition[2], int.Parse(definition[1]));
                    }
                }
                else
                {
                    string[] evaluation = command.Split(' ');
                    string result = "undefined";

                    if (definitions.ContainsKey(evaluation[1]) && definitions.ContainsKey(evaluation[3]))
                    {
                        int leftValue = definitions[evaluation[1]];
                        int rightValue = definitions[evaluation[3]];
                        string sign = evaluation[2];

                        if (sign.Equals(">"))
                        {
                            result = (leftValue > rightValue) ? "true" : "false";
                        }
                        else if (sign.Equals("<"))
                        {
                            result = (leftValue < rightValue) ? "true" : "false";
                        }
                        else
                        {
                            result = (leftValue == rightValue) ? "true" : "false";
                        }
                    }

                    Console.WriteLine(result);
                }
            }
        }
    }
}
