/*
Problem: https://open.kattis.com/problems/getshorty
Author: Adrian Reithaug
Submitted: February 27th, 2017
Time: 1.15s / 3.00s
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class GetShorty {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] data = reader.readLine().split(" ");
            int numIntersections = Integer.parseInt(data[0]);
            int numCorridors = Integer.parseInt(data[1]);

            if (numIntersections == 0 && numCorridors == 0) {
                break;
            }

            Graph.Edge[] inputGraph = new Graph.Edge[numCorridors];

            for (int i = 0; i < numCorridors; i++) {
                data = reader.readLine().split(" ");
                int nodeX = Integer.parseInt(data[0]);
                int nodeY = Integer.parseInt(data[1]);
                double factorWeapon = Double.parseDouble(data[2]);
                inputGraph[i] = new Graph.Edge(nodeX, nodeY, factorWeapon);
            }

            Graph graph = new Graph(inputGraph);
            double fraction = graph.dijkstra(numIntersections);
            System.out.println(String.format("%.4f", fraction));
        }
    }

}

class Graph {

    Map<Integer, Edge> graph = new HashMap<>();

    public static class Edge implements Comparable<Edge> {
        Map<Edge, Double> neighbors = new HashMap<>();
        int name, nodeX, nodeY;
        double factorWeapon = 0.0;

        public Edge(int name) {
            this.name = name;
        }

        @Override
        public int compareTo(Edge neighbor) {
            return (neighbor.factorWeapon == factorWeapon) ? Integer.compare(neighbor.name, name) : Double.compare(neighbor.factorWeapon, factorWeapon);
        }

        public Edge(int nodeX, int nodeY, double factorWeapon) {
            this.nodeX = nodeX;
            this.nodeY = nodeY;
            this.factorWeapon = factorWeapon;
        }

    }

    public Graph(Edge[] edges) {
        for (Edge edge : edges) {
            graph.put(edge.nodeX, new Edge(edge.nodeX));
            graph.put(edge.nodeY, new Edge(edge.nodeY));
        }

        for (Edge edge : edges) {
            graph.get(edge.nodeX).neighbors.put(graph.get(edge.nodeY), edge.factorWeapon);
            graph.get(edge.nodeY).neighbors.put(graph.get(edge.nodeX), edge.factorWeapon);
        }
    }

    public double dijkstra(int numIntersections) {
        NavigableSet<Edge> queue = new TreeSet<>();
        for (Edge node : graph.values()) {
            node.factorWeapon = (node == graph.get(0)) ? 1.0 : 0.0;
            queue.add(node);
        }
        double[] factors = new double[numIntersections];
        factors[0] = 1.0;

        while (!queue.isEmpty()) {
            Edge nodeX = queue.pollFirst();

            nodeX.neighbors.entrySet().stream().forEach((neighborNode) -> {
                Edge nodeY = neighborNode.getKey();
                double newFactor = nodeX.factorWeapon * neighborNode.getValue();
                System.out.println(factors[nodeY.name] + " < " + newFactor);
                if (factors[nodeY.name] < newFactor) {
                    factors[nodeY.name] = newFactor;
                    queue.remove(nodeY);
                    nodeY.factorWeapon = newFactor;
                    queue.add(nodeY);
                }
            });
        }
        return factors[factors.length - 1];
    }
}
