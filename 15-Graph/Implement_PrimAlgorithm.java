import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class Implement_PrimAlgorithm {

    static class Pair implements Comparable<Pair> {
        int srcVertex, destVertex, cost;

        public Pair(int srcVertex, int destVertex, int cost) {
            this.srcVertex = srcVertex;
            this.destVertex = destVertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;// ascending
        }
    }

    public static void primAlgo(ArrayList<Edge>[] graph, int src) {
        boolean[] visited = new boolean[graph.length];
        ArrayList<Edge> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, src, 0));// source cost is 0(zero)
        int finalCost = 0;// MST cost or total min weight

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            // current vertex is not visited
            if (!visited[curr.destVertex]) {
                visited[curr.destVertex] = true;// visit the vertex

                finalCost += curr.cost;// calculate MST cost
                ans.add(new Edge(curr.srcVertex, curr.destVertex, curr.cost));// MST graph

                for (int i = 0; i < graph[curr.destVertex].size(); i++) {
                    Edge e = graph[curr.destVertex].get(i);
                    pq.add(new Pair(e.source, e.destination, e.weight));
                }
            }
        }

        // MST cost
        System.out.println("MST cost -> " + finalCost);

        System.out.println("----- MST Graph ----");
        System.out.println("s d wt");
        // graph edges for MST
        for (int i = 0; i < ans.size(); i++) {
            Edge e = ans.get(i);
            System.out.println(e.source + " " + e.destination + " " + e.weight);
        }
    }

    public static ArrayList<Edge>[] create() {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 30));
        graph[0].add(new Edge(0, 2, 15));

        // 1 vertex
        graph[1].add(new Edge(1, 3, 40));

        // 2 vertex
        graph[2].add(new Edge(2, 3, 50));

        // 3 vertex

        return graph;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = create();
        int src = 0;
        primAlgo(graph, src);
    }
}