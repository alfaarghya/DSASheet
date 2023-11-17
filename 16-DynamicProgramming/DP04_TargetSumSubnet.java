public class DP04_TargetSumSubnet {
    // TC -> O(n*targetSum) || SC -> O(n * targetSum)
    public static boolean targetSumSubsetTabulation(int[] number, int targetSum) {
        boolean[][] dp = new boolean[number.length + 1][targetSum + 1];

        // base case
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        // i -> number set
        for (int i = 1; i < dp.length; i++) {
            int numberTemp = number[i - 1];
            // j -> current sum
            for (int j = 1; j < dp[0].length; j++) {
                // include
                if (numberTemp <= j && dp[i - 1][j - numberTemp] == true) {
                    dp[i][j] = true;
                    // exclude
                } else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }

        printArray(dp);
        return dp[number.length][targetSum];

    }

    public static void printArray(boolean[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }

    public static void main(String[] args) {
        int[] number = { 4, 2, 7, 1, 3 };
        int targetSum = 10;

        System.out.println(targetSumSubsetTabulation(number, targetSum));
    }
}
