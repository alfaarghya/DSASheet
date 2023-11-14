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

    public static void main(String[] args) {
        int[] value = { 15, 14, 10, 45, 30 };
        int[] weight = { 2, 5, 1, 3, 4 };
        int wt = 7;

        System.out.println(knapsack(value, weight, wt, value.length));
    }
}