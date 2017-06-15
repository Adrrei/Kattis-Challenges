/*
Problem: https://open.kattis.com/problems/busyschedule
Author: Adrian Reithaug
Submitted: June 15th, 2017
Time: 0.52s / 2.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class BusySchedule {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numAppointments = Integer.parseInt(reader.readLine());
        while (numAppointments != 0) {

            Time[] times = new Time[numAppointments];

            while (numAppointments-- > 0) {
                String time = reader.readLine();
                String modifiedTime = time.replaceAll("\\.", "").toUpperCase();

                if (modifiedTime.length() == 7) {
                    modifiedTime = "0" + modifiedTime;
                }

                String result = LocalTime.parse(modifiedTime, DateTimeFormatter.ofPattern("hh:mm a")).format(DateTimeFormatter.ofPattern("HH:mm"));
                times[numAppointments] = new Time(result, time);
            }

            Arrays.sort(times, (Time o1, Time o2) -> o1.military.compareTo(o2.military));

            for (Time time : times) {
                System.out.println(time.original);
            }

            numAppointments = Integer.parseInt(reader.readLine());

            if (numAppointments != 0) {
                System.out.println("");
            }

        }
    }

    public static class Time {

        String military;
        String original;

        public Time(String military, String original) {
            this.military = military;
            this.original = original;
        }
    }

}
