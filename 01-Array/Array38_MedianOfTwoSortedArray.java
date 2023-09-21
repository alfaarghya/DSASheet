/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 
Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */

import java.util.ArrayList;

public class Array38_MedianOfTwoSortedArray {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        marge(arr, nums1, nums2);
        System.out.println(arr);

        if (arr.size() % 2 != 0) {
            return arr.get(arr.size() / 2);
        } else {
            double median = (double) (arr.get(arr.size() / 2) + arr.get((arr.size() / 2) - 1)) / 2;
            return median;

        }
    }

    private static void marge(ArrayList<Integer> arr, int[] nums1, int[] nums2) {

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                arr.add(nums1[i]);
                i++;
            } else {
                arr.add(nums2[j]);
                j++;
            }
        }

        while (i < nums1.length) {
            arr.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            arr.add(nums2[j]);
            j++;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 6, 8, 9 };
        int[] arr2 = { 2, 4, 5, 7, 10, 11 };
        // 1,2,4,5,6,7,8,9,10,11

        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
