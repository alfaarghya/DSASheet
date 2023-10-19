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

public class Implement_BellmanFordAlgorithm {

    public static void bellmanFord(ArrayList<Edge>[] graph, int src) { // TC -> O(V*E)
        int[] distance = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        // algorithm - O(V)
        int V = graph.length;
        for (int i = 0; i < V - 1; i++) {
            // Edges - O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.source;
                    int v = e.destination;
                    int wt = e.weight;

                    // relaxation
                    if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                        distance[v] = distance[u] + wt;
                    }
                }
            }
        }

        // print
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    public static ArrayList<Edge>[] create() {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // 1 vertex
        graph[1].add(new Edge(1, 2, -4));

        // 2 vertex
        graph[2].add(new Edge(2, 3, 2));

        // 3 vertex
        graph[3].add(new Edge(3, 4, 4));

        // 4 vertex
        graph[4].add(new Edge(4, 1, -1));

        return graph;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = create();
        int src = 0;
        bellmanFord(graph, src);
    }
}
