import java.util.*;

class Graph {
    private int V;
    private List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public int getVerticesCount() {
        return V;
    }

    public List<List<Integer>> getAdjacencyList() {
        return adj;
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }
}

public class DFSTopologicalSort {

    private boolean[] visited;
    private Stack<Integer> stack;

     public List<Integer> topoSort(Graph graph) {
        int V = graph.getVerticesCount();
        List<List<Integer>> adj = graph.getAdjacencyList();

        initialize(V);
        performDFS(adj, V);
        return getTopologicalOrder();
    }


    // Step 1 : initialize stack
    private void initialize(int V) {
        visited = new boolean[V];
        stack = new Stack<>();
    }

   
    // Step 2: Perform DFS of the entire graph
    private void performDFS(List<List<Integer>> adj, int V) {
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj);
            }
        }
    }

   // Step 2a: Perform DFS for each node
    private void dfs(int u, List<List<Integer>> adj) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj);
            }
        }
        stack.push(u);
    }


    /* Step 3:  Extracts the topological order from the stack.
     * 
     * After performing DFS on all vertices, the stack contains
     * the vertices in reverse topological order (i.e., the vertex
     * that should come last in the topological sort is on top of the stack).
     * 
     * This method pops all elements from the stack and adds them to a list,
     * which represents the correct topological ordering.
     * 
     * @return List<Integer> containing the vertices in topological order
     */
    private List<Integer> getTopologicalOrder() {
        List<Integer> topoOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            topoOrder.add(stack.pop());
        }
        return topoOrder;
    }

   
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        DFSTopologicalSort topoSort = new DFSTopologicalSort();
        List<Integer> result = topoSort.topoSort(graph);

        System.out.println("Topological Sort using DFS (Modular):");
        for (int node : result) {
            System.out.print(node + " ");
        }
    }
}
