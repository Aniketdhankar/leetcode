import java.util.*;

public class Graph {
    private List<Integer>[] graph;  // ✅ Array of adjacency lists

    Graph(int num) {
        graph = new ArrayList[num];
        for (int i = 0; i < num; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    void addEdge(int v, int u) {
        graph[v].add(u);
        graph[u].add(v);  // undirected graph
    }

    void printGraph() {
        for (int i = 0; i < graph.length; i++) {
            System.out.println(i + " -> " + graph[i]);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 4);
        g.addEdge(1, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        g.printGraph();
    }
}
