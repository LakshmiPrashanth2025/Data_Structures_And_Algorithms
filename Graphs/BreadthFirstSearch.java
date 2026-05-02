import java.util.*;

public class BreadthFirstSearch {

    private int vertices; // Number of vertices
    private ArrayList<ArrayList<Integer>> adjList; // Adjacency list

    // Constructor
    public BreadthFirstSearch(int v) {
        vertices = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add an edge to the graph
    void addEdge(int v, int w) {
        adjList.get(v).add(w); // For directed graph
    }


    // BFS traversal from a given source node
    void BFS(int start)
    {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        BreadthFirstSearch graph = new BreadthFirstSearch(6); // 6 nodes: 0 to 5

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("Breadth First Search starting from node 0:");
        graph.BFS(0);
    }
}

