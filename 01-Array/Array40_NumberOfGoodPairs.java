/*
Given an array of integers nums, return the number of good pairs.
A pair (i, j) is called good if nums[i] == nums[j] and i < j.

 
Example 1:
Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

Example 2:
Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.

Example 3:
Input: nums = [1,2,3]
Output: 0
 
Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
 */

import java.util.HashMap;

public class Array40_NumberOfGoodPairs {

    public static int numIdenticalPairs(int[] nums) { // TC -> O(n) || SC -> O(n)
        int goodPairCount = 0; // count good pairs
        HashMap<Integer, Integer> map = new HashMap<>(); // key is array element & value is pair count

        // calculate good pair count
        for (int key : nums) {

            // if key is new value then count is 0.... else retrun count
            int tempCount = map.getOrDefault(key, 0);
            // increase goodPairCount by tempCount
            goodPairCount += tempCount;
            // if key is already seen then pair will be increase by 1
            map.put(key, tempCount + 1);

        }
        // end result
        return goodPairCount;
    }

    public static int numIdenticalPairs_BruteForce(int[] nums) { // TC -> O(n^2) || SC -> O(1)
        int goodPairCount = 0; // count good pairs

        // calculate good pair count
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    goodPairCount++;
                }
            }
        }

        // end result
        return goodPairCount == 0 ? 0 : goodPairCount;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 1, 1, 3 };
        int[] arr2 = { 1, 1, 1, 1 };
        int[] arr3 = { 1, 2, 3 };

        System.out.println(numIdenticalPairs(arr3));
        System.out.println(numIdenticalPairs_BruteForce(arr3));

    }
}
