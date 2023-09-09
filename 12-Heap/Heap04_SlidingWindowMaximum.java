/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */

import java.util.PriorityQueue;

public class Heap04_SlidingWindowMaximum {

    static class Window implements Comparable<Window> {
        int val;
        int index;

        public Window(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Window w) {
            return w.val - this.val; // descending order
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) { // TC -> O(n log(k)) || Tc -> O(n)
        int[] ans = new int[nums.length - k + 1];
        // Construct a MaxHeap
        PriorityQueue<Window> pq = new PriorityQueue<>();

        // first window
        for (int i = 0; i < k; i++) {
            pq.add(new Window(nums[i], i));
        }
        // first max element
        ans[0] = pq.peek().val;

        // run a loop and calculate max element in every window
        for (int i = k; i < nums.length; i++) {
            // remove elements from front if it's not in current window
            while (pq.size() > 0 && pq.peek().index <= (i - k)) {
                pq.remove();
            }
            pq.add(new Window(nums[i], i));
            ans[i - k + 1] = pq.peek().val;
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
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        printArray(maxSlidingWindow(nums, k));
    }
}
