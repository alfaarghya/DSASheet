public class DP02_ClimbingStairs {

    // recursive method -- TC -> O(2^n)
    public static int climb(int n) {

        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        return climb(n - 1) + climb(n - 2);
    }

    // memoization -- TC -> O(n) || SC -> O(n)
    public static int climbMemoization(int n, int[] dp) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = climbMemoization(n - 1, dp) + climbMemoization(n - 2, dp);
        return dp[n];
    }

    // DP-tabulation -- TC -> O(n) || SC -> O(n)
    public static int climbTabulation(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + 0;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 40;
        System.out.println(climb(n));
        System.out.println("-----------------");
        System.out.println(climbMemoization(n, new int[n + 1]));
        System.out.println("-----------------");
        System.out.println(climbTabulation(n));
    }
}
