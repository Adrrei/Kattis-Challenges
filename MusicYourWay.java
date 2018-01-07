/*
Problem: https://open.kattis.com/problems/musicyourway
Author: Adrian Reithaug
Submitted: January 7th, 2018
Time: 0.49s / 1.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MusicYourWay {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] attributes = reader.readLine().split(" ");
        int numSongs = Integer.parseInt(reader.readLine());

        Song[] songData = new Song[numSongs];
        String attributesLine = attributesToString(attributes);

        for (int i = 0; i < numSongs; i++) {
            songData[i] = new Song(reader.readLine().split(" "));
        }

        int numSortingCommands = Integer.parseInt(reader.readLine());
        while (numSortingCommands-- > 0) {
            String sortByAttribute = reader.readLine();
            int type = Arrays.asList(attributes).indexOf(sortByAttribute);

            System.out.println(attributesLine);

            sortSongs(songData, type);
            printSongs(songData);
        }

        reader.close();

    }

    public static String attributesToString(String[] attributes) {
        String attributesLine = "";

        for (String attribute : attributes) {
            attributesLine += attribute + " ";
        }
        return attributesLine;
    }

    public static void printSongs(Song[] songData) {
        for (Song song : songData) {
            for (String metadata : song.metadata) {
                System.out.print(metadata + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void sortSongs(Song[] songData, int type) {
        Arrays.sort(songData, (Song song1, Song song2) -> song1.metadata[type].compareTo(song2.metadata[type]));
    }

    public static class Song {

        String[] attributes;
        String[] metadata;

        public Song(String[] metadata) {
            this.metadata = metadata;
        }

    }

}
