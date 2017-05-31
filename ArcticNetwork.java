/*
Problem: https://open.kattis.com/problems/arcticnetwork
Author: Adrian Reithaug
Submitted: March 1st, 2017
Time: 0.62s / 4.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArcticNetwork {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numTestCases = Integer.parseInt(reader.readLine());
        while (numTestCases-- > 0) {
            String data[] = reader.readLine().split(" ");
            int channels = Integer.parseInt(data[0]);
            int outposts = Integer.parseInt(data[1]);

            int[] set = new int[outposts];
            Edge[] graph = new Edge[outposts];
            List<Edge> edges = new ArrayList<>();

            for (int i = 0; i < outposts; i++) {
                data = reader.readLine().split(" ");
                int x = Integer.parseInt(data[0]);
                int y = Integer.parseInt(data[1]);
                graph[i] = new Edge(x, y, 0);
                set[i] = i;
            }

            for (int i = 0; i < outposts; i++) {
                for (int j = i + 1; j < outposts; j++) {
                    double distanceX = graph[i].nodeX - graph[j].nodeX;
                    double distanceY = graph[i].nodeY - graph[j].nodeY;
                    double distance = Math.pow(distanceX * distanceX + distanceY * distanceY, 0.5);
                    edges.add(new Edge(i, j, distance));
                }
            }
            Collections.sort(edges);

            // Kruskal's algorithm
            int numEdges = 0;
            ArrayList<Double> distances = new ArrayList<>();
            for (int i = 0; numEdges < outposts - channels; i++) {
                numEdges += union(edges.get(i), distances, set);
            }
            System.out.print(String.format("%.2f\n", distances.get(numEdges - 1)));
        }
    }

    public static int union(Edge edges, ArrayList<Double> distances, int[] set) {
        int x = findSet(edges.nodeX, set);
        int y = findSet(edges.nodeY, set);

        if (x != y) {
            set[x] = y;
            distances.add(edges.distance);
            return 1;
        }
        return 0;
    }

    public static int findSet(int coordinate, int[] set) {
        return (coordinate == set[coordinate]) ? coordinate : findSet(set[coordinate], set);
    }

    public static class Edge implements Comparable<Edge> {

        int nodeX, nodeY;
        double distance;

        public Edge(int nodeX, int nodeY, double weight) {
            this.nodeX = nodeX;
            this.nodeY = nodeY;
            this.distance = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Double.compare(distance, other.distance);
        }

    }

}
