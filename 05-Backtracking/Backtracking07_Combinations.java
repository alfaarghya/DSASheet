/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 

Constraints:

1 <= n <= 20
1 <= k <= n
 */

import java.util.ArrayList;
import java.util.List;

public class Backtracking07_Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> helper = new ArrayList<>();
        findCombinations(1, n, k, ans, helper);
        return ans;
    }

    public static void findCombinations(int startVal, int n, int k, List<List<Integer>> ans, List<Integer> helper) {
            //base case
        if(helper.size() == k) {    //when size reache k
            ans.add(new ArrayList<>(helper));
            return;
        }

        for(int i = startVal; i <= n; i++) {
            helper.add(i);
            findCombinations(i+1, n, k, ans, helper);
            helper.remove(helper.size()-1); //backtracking step
        }
    }

    public static void main(String[] args) {
        int n = 7, k = 2;

        System.out.println(combine(n, k));
    }
}