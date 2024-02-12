/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Array46_LongestConsecutiveSequence {

    public static int longestConsecutive_bruteForce(int[] arr) { //TC -> O(n*log(n)) || SC -> O(1)
        Arrays.sort(arr);

        int len = 0, longest = 0, lastSmallest = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i]-1 == lastSmallest) {
                lastSmallest = arr[i];
                len += 1;
            } else if(arr[i] != lastSmallest) {
                lastSmallest = arr[i];
                len = 1;
            }

            if(longest<len) {
                longest = len;
            }
        }

        return longest;
    }

    public static int longestConsecutive(int[] arr) {   //TC -> O(2n) || SC -> O(n)
        Set<Integer> set = new HashSet<>();
        int len = 0, longest = 0;

        for(int x: arr) {
            set.add(x);
        }

        for(int i: set) {
            if(!set.contains(i-1)) {
                int x = i;
                len = 1;
                while(set.contains(x+1)) {
                    x++;
                    len++;
                }

                if(longest < len) {
                    longest = len;
                }
            }
        }

        return longest;
    }
    public static void main(String[] args) {
        int[] arr1 = {13,3,10,7,2,12,16,4,9,15,14};
        int[] arr3 = {1,2,3,4,7,8,9,10,11};
        int[] arr4 = {0,3,7,2,5,8,4,6,0,1};
        int[] arr5 = {100,4,200,1,3,2};
        
        System.out.println(longestConsecutive(arr1));
    }
}
