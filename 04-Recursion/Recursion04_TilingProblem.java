/*
floor size is 2xn and tile size is 2x1....find out the number ways to fit the tiles in the floor
 */

public class Recursion04_TilingProblem {

    public static int totalWays(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        return totalWays(n-1) + totalWays(n-2);
    }

    public static void main(String[] args) {
        System.out.println(totalWays(5));
    }
}
