package com.mac286.Graphs;

public class GraphTester {
    public static void main(String[] args) {
        OurGraph<String> G = new OurGraph<>();
        G.addEdge("A", "B");
        G.addEdge("B", "C");
        G.addEdge("C", "D");
        G.addEdge("C", "B");
        G.addEdge("C", "E");
        G.addEdge("C", "F");
        G.addEdge("E", "D");
        G.addEdge("E", "C");
        G.addEdge("E", "G");
        G.addEdge("E", "H");
        G.addEdge("F", "C");
        System.out.println("Original graph G: " + G.toString());
        System.out.println("DFS at B: " + G.DepthFirstSearch("B"));
        System.out.println("BFS at D: " + G.BreadthFirstSearch("D"));
        G.deleteEdge("C","F");
        System.out.println("Graph G after deleting c,F edge: " + G.toString());
    }
}

