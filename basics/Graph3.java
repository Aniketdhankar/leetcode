import java.util.*;
public class Graph3 {
    Map<Integer,List<Integer>> adjList;

    Graph3() {
        adjList = new HashMap<>();
    }

    void addEdge(int src,int dest){
        if(!adjList.containsKey(src)){
            adjList.put(src,new ArrayList<>());
        }
        adjList.get(src).add(dest);
    }

    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // BFS
    void bfs(int start){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();

        q.add(start);
        visited.add(start);

        System.out.print("BFS: ");
        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr + " ");

            if(adjList.containsKey(curr)){
                for(int neigh : adjList.get(curr)){
                    if(!visited.contains(neigh)){
                        visited.add(neigh);
                        q.add(neigh);
                    }
                }
            }
        }
        System.out.println();
    }

    // DFS
    void dfs(int start){
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    void dfsHelper(int node, Set<Integer> visited){
        visited.add(node);
        System.out.print(node + " ");
        if(adjList.containsKey(node)){
            for(int neigh : adjList.get(node)){
                if(!visited.contains(neigh)){
                    dfsHelper(neigh, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph3 g = new Graph3();
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
