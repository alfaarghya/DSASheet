public class DP05_UnboundedKnapsack {

    public static int unboundedKnapsackTabulation(int[] v, int[] w, int wt) {
        // 1. initialization
        int[][] dp = new int[v.length + 1][wt + 1];
        // 2. base case n == 0 || wt == 0 --> 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        // 3. filling
        // i -- refers to --> values or weights
        for (int i = 1; i < dp.length; i++) {
            // current value & weight
            int vTemp = v[i - 1];
            int wTemp = w[i - 1];
            // j -- refers to --> weight of knapsack
            for (int j = 1; j < dp[0].length; j++) {

                if (wTemp <= j) {
                    int include = vTemp + dp[i][j - wTemp];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        printArray(dp);

        return dp[v.length][wt];
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }

    public static void main(String[] args) {
        int[] value = { 15, 14, 10, 45, 30 };
        int[] weight = { 2, 5, 1, 3, 4 };
        int wt = 7;

        System.out.println(unboundedKnapsackTabulation(value, weight, wt));
    }
}
