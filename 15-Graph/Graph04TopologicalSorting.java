import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
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

public class Graph04TopologicalSorting {

    public static List<Integer> topologicalSort_DFS(ArrayList<Edge>[] graph) { // TC -> O(V+E)
        // storing sorting value
        List<Integer> ans = new ArrayList<>();

        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stk = new Stack<>();

        // for each graph component
        for (int i = 0; i < graph.length; i++) {
            // i'th vertex is not visited....
            if (!visited[i]) {
                topologicalSortUtil_DFS(graph, i, visited, stk); // ...then visit is
            }
        }

        while (!stk.isEmpty()) {
            ans.add(stk.pop());
        }

        return ans;
    }

    public static List<Integer> topologicalSort_BFS(ArrayList<Edge>[] graph) { // TC -> O(V+E)
        List<Integer> ans = new ArrayList<>();// output

        int[] inDeg = calcInDeg(graph);
        Queue<Integer> q = new LinkedList<>();

        // run a loop to find 0 in-degree vertex
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        // BFS
        while (!q.isEmpty()) {
            // output-value
            int curr = q.remove();
            ans.add(curr);

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDeg[e.destination]--;// reduce in-degree
                // if in-degree is 0....
                if (inDeg[e.destination] == 0) {
                    q.add(e.destination); // ... then only add
                }
            }
        }

        return ans;
    }

    public static void topologicalSortUtil_DFS(ArrayList<Edge>[] graph, int idx, boolean[] visited,
            Stack<Integer> stk) {
        visited[idx] = true; // we are on current vertex... so we visited it

        for (int i = 0; i < graph[idx].size(); i++) {
            Edge e = graph[idx].get(i); // get the edge

            // if we don't visit next vertex of current vertex......
            if (!visited[e.destination]) {
                topologicalSortUtil_DFS(graph, e.destination, visited, stk); // .....then visit it
            }
        }
        // ... otherwise push it in stack
        stk.push(idx);

    }

    private static int[] calcInDeg(ArrayList<Edge>[] graph) {
        int[] inDeg = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDeg[e.destination]++;
            }
        }

        return inDeg;
    }

    private static ArrayList<Edge>[] create1() {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex

        // 1 vertex

        // 2 vertex
        graph[2].add(new Edge(2, 3));
        // 3 vertex
        graph[3].add(new Edge(3, 1));
        // 4 vertex
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        // 5 vertex
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        return graph;
    }

    public static void main(String[] args) {

        ArrayList<Edge>[] graph = create1();

        System.out.println(topologicalSort_DFS(graph));
        System.out.println(topologicalSort_BFS(graph));

    }
}
