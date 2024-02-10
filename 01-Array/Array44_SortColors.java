/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 */

public class Array44_SortColors {
    public static void sortColors(int[] arr) {  //tc -> O(n) || SC -> O(1)
        int start = 0, end = arr.length - 1;
        int i = 0;
 
        while(i <= end) {
            if(arr[i] == 0) {
                swap(arr, i++, start++);
            } else if(arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, end--);
            }
        } 
     }
 
     public static void swap(int[] arr, int i, int j) {
         int temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
     }
    public static void main(String[] args) {
        
    }
}
