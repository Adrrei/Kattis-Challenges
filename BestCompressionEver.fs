(*
Problem: https://open.kattis.com/problems/bestcompression
Author: Adrian Reithaug
Submitted: April 9th, 2022
CPU Time limit: 0.03s / 1.00s
Memory limit: 1024 MB
*)

open System

[<EntryPoint>]
let main _ =
    let input = Console.ReadLine() |> fun (s : string) -> s.Split([|' '|])
    let numberOfFiles = int64 input.[0]
    let maxBits = int input.[1]

    let isCompressable = numberOfFiles <= int64 (Math.Pow(2.0, float (maxBits + 1))) - int64 1
    
    match isCompressable with
    | true -> printf "yes\n"
    | false -> printf "no\n"

    0
