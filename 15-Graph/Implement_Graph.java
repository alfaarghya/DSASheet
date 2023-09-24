import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

public class Implement_Graph {

    public static List<Integer> BFS(ArrayList<Edge>[] graph, int V) {
        List<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];

        q.add(0); // start from 0

        while (!q.isEmpty()) {
            int removeVal = q.remove();

            if (!visited[removeVal]) {
                ans.add(removeVal);
                visited[removeVal] = true;

                for (int i = 0; i < graph[removeVal].size(); i++) {
                    Edge e = graph[removeVal].get(i);
                    q.add(e.destination);
                }
            }
        }

        return ans;

    }

    public static void DFS(ArrayList<Edge>[] graph, int curr, boolean[] visited, List<Integer> ans) {

        // visit
        ans.add(curr);
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.destination]) {
                DFS(graph, e.destination, visited, ans);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        // 1 vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        // 2 vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        // 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        // 4 vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        // 5 vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        // 6 vertex
        graph[6].add(new Edge(6, 5, 1));

        // 2's neighbor
        // for (int i = 0; i < graph[5].size(); i++) {
        // Edge e = graph[5].get(i);
        // System.out.print(e.source + " " + e.destination + " " + e.weight + "\n");

        // }

        System.out.println(BFS(graph, V));

        List<Integer> ans = new ArrayList<>();
        DFS(graph, 0, new boolean[V], ans);
        System.err.println(ans);

    }
}