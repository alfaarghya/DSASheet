
/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]
 

Constraints:
1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 

Follow up: Could you solve the problem in linear time and in O(1) space?
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Hash01_MajorityElementII {

    public static List<Integer> majorityElement(int[] nums) { // TC -> O(n) || Sc -> O(n)
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        // Implement HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();

        // run a loop and calculate frequency of each number
        for (int i = 0; i < n; i++) {
            int key = nums[i];
            if (hm.containsKey(key)) { // found key again
                hm.put(key, hm.get(key) + 1); // increase frequency
            } else {
                hm.put(key, 1); // first time encounter with key....so frequency will be 1
            }
        }

        // check if there are any number which frequency is greater than n/3
        for (Integer i : hm.keySet()) {
            if (hm.get(i) > n / 3) {
                ans.add(i);
            }
        }

        // result
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };

        System.out.println(majorityElement(nums));
    }
}
