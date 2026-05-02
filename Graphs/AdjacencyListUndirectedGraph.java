import java.util.*;

public class AdjacencyListUndirectedGraph {
    
    // Function to add an edge to the undirected graph
    public static void addEdge(Map<Integer, List<Integer>> adjList, int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());

        adjList.get(u).add(v);
        adjList.get(v).add(u); // Since the graph is undirected
    }

    // Function to print the adjacency list
    public static void printAdjList(Map<Integer, List<Integer>> adjList) {
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Initialize the adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // Add edges (example)
        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 1, 3);

        // Print adjacency list
        printAdjList(adjList);
    }
}

