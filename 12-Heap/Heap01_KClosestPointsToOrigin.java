/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

Example 1:
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.

Example 2:
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 */

import java.util.PriorityQueue;

public class Heap01_KClosestPointsToOrigin {
    /* ------ Brute force ------
    public static void kNearbyPoints(int[][] points, int k) { //TC -> O(n log n)
        int[] ans = new int[points.length];

        for(int i = 0; i < points.length; i++) {
            ans[i] = points[i][0]*points[i][0] + points[i][1]*points[i][1];
        }

        Arrays.sort(ans);
        System.out.println("----------------");
        for(int i = 0; i < k; i++) {
            System.out.print(ans[i] + " ");
        }

    } */

    static class Point implements Comparable<Point> {
        int x, y;//coordinates 
        int distSq;
        int index;
            //Constructor
        public Point(int x, int y, int distSq, int index) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.index = index;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq; //ascending order sorting
        }
    }

    public static void kClosest(int[][] points, int k) {    //TC -> O(n log(n)) || SC -> O(n)
            //initialize a Priority Queue
        PriorityQueue<Point> pq = new PriorityQueue<>();

            //run a loop and calculate distance from origin and store into PQ 
        for(int i = 0; i < points.length; i++) {
            int distSq = points[i][0]*points[i][0] + points[i][1]*points[i][1]; //distance from origin to point
            pq.add(new Point(points[i][0], points[i][1], distSq, i));
        }
            //run a loop and remove elements from PQ and store into ans
        for(int i = 0; i < k; i++) {
            System.out.println("P"+pq.remove().index);
        }
    }

    public static void main(String[] args) {
     int[][] points = {{3,3},{5,-1},{-2,4}};
     int k = 2;

     kClosest(points, k);
    }
}
