/*
You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

Example 1:

Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]
Explanation: 
The number of soldiers in each row is: 
- Row 0: 2 
- Row 1: 4 
- Row 2: 1 
- Row 3: 2 
- Row 4: 5 
The rows ordered from weakest to strongest are [2,0,3,1,4].

Example 2:
Input: mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
Output: [0,2]
Explanation: 
The number of soldiers in each row is: 
- Row 0: 1 
- Row 1: 4 
- Row 2: 1 
- Row 3: 1 
The rows ordered from weakest to strongest are [0,2,3,1].
 

Constraints:

m == mat.length
n == mat[i].length
2 <= n, m <= 100
1 <= k <= m
matrix[i][j] is either 0 or 1.
 */

import java.util.PriorityQueue;

public class Heap03_WeakestSoldier {

    static class Soldiers implements Comparable<Soldiers> {
        int soldiersCount;
        int index;

        public Soldiers(int soldiersCount, int index) {
            this.soldiersCount = soldiersCount;
            this.index = index;
        }

        @Override
        public int compareTo(Soldiers s) {
            if (this.soldiersCount == s.soldiersCount) // both row have same soldiers
                return this.index - s.index;
            else
                return this.soldiersCount - s.soldiersCount;
        }
    }

    public static int[] KWeakestSoldier(int[][] mat, int k) { // TC -> O(n^2) || SC -> O(n) ...... n = size of array
        int ans[] = new int[k];
        PriorityQueue<Soldiers> pq = new PriorityQueue<>();

        // run a loop & count the soldiers
        for (int i = 0; i < mat.length; i++) {
            int j = 0;
            int count = 0;
            while (j < mat[0].length && mat[i][j] != 0) {
                count++;
                j++;
            }

            pq.add(new Soldiers(count, i)); // store into PQ in ascending order
        }

        // remove only k elements
        for (int i = 0; i < k; i++) {
            ans[i] = pq.remove().index;
        }

        return ans;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[][] mat1 = { { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 } };

        int k1 = 2;
        printArray(KWeakestSoldier(mat1, k1));

        int[][] mat2 = { { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 1 } };

        int k2 = 3;
        printArray(KWeakestSoldier(mat2, k2));

    }
}
