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

public class Graph06_AllPathFromSrcToDes {

    // brute-force approach -> TC -> O(V^V)
    public static void printAllPath(ArrayList<Edge> graph[], int src, int dest, String path) {
        // base case -> current src is dest
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(graph, e.destination, dest, path + src);// recursive call
        }

    }

    private static ArrayList<Edge>[] create1() {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 3));
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
        int src = 5, des = 1;
        printAllPath(graph, src, des, "");
    }
}
