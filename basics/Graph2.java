import java.util.*;
public class Graph2 {
    class Edge {
        int src, dest;
        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    private List<Edge>[] edges;  // ✅ List of edges

    Graph2(int vertices) {
        edges = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            edges[i] = new ArrayList<>();
        }
    }
    void addEdge(int v, int u) {
        edges[v].add(new Edge(v, u));
        edges[u].add(new Edge(u, v));  // undirected graph
    }
    void printGraph() {
        for (int i = 0; i < edges.length; i++) {
            System.out.print(i + " -> ");
            for (Edge edge : edges[i]) {
                System.out.print("[" + edge.src + "->" + edge.dest + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph2 g = new Graph2(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 4);
        g.addEdge(1, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        g.printGraph();
    }

}
