
/*
You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

 
Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.

Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1

Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
1 <= x <= 109
 */
import java.util.HashMap;

public class Hash04_MinimumOperationsToReduceXToZero {

    public static int minOperations(int[] nums, int x) { // TC -> O(n) || SC -> O(n)

        // initialize
        HashMap<Integer, Integer> map = new HashMap<>(); // prefixSum , index
        map.put(0, -1); // base condition
        int prefixSum = 0;
        int target = 0;
        int maxLen = Integer.MIN_VALUE;
        int n = nums.length;

        // calculate total sum & populate map with sum and index
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            map.put(prefixSum, i);
        }

        target = prefixSum - x; // totalSum - x
        if (target < 0) { // x value is not possible
            return -1;
        }
        if (target == 0) { // x is total sum of array
            return n;
        }

        prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            // calculate max length of sub-array for which x value will be 0
            if (map.containsKey(prefixSum - target)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - target));
            }
        }

        /*
         * if (maxLen is same as previous) no combination possible means -1
         * else n-maxLen
         */
        return maxLen == Integer.MIN_VALUE ? -1 : n - maxLen;
    }

    public static void main(String[] args) {

        int[] arr1 = { 3, 2, 20, 1, 1, 3 }; // x = 10
        int[] arr2 = { 5, 6, 7, 8, 9 }; // x = 4
        int[] arr3 = { 1, 1, 4, 2, 3 }; // x = 5

        System.out.println(minOperations(arr3, 5));

    }
}