import java.util.ArrayList;

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

public class Graph03_DirectedCycleDetection {

    public static boolean isCycle(ArrayList<Edge>[] graph) {

        boolean[] visited = new boolean[graph.length]; // store which node we visited
        boolean[] callStack = new boolean[graph.length]; // use as a stack

        for (int i = 0; i < graph.length; i++) {
            // if we don't visit i'th node we must visit it
            if (!visited[i]) {
                // cycle detection
                if (isCycleUtil(graph, i, visited, callStack))
                    return true;
            }
        }

        return false;

    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int idx, boolean[] visited, boolean[] callStack) {
        // make both true...cause we are here
        visited[idx] = true;
        callStack[idx] = true;

        for (int i = 0; i < graph[idx].size(); i++) {

            Edge e = graph[idx].get(i);
            // next node is already true .....
            if (callStack[e.destination]) {
                return true; // ..... then cycle is exists
            }
            //
            else if (!visited[e.destination] && isCycleUtil(graph, e.destination, visited, callStack)) {
                return true;
            }
        }

        // after ending all remove it from stack
        callStack[idx] = false;
        return false;
    }

    private static ArrayList<Edge>[] create1() {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // // 0 vertex
        // graph[0].add(new Edge(0, 1));
        // // 1 vertex
        // graph[1].add(new Edge(1, 3));
        // // 2 vertex
        // graph[2].add(new Edge(2, 0));
        // // 3 vertex
        // graph[3].add(new Edge(3, 2));
        //

        // 0 vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        // 1 vertex
        graph[1].add(new Edge(1, 3));
        // 2 vertex
        graph[2].add(new Edge(2, 3));
        // 3 vertex
        // graph[3].add(new Edge(3, 2));

        return graph;
    }

    public static void main(String[] args) {

        ArrayList<Edge>[] graph = create1();

        System.out.println(isCycle(graph));

    }
}
