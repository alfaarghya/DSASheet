
public class DP01_Fibonacci {

    // recursion
    public static int fib(int n) {
        if (n == 0 || n == 1)
            return n;

        return fib(n - 1) + fib(n - 2);
    }

    // DP-memoization
    public static int fibMemoization(int n, int[] dp) {
        if (n == 0 || n == 1)
            return n;

        if (dp[n] != 0)
            return dp[n];

        dp[n] = fibMemoization(n - 1, dp) + fibMemoization(n - 2, dp);
        return dp[n];
    }

    // DP-tabulation
    public static int fibTabulation(int n) {
        if (n == 0 || n == 1)
            return n;

        // initialize
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        // loop
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // get the ans
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 45;
        System.out.println(fib(n));
        System.out.println("-----------------");
        int[] dp = new int[n + 1];
        System.out.println(fibMemoization(n, dp));
        System.out.println("-----------------");
        System.out.println(fibTabulation(n));
    }
}
