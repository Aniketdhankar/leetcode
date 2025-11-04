import java.util.*;

public class Graph {
    private List<Integer>[] graph;

    Graph(int num) {
        graph = new ArrayList[num];
        for (int i = 0; i < num; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    void addEdge(int v, int u) {
        graph[v].add(u);
        graph[u].add(v);
    }

    void printGraph() {
        for (int i = 0; i < graph.length; i++) {
            System.out.println(i + " -> " + graph[i]);
        }
    }

    // BFS
    void bfs(int start) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new ArrayDeque<>();   // ✅ normal queue

        q.add(start);
        visited[start] = true;

        System.out.print("BFS: ");
        while(!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for(int neigh : graph[curr]){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    q.add(neigh);
                }
            }
        }
        System.out.println();
    }

    // DFS recursive
    void dfs(int start) {
        boolean[] visited = new boolean[graph.length];
        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    void dfsHelper(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for(int neigh : graph[node]){
            if(!visited[neigh]){
                dfsHelper(neigh, visited);
            }
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
        g.bfs(0);
        g.dfs(0);
    }
}
