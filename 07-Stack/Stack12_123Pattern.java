/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 

Constraints:

n == nums.length
1 <= n <= 2 * 105
-109 <= nums[i] <= 109
 */

import java.util.Stack;

public class Stack12_123Pattern {

    public static boolean find123pattern(int[] arr) {
        // corner case -> can't possible to create 132 pattern
        if (arr.length < 3)
            return false;

        Stack<Integer> stk = new Stack<>();
        int third = Integer.MIN_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {

            // if(third > first)
            if (third > arr[i])
                return true;

            // (stack is not empty) AND (second > third)
            while (!stk.isEmpty() && arr[i] > stk.peek())
                third = stk.pop(); // getting third value

            // push current value into stack
            stk.push(arr[i]);
        }

        return false;
    }

    // brute force -> only for limited size of array
    // public static boolean find132pattern(int[] arr) {

    // int min = Integer.MAX_VALUE;

    // for (int i = 0; i < arr.length - 1; i++) {

    // min = Math.min(min, arr[i]);
    // for (int j = i + 1; j < arr.length; j++) {
    // if (arr[j] < arr[i] && min < arr[j]) {
    // return true;
    // }
    // }

    // }
    // return false;
    // }

    public static void main(String[] args) {
        int[] arr1 = { 1, -1, 6, 3, -7, 10, 2 };
        int[] arr2 = { 3, 1, 4, 2 };
    }
}
