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
    /* ---- tabulation method ---- || TC -> O(n * wt) */
    public static int knapsackTabulation(int[] val, int[] w, int wt) {
        // 1. initialization
        int[][] dp = new int[val.length + 1][wt + 1];

        // 2. filling
        // base case --> n = 0 -> 0 || wt = 0 -> 0
        for (int i = 0; i < dp.length; i++) { // 0th column
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {// 0th row
            dp[0][j] = 0;
        }

        // i -- refers to --> values or weights
        for (int i = 1; i < dp.length; i++) {
            // j -- refers to --> weight of knapsack
            for (int j = 1; j < dp[0].length; j++) {
                // i-1th value & weight
                int valTemp = val[i - 1];
                int wTemp = w[i - 1];

                if (wTemp <= j) {
                    int include = valTemp + dp[i - 1][j - wTemp];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        printArray(dp);

        // return last cell
        return dp[val.length][wt];

    }

    /* ---- ---- */
    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] value = { 15, 14, 10, 45, 30 };
        int[] weight = { 2, 5, 1, 3, 4 };
        int wt = 7;

        System.out.println(knapsack(value, weight, wt, value.length));
        System.out.println("---------------------------------------------------------");
        // -----------------------------------------
        int[][] dp = new int[value.length + 1][wt + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(knapsackMemoization(value, weight, dp, wt, value.length));
        printArray(dp);
        System.out.println("---------------------------------------------------------");
        System.out.println(knapsackTabulation(value, weight, wt));
        System.out.println("---------------------------------------------------------");
    }
}