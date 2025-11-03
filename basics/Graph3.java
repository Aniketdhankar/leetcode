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
    public static void main(String[] args) {
        Graph3 g = new Graph3();
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 4);
        g.addEdge(1, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        g.printGraph();
    }
    
}
