import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Edge {

    int source;
    int destination;
    // int weight;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
        // this.weight = weight;
    }
}

public class Graph04_BipartiteGraph {

    public static boolean isBipartite(ArrayList<Edge>[] graph) { // TC -> O(V+E)
        int[] color = new int[graph.length];
        // first every vertex have no color
        for (int i = 0; i < color.length; i++) {
            color[i] = -1; // no color
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {

            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;// color-zero

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        if (color[e.destination] == -1) {
                            color[e.destination] = color[curr] == 0 ? 1 : 0;
                            q.add(e.destination);
                        } else if (color[e.destination] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;

    }

    private static ArrayList<Edge>[] create1() {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        // 1 vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        // 2 vertex
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        // 3 vertex
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        // 4 vertex
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));

        return graph;
    }

    private static ArrayList<Edge>[] create2() {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        // 1 vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        // 2 vertex
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));
        // 3 vertex
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

        return graph;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = create2();

        System.out.println(isBipartite(graph));
    }
}
