/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */

public class Array36_FindFirstAndLastPosition {

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        ans[0] = firstPosition(nums, target);
        ans[1] = lastPosition(nums, target);

        return ans;
    }

    private static int firstPosition(int[] nums, int target) {
        int idx = -1;
        int startIdx = 0, endIdx = nums.length - 1;
        int midIdx = 0;

        while (startIdx <= endIdx) {
            midIdx = startIdx + (endIdx - startIdx) / 2;

            if (nums[midIdx] == target) {
                idx = midIdx;
            }

            if (nums[midIdx] >= target) {
                endIdx = midIdx - 1;
            } else {
                startIdx = midIdx + 1;
            }

        }

        return idx;
    }

    private static int lastPosition(int[] nums, int target) {
        int idx = -1;
        int startIdx = 0, endIdx = nums.length - 1;
        int midIdx = 0;

        while (startIdx <= endIdx) {
            midIdx = startIdx + (endIdx - startIdx) / 2;

            if (nums[midIdx] == target) {
                idx = midIdx;
            }

            if (nums[midIdx] <= target) {
                startIdx = midIdx + 1;

            } else {
                endIdx = midIdx - 1;
            }

        }

        return idx;
    }

    public static void main(String[] args) {
        int[] arr1 = { 5, 7, 7, 7, 7, 8, 9, 10, 10 };
        int target1 = 7;

        int[] arr2 = { 5, 7, 7, 7, 7, 8, 9, 10, 10 };
        int target2 = 10;

        int[] arr3 = { 5, 7, 7, 8, 8, 10 };
        int target3 = 8;

        int[] arr4 = { 5, 7, 7, 8, 8, 10 };
        int target4 = 7;

        int[] arr5 = { 5, 7, 7, 8, 8, 10 };
        int target5 = 11;

        int[] arr6 = {};
        int target6 = 11;

        int[] ans = searchRange(arr4, target4);
        System.out.println(ans[0] + " " + ans[1]);

    }
}
