import java.util.*;
public class Graph2 {

    class Edge {
        int src, dest;
        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    private List<Edge>[] edges;

    Graph2(int vertices) {
        edges = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            edges[i] = new ArrayList<>();
        }
    }

    void addEdge(int v, int u) {
        edges[v].add(new Edge(v, u));
        edges[u].add(new Edge(u, v));  // undirected
    }

    void printGraph() {
        for (int i = 0; i < edges.length; i++) {
            System.out.print(i + " -> ");
            for (Edge e : edges[i]) {
                System.out.print("[" + e.src + "->" + e.dest + "] ");
            }
            System.out.println();
        }
    }

    // BFS
    void bfs(int start) {
        boolean[] visited = new boolean[edges.length];
        Queue<Integer> q = new ArrayDeque<>();

        q.add(start);
        visited[start] = true;

        System.out.print("BFS: ");
        while(!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (Edge e : edges[curr]) {
                if(!visited[e.dest]) {
                    visited[e.dest] = true;
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    // DFS recursive
    void dfs(int start) {
        boolean[] visited = new boolean[edges.length];
        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    void dfsHelper(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for(Edge e : edges[node]) {
            if(!visited[e.dest]) {
                dfsHelper(e.dest, visited);
            }
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
        g.bfs(0);   // call bfs
        g.dfs(0);   // call dfs
    }

}
