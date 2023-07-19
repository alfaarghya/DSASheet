/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:

Input: candidates = [2], target = 1
Output: []

Constraints:

    1 <= candidates.length <= 30
    2 <= candidates[i] <= 40
    All elements of candidates are distinct.
    1 <= target <= 40


 */

import java.util.ArrayList;
import java.util.List;

public class Backtracking06_CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        combination(candidates, target, 0, sum, ans);
        return ans;
    }

    public static void combination(int[] candidates, int target, int idx, List<Integer> sum, List<List<Integer>> ans) {
            //base case
        if(idx == candidates.length) {
            return;
        }
        if(target == 0) {    //we find out the combination
            // System.out.println(sum);
            ans.add(new ArrayList<>(sum));
            return;
        }

            //logic
        if(candidates[idx] <= target) { //Pick up the element
            sum.add(candidates[idx]);
            combination(candidates, target-candidates[idx], idx, sum, ans); //only reduce the target
            sum.remove(sum.size()-1);
        }

        combination(candidates, target, idx+1, sum, ans);   //not picking up any element --> but increase the index number
        return;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;

        System.out.println(combinationSum(arr, target));

    }
}
