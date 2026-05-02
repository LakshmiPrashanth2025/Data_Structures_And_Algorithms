import java.util.*;

public class DepthFirstTraversalIterative {

    static class Graph {
        private int vertices; // Number of vertices
        private ArrayList<Integer>[] adjList; // Adjacency list

        // Constructor
        @SuppressWarnings("unchecked")
        Graph(int v) {
            vertices = v;
            adjList = new ArrayList[v];
            for (int i = 0; i < v; ++i)
                adjList[i] = new ArrayList<>();
        }

        // Add edge
        void addEdge(int v, int w) {
            adjList[v].add(w); // Directed graph
        }

        // Iterative DFS
        void DFSIterative(int start) {

            boolean[] visitedNodes = new boolean[vertices];
            
            Stack<Integer> dfsTraversalStack = new Stack<>();

            dfsTraversalStack.push(start);

            while (!dfsTraversalStack.isEmpty()) {
                int v = dfsTraversalStack.pop();

                if (!visitedNodes[v]) {
                    System.out.print(v + " ");
                    visitedNodes[v] = true;
                }

                // Add neighbors in reverse order for consistent DFS behavior
                List<Integer> neighbors = adjList[v];
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visitedNodes[neighbor]) {
                        dfsTraversalStack.push(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);

        System.out.println("DFS (iterative) starting from node 0:");
        g.DFSIterative(0);
    }
}
