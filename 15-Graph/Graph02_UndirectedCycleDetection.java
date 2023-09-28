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

public class Graph02_UndirectedCycleDetection {

    public static boolean detectCycle(ArrayList<Edge>[] graph, int V) { // TC -> O(V+E)
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, visited, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, int parent) {
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // case 1 -> neighbor is not visited --> so visit neighbor and check for cycle
            if (!visited[e.destination]) {
                if (detectCycleUtil(graph, visited, e.destination, curr)) {
                    return true;
                }
            }
            // case 2 -> neighbor is visited and it's not a parent --> so loop exist
            else if (visited[e.destination] && e.destination != parent) {
                return true;
            }
            // case - 3 -> neighbor is visited and it's a parent --> so just continue

        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // 1 vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // 2 vertex
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // 3 vertex
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        // 4 vertex
        graph[4].add(new Edge(4, 3));

        System.out.println(detectCycle(graph, V));
    }
}
