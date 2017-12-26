/*
Problem: https://open.kattis.com/problems/visualgo
Author: Adrian Reithaug
Submitted: December 26th, 2017
Time: 0.48s / 3.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VisuAlgo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] graphDetails = reader.readLine().split(" ");
        int numVertices = Integer.parseInt(graphDetails[0]);
        int numEdges = Integer.parseInt(graphDetails[1]);

        Vertex[] vertices = new Vertex[numVertices];

        for (int i = 0; i < numVertices; i++) {
            vertices[i] = new Vertex();
        }

        for (int i = 0; i < numEdges; i++) {
            graphDetails = reader.readLine().split(" ");
            Vertex source = vertices[Integer.parseInt(graphDetails[0])];
            Vertex target = vertices[Integer.parseInt(graphDetails[1])];
            int weight = Integer.parseInt(graphDetails[2]);

            Edge edge = new Edge(source, target, weight);
            source.edges.add(edge);
        }

        graphDetails = reader.readLine().split(" ");
        int source = Integer.parseInt(graphDetails[0]);
        int target = Integer.parseInt(graphDetails[1]);

        reader.close();

        System.out.println(traverseGraph(vertices, source, target));
    }

    public static int traverseGraph(Vertex[] vertices, int source, int target) {
        vertices[source].distance = 0;
        vertices[source].numPaths = 1;

        List<Vertex> queue = new LinkedList<>();
        queue.add(queue.size(), vertices[source]);

        while (!queue.isEmpty()) {
            Vertex current = queue.remove(0);
            for (Edge edge : current.edges) {
                Vertex neighbor = edge.target;

                if (!neighbor.visited) {
                    neighbor.visited = true;
                    queue.add(queue.size(), neighbor);
                }

                int totDist = current.distance + edge.weight;

                if (totDist < neighbor.distance) {
                    neighbor.distance = totDist;
                    neighbor.numPaths = current.numPaths;
                } else if (totDist == neighbor.distance) {
                    neighbor.numPaths += current.numPaths;
                }

            }
        }

        return vertices[target].numPaths;
    }

    public static class Edge {

        private Vertex source;
        private Vertex target;
        private int weight;

        public Edge(Vertex source, Vertex target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }

    public static class Vertex {

        private int numPaths = 0;
        private int distance = Integer.MAX_VALUE;

        private boolean visited = false;
        private List<Edge> edges = new ArrayList<>();
    }

}
