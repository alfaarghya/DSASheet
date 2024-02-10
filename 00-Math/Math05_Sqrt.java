/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

Example 1:
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 

Constraints:

0 <= x <= 231 - 1
 */

public class Math05_Sqrt {

    public static int mySqrt(int x) {
        if(x == 0 || x == 1) {
            return x;
        }

        int start = 1, end = x;
        int mid = 0;

        while(start <= end) {
            mid = start + (end-start)/2;

            if(mid * mid == x) {
                return mid;
            } else if((long)mid * mid > x) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        
        return end;

    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(13));
        System.out.println(mySqrt(50));
    }
}
