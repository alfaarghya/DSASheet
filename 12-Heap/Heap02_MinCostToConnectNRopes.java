/*
GIven are N ropes of different lengths, the task is to connect these ropes into one ropw with minimum, such that cost to connect two ropes is equal to the sum of their lengths.
example1:
ropes = {4,3,2,6}
minimum cost = 29

example2:
ropes = {2,3,3,4,6}
minimum cost = 41
 */

import java.util.PriorityQueue;

public class Heap02_MinCostToConnectNRopes { // TC -> O(nlogn) || SC -> O(n)

    public static int minCost(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add all rope length into PQ
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        // run a loop and calculate minimum cost
        int minCost = 0;
        while (pq.size() > 1) {
            int val1 = pq.remove();
            int val2 = pq.remove();
            minCost += val1 + val2;
            pq.add(val1 + val2);
        }

        return minCost;

    }

    public static void main(String[] args) {
        int[] ropes = { 3, 2, 4, 6, 3 };

        System.out.println(minCost(ropes));
    }
}
