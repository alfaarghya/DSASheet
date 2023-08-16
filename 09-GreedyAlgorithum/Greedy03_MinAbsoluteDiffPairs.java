/*
Given two arrays A & B equal length n, Pair each element of array A to array element in array B, such that sum of absolute differences of all the pairs in minimum.
 
Example 1:
    input --> A = [1,2,3], B = [2,3,1]
    output --> 0

Example 2:
    input --> A = [4,1,8,7], B = [2,3,6,5]
    output --> 6
 */

import java.sql.Array;
import java.util.Arrays;

public class Greedy03_MinAbsoluteDiffPairs {

    public static int minimumAbsoluteDiff(int[] A, int[] B) {   //TC -> O(n*log(n)) || SC -> O(1)
            //sort both array to get actual solution
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiffSum = 0;
        for(int i = 0; i < A.length; i++) {
            minDiffSum += Math.abs(A[i]-B[i]);
        }

        return minDiffSum;
    }

    public static void main(String[] args) {
        int[] A = {4,1,8,7};
        int[] B = {2,3,6,5};

        System.out.println(minimumAbsoluteDiff(A, B));
    }
}
