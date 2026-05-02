import java.util.ArrayList;
import java.util.List;

public class CyclesInDirectedGraph {

    // Nested Graph class: data structure only
    class Graph {
        private final int V;
        private final List<List<Integer>> adj;

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int dest) {
            adj.get(source).add(dest);
        }

        public int getVertexCount() {
            return V;
        }

        public List<Integer> getAdjList(int vertex) {
            return adj.get(vertex);
        }
    }

    // isCyclic logic now lives in the outer class
    public boolean isCyclic(Graph graph) 
    {
        int V = graph.getVertexCount();

        boolean[] visited = new boolean[V];
        boolean[] nodesInPath = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (isCyclicUtil(i, visited, nodesInPath, graph))
            {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack, Graph graph) {
        if (recStack[v])
            return true;

        if (visited[v])
            return false;

        visited[v] = true;
        recStack[v] = true;

        for (Integer neighbor : graph.getAdjList(v)) {
            if (isCyclicUtil(neighbor, visited, recStack, graph))
                return true;
        }

        recStack[v] = false;
        return false;
    }

    // Driver code
    public static void main(String[] args) {

        CyclesInDirectedGraph cyclesInDirectedGraph = new CyclesInDirectedGraph();
        Graph graph= cyclesInDirectedGraph.new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        boolean isCyclic = cyclesInDirectedGraph.isCyclic(graph);
        if (isCyclic){
            System.out.println("Graph contains cycle");
        }
        else{
            System.out.println("Graph doesn't contain cycle");
        }
    }
}
