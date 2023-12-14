/*
You are given a 0-indexed m x n binary matrix grid.

A 0-indexed m x n difference matrix diff is created with the following procedure:

Let the number of ones in the ith row be onesRowi.
Let the number of ones in the jth column be onesColj.
Let the number of zeros in the ith row be zerosRowi.
Let the number of zeros in the jth column be zerosColj.
diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
Return the difference matrix diff.

 

Example 1:
Input: grid = [[0,1,1],[1,0,1],[0,0,1]]
Output: [[0,0,4],[0,0,4],[-2,-2,2]]
Explanation:
- diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 2 + 1 - 1 - 2 = 0 
- diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 2 + 1 - 1 - 2 = 0 
- diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 2 + 3 - 1 - 0 = 4 
- diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 2 + 1 - 1 - 2 = 0 
- diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 2 + 1 - 1 - 2 = 0 
- diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 2 + 3 - 1 - 0 = 4 
- diff[2][0] = onesRow2 + onesCol0 - zerosRow2 - zerosCol0 = 1 + 1 - 2 - 2 = -2
- diff[2][1] = onesRow2 + onesCol1 - zerosRow2 - zerosCol1 = 1 + 1 - 2 - 2 = -2
- diff[2][2] = onesRow2 + onesCol2 - zerosRow2 - zerosCol2 = 1 + 3 - 2 - 0 = 2

Example 2:
Input: grid = [[1,1,1],[1,1,1]]
Output: [[5,5,5],[5,5,5]]
Explanation:
- diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 3 + 2 - 0 - 0 = 5
- diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 3 + 2 - 0 - 0 = 5
- diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 3 + 2 - 0 - 0 = 5
- diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 3 + 2 - 0 - 0 = 5
- diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 3 + 2 - 0 - 0 = 5
- diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 3 + 2 - 0 - 0 = 5
 

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 105
1 <= m * n <= 105
grid[i][j] is either 0 or 1.
 */

public class Array43_DiffBtwOnesAndZerosInRowAndCol {

    /*-- Brute Force - it can be used in small grids --*/
    // public static int[][] onesMinusZeros(int[][] grid) {
    // int m = grid.length;
    // int n = grid[0].length;

    // int[][] diff = new int[m][n];

    // for (int i = 0; i < m; i++) {
    // for (int j = 0; j < n; j++) {
    // int[] row = checkInRow(i, grid, new int[2]);
    // int[] column = checkInColumn(j, grid, new int[2]);

    // // System.out.println(onesRow + " " + onesColumn + " " + zerosRow + " " +
    // // zerosColumn );

    // diff[i][j] = row[1] + column[1] - row[0] - column[0];
    // }
    // }

    // return diff;
    // }

    // public static int[] checkInRow(int i, int[][] grid, int[] row) {
    // for (int j = 0; j < grid[0].length; j++) {
    // if (grid[i][j] == 0) {
    // row[0]++;
    // }
    // if (grid[i][j] == 1) {
    // row[1]++;
    // }
    // }
    // return row;
    // }

    // public static int[] checkInColumn(int j, int[][] grid, int[] column) {
    // for (int i = 0; i < grid.length; i++) {
    // if (grid[i][j] == 0) {
    // column[0]++;
    // }
    // if (grid[i][j] == 1) {
    // column[1]++;
    // }
    // }
    // return column;
    // }
    /*--------------- --------------- */

    /* Optimal */
    public static int[][] onesMinusZeros(int[][] grid) { // TC -> O(m*n) || SC -> O(m+n)
        int m = grid.length;
        int n = grid[0].length;

        // store row wise & column wise sum
        int[] onesRow = new int[m];
        int[] onesColumn = new int[n];

        // calculate the sum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                onesRow[i] += grid[i][j];
                onesColumn[j] += grid[i][j];
            }
        }

        // get the diff
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /*
                 * formula
                 * i. zero = (m+n) - (onesRow + onesColumn)
                 * ii. diff[i][j] = (onesRow + onesColumn) - zero
                 */
                grid[i][j] = 2 * (onesRow[i] + onesColumn[j]) - (m + n);
            }
        }

        // final answer
        return grid;

    }

    public static void main(String[] args) {

    }
}
