import java.util.*;

class Graph_WithAdjMatrix {

    private int[][] adjacencyMatrix;
    private int vertices;

    public Graph_WithAdjMatrix(int[][] matrix) {
        this.vertices = matrix.length;
        this.adjacencyMatrix = matrix;
    }

    public int getVertices() {
        return vertices;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

     // Print the adjacency matrix of the graph
    public void printGraph() {
        System.out.println("Adjacency Matrix of the Graph:");
        System.out.print("     ");
        for (int i = 0; i < vertices; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();
        System.out.println("    " + "-".repeat(4 * vertices));

        for (int i = 0; i < vertices; i++) {
            System.out.printf("%2d |", i);
            for (int j = 0; j < vertices; j++) {
                System.out.printf("%4d", adjacencyMatrix[i][j]);
            }
            System.out.println();
        }
    }
}

public class Dijkstra_ShortestPathGraph {

    private int minDistance(int[] dist, boolean[] shortestPathTreeSet, int V) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!shortestPathTreeSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public void dijkstra(Graph_WithAdjMatrix graph, int src) {
        int V = graph.getVertices();
        int[][] adjMatrix = graph.getAdjacencyMatrix();

        int[] distances = new int[V];
        boolean[] shortestPathTreeSet = new boolean[V];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(distances, shortestPathTreeSet, V);
            shortestPathTreeSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!shortestPathTreeSet[v] && adjMatrix[u][v] != 0 &&
                    distances[u] != Integer.MAX_VALUE &&
                    distances[u] + adjMatrix[u][v] < distances[v]) {
                    distances[v] = distances[u] + adjMatrix[u][v];
                }
            }
        }

        printSolution(distances);
    }

    private void printSolution(int[] dist) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };

        Graph_WithAdjMatrix graph = new Graph_WithAdjMatrix(matrix);
        graph.printGraph();  // <-- Print the adjacency matrix

        Dijkstra_ShortestPathGraph dsp = new Dijkstra_ShortestPathGraph();
        dsp.dijkstra(graph, 0);
    }
}
