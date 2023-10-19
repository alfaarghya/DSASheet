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

public class Implement_DijkstraAlgorithm {

    static class Pair implements Comparable<Pair> {
        int vertex, path;

        public Pair(int vertex, int path) {
            this.vertex = vertex;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; // ascending sort based on path
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) { // TC -> O(V + E * log(V))

        int distance[] = new int[graph.length];// store minimum distance from src
        boolean visited[] = new boolean[graph.length];// store minimum distance from src
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                distance[i] = Integer.MAX_VALUE; // infinity
            }
        }

        pq.add(new Pair(src, 0));// source
        // BFS-loop
        while (!pq.isEmpty()) {

            Pair curr = pq.remove();
            // only for not visited
            if (!visited[curr.vertex]) {
                visited[curr.vertex] = true;

                for (int i = 0; i < graph[curr.vertex].size(); i++) {

                    Edge e = graph[curr.vertex].get(i);
                    int u = e.source;
                    int v = e.destination;
                    int wt = e.weight;

                    if (distance[u] + wt < distance[v]) {

                        distance[v] = distance[u] + wt;// get the minimum path or distance
                        pq.add(new Pair(v, distance[v]));

                    }
                }
            }
        }

        // print all source to vertices shortest distance
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    public static ArrayList<Edge>[] create() {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // 1 vertex
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        // 2 vertex
        graph[2].add(new Edge(2, 4, 3));
        graph[2].add(new Edge(2, 4, 3));

        // 3 vertex
        graph[3].add(new Edge(3, 5, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        // 5 vertex

        return graph;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = create();
        int src = 0;
        dijkstra(graph, src);
    }
}
