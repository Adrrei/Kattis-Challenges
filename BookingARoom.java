/*
Problem: https://open.kattis.com/problems/bookingaroom
Author: Adrian Reithaug
Submitted: June 17th, 2017
Time: 0.11s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BookingARoom {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] rooms = reader.readLine().split(" ");
        int available = Integer.parseInt(rooms[0]);
        int booked = Integer.parseInt(rooms[1]);

        List<Integer> bookedRooms = new ArrayList<>();
        for (int i = 0; i < booked; i++) {
            bookedRooms.add(Integer.parseInt(reader.readLine()));
        }

        boolean tooLate = true;
        for (int i = 1; i <= available; i++) {
            if (!bookedRooms.contains(i)) {
                System.out.println(i);
                tooLate = false;
                break;
            }
        }

        if (tooLate) {
            System.out.println("too late");
        }
    }

}
