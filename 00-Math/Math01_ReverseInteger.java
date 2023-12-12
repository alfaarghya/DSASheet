/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21
 
Constraints:

-231 <= x <= 231 - 1
 */
public class Math01_ReverseInteger {
    public static int reverse(int x) { // TC -> O(n) || SC -> O(n)
        long ans = 0;
        int rem = 0;

        // reverse method
        while (x != 0) {
            rem = x % 10;
            ans = ans * 10 + rem;
            x /= 10;
        }

        // answer accptance
        if (ans < Math.pow(-2, 31) || ans > Math.pow(2, 31)) {
            return 0;
        }

        // answer
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(000));
        System.out.println(reverse(120));
    }
}