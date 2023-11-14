public class DP03_01Knapsack {

    /* ---- Recursive method ---- || TC -> O(2^n) */
    public static int knapsack(int[] val, int[] w, int wt, int n) {
        // base case -> no value left || max weight reach
        if (n == 0 || wt == 0) {
            return 0;
        }

        // 1. check
        if (w[n - 1] <= wt) {
            // include
            int choice1 = val[n - 1] + knapsack(val, w, wt - w[n - 1], n - 1);
            // exclude
            int choice2 = knapsack(val, w, wt, n - 1);

            // 2. max profit
            return Math.max(choice1, choice2);
        } else {
            return knapsack(val, w, wt, n - 1);
        }
    }

    /* ---- ---- */
    /* ---- Memoization method ---- || TC -> O(n * wt) */
    public static int knapsackMemoization(int[] val, int[] w, int[][] dp, int wt, int n) {
        // base case -> no value left || max weight reach
        if (n == 0 || wt == 0) {
            return 0;
        }

        // dp step
        if (dp[n][wt] != -1) {
            return dp[n][wt];
        }

        // 1. check
        if (w[n - 1] <= wt) {
            // include
            int choice1 = val[n - 1] + knapsackMemoization(val, w, dp, wt - w[n - 1], n - 1);
            // exclude
            int choice2 = knapsackMemoization(val, w, dp, wt, n - 1);

            // 2. max profit
            dp[n][wt] = Math.max(choice1, choice2);
            return dp[n][wt];

        } else {
            dp[n][wt] = knapsackMemoization(val, w, dp, wt, n - 1);
            return dp[n][wt];
        }
    }
    /* ---- ---- */

    public static void main(String[] args) {
        int[] value = { 15, 14, 10, 45, 30 };
        int[] weight = { 2, 5, 1, 3, 4 };
        int wt = 7;

        System.out.println(knapsack(value, weight, wt, value.length));
        // -----------------------------------------
        int[][] dp = new int[value.length + 1][wt + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(knapsackMemoization(value, weight, dp, wt, value.length));
    }
}