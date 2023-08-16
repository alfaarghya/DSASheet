/*
You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti. A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion. Return the length longest chain which can be formed.
You do not need to use up all the given intervals. You can select pairs in any order.

 

Example 1:
Input: pairs = [[1,2],[2,3],[3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4].

Example 2:
Input: pairs = [[1,2],[7,8],[4,5]]
Output: 3
Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].

Constraints:
n == pairs.length
1 <= n <= 1000
-1000 <= lefti < righti <= 1000
 */

import java.util.Arrays;
import java.util.Comparator;

public class Greedy04_MaxLengthChain {

    public static int maxLengthChain(int[][] arr) {
            //sort according to 
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;
        int chainEnd = arr[0][1];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i][0] >= chainEnd) {
                chainLen++;
                chainEnd = arr[i][1];
            }
        }

        return chainLen;
    }

    public static void main(String[] args) {
        int[][] pair = {{5,24},{39,60},{5,28},{27,40},{50,90}};

        System.out.println(maxLengthChain(pair));
    }
}
